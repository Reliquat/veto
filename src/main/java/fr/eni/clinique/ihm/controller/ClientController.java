package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class ClientController implements ClientActionListener{

	private ClientModel model;
	private ScreenRechercheClient screenRechercheClient;
	
    public ClientController(ClientModel model) {
        super();
        this.model = model;
    }
	
	@Override
	public void Rechercher() {
		// TODO Auto-generated method stub
		model.rechercherClient();
	}

	@Override
	public void Ajouter() {
		// TODO Auto-generated method stub
		model.ajouterClient();
	}

	@Override
	public void Supprimer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Valider() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Editer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Annuler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		
		
	}

	
	
	
}
