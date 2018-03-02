package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;
import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.model.ClientModel;

public class ClientController implements ClientActionListener{

	private ClientModel model;
	private PersonnelDAOJdbcImpl personnelDAO;
    public ClientController(ClientModel model) {
        super();
        this.model = model;
    }
	
	@Override
	public void Rechercher() {
		
		model.rechercherClient();
	}

	@Override
	public void Ajouter() {
		
		model.ajouterClient();
	}

	@Override
	public void Supprimer(int CodePers) throws DalException {
		
		personnelDAO.deletePersonnel(CodePers);
	}

	@Override
	public void Valider(String CodePers) {
		
		
	}

	@Override
	public void Editer(String CodePers) {
		
		
	}

	@Override
	public void Annuler() {
		
		
	}

	@Override
	public void init() {
		
		
	}

	
	
	
}
