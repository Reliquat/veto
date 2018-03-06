package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.ClientManagerImpl;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.event.ClientActionEvent;
import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class ClientController implements ClientActionListener{

	private ClientModel clientModel;
	private ClientManager clientManager = ClientManagerImpl.getInstance();
	private List<Client> clients;
	private AnimalManager animalManager = new AnimalManagerImpl();
	
    public ClientController(ClientModel model) {
        super();
        this.clientModel = model;
        
        try {
			this.clients = clientManager.getListeClient();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        this.clientModel.loadClient(this.clients);
    }
    
	@Override
	public void RechercherClientScreen(String nom) {
		
		try {
			List<Client> searchClient = clientManager.getByName(nom);
			
			for(Client client : searchClient){
				client.setAnimaux(this.animalManager.getAnimauxOfClient(client));
			}
			clientModel.rechercherClient(searchClient);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void AjouterClient(Client client) {
		
		clientModel.ajouterClient(client);
	}

	@Override
	public void SupprimerClient(ClientActionEvent event) throws DalException {
		
		if(event.getClient().getCodeClient() != 0){
			try {
				clientManager.removeClient(event.getClient());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void ValiderClient(ClientActionEvent event) {
		
	}
	
	public void fireRechercheClient(ScreenRechercheClient screen){
		this.clientModel.getRechercheScreen(screen);
	}

	@Override
	public void setRecherche(ScreenRechercheClient screen) {
		// TODO Auto-generated method stub
		this.clientModel.getRechercheScreen(screen);
	}
}
