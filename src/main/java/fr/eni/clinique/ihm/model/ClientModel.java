package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.client.ScreenAjoutClient;
import fr.eni.clinique.ihm.screen.client.ScreenClient;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class ClientModel extends Observable{

	private List<Client> clients = new ArrayList<>();
    public boolean dataChanged;
	private ScreenRechercheClient rechercheScreen;
	private ScreenClient screenClient = ScreenClient.getInstance();

	 public void rechercherClient(List<Client> clients) {

    	this.rechercheScreen.setResult(clients);
    }
	
	public void ajouterClient(Client client) {
		this.screenClient.update(this, client);
	}
    
    public void loadClient(List<Client> clients) {
    	this.clients = clients;
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

	public void getRechercheScreen(ScreenRechercheClient screen) {
		// TODO Auto-generated method stub
		this.rechercheScreen = screen; 
	}
	
}
