package fr.eni.clinique.ihm.model;

import java.util.Observable;

import fr.eni.clinique.ihm.screen.client.ScreenAjoutClient;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class ClientModel extends Observable{

	private ScreenRechercheClient screenRechercheClient;
	
    public void rechercherClient() {
    	screenRechercheClient.main();
    }
	
	public void ajouterClient() {
		ScreenAjoutClient.main();
	}
    
}
