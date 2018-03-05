package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.event.PersonnelActionEvent;
import fr.eni.clinique.ihm.listener.PersonnelActionListener;
import fr.eni.clinique.ihm.model.PersonnelModel;

public class PersonnelController implements PersonnelActionListener{

	private PersonnelModel personnelModel;
	private PersonnelManager personnelManager = PersonnelManagerImpl.getInstance();
	
	
	
	public PersonnelController(PersonnelModel personnelModel) {
		super();
		this.personnelModel = personnelModel;
	}

	@Override
	public void init() throws Exception {
		
		personnelModel = new PersonnelModel();
		personnelModel.loadPersonnel(personnelManager.getListePersonnel());
	}

	@Override
	public void newPersonnel(Personnel personnel) throws BLLException {
		personnelModel.addPersonnel(personnelManager.addPersonnel(personnel));
	}

	@Override
	public void deletePersonnel(Personnel personnel) throws Exception {
		personnelManager.removePersonnel(personnel);
		personnelModel.removePersonnel(personnel);
	}

	@Override
	public void resetPwdPersonnel(Personnel personnel) throws Exception {
		// TODO Auto-generated method stub
		personnelManager.updatePersonnel(personnel);
		personnelModel.resetPassword(personnel);
	}
	
}
