package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.client.ScreenAjoutClient;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class ClientModel extends Observable{

	private List<Client> clients = new ArrayList<>();
    public boolean dataChanged;
	
    public void rechercherClientScreen() {
    	ScreenRechercheClient.main();
    }
    
    public void rechercherClient() {
    	
    }
	
	public void ajouterClient() {
		ScreenAjoutClient.main();
	}
    
    public void loadClient(List<Client> clients) {
    	this.clients = clients;
    }

    
    public void addClient(Client Client) {
    	clients.add(Client);
    }

    public void removeCurrentClient(int index) {
    	clients.remove(index);
    }

    /**
     * @return the dataChanged
     */
    public boolean hasDataChanged() {
        return dataChanged;
    }
    
    protected void setDataChanged() {
        dataChanged = true;
    }
    
    protected void clearDataChanged() {
        dataChanged = false;
    }
	
}
