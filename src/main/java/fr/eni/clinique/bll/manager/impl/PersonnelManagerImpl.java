package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.dal.exception.DalException;

public class PersonnelManagerImpl implements PersonnelManager{

	private PersonnelDAO personnelDAO =  DaoFactory.personnelDAO();
	
	private static PersonnelManagerImpl instance;
    
    private PersonnelManagerImpl() {
        
    }
    
    public static PersonnelManagerImpl getInstance() {
        if(instance == null) {
            instance = new PersonnelManagerImpl();
        }
        return instance;
    }

	@Override
	public List<Personnel> getListePersonnel() {
		List<Personnel> personnels = null;
        
        try {
            personnels = personnelDAO.selectAll();
            
        } catch (DALException e) {
            throw new BLLException("Erreur récupération liste personnel", e);
        }
        
        return personnels;
	}

	@Override
	public Personnel addPersonnel(Personnel personnel) {
		
		if(personnel.getCodePers() != 0 ) {
            throw new BLLException("Personnel deja existant.");
        }
        
        try {
        	validerPersonnel(personnel);
            
            personnel = personnelDAO.insert(personnel);
            
        } catch (DalException e) {
            throw new BLLException("Echec addPersonnel", e);
        }
        return personnel;
	}

	@Override
	public void updatePersonnel(Personnel personnel) {
		
		try {
            validerPersonnel(personnel);
            
            personnelDAO.update(personnel);
            
        } catch (DalException e) {
            throw new BLLException(String.format("Echec updatePersonnel-personnel: %s", personnel), e);
        }
	}

	@Override
	public void removePersonnel(Personnel personnel) {
		
		try {
            personnelDAO.delete(personnel.getCodePers());
            
        } catch (DalException e) {
            throw new BLLException("Echec de la suppression du personnel - ", e);
        }
	}
	
    private void validerPersonnel(Personnel personnel) throws BLLException {

        try {
            ObjectUtil.checkNotNullWithMessage(personnel, "Une erreur technique est survenue");
            ObjectUtil.checkNotNullWithMessage(personnel.getMotPasse(), "Le Mot de Passe est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(personnel.getNom(), "Le nom est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(personnel.getRdv(), "Le Rendez-vous est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(personnel.getRole(), "Le Rôle est obligatoire");                  
        } catch (IllegalArgumentException e) {
            throw new BLLException(String.format("Erreur de validation : %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }
}
