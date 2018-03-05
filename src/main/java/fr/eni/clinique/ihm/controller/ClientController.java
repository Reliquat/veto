package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bll.manager.impl.ClientManagerImpl;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.event.ClientActionEvent;
import fr.eni.clinique.ihm.listener.ClientActionListener;
import fr.eni.clinique.ihm.model.ClientModel;

public class ClientController implements ClientActionListener{

	private ClientModel clientModel;
	private ClientManager clientManager = ClientManagerImpl.getInstance();
	
    public ClientController(ClientModel model) {
        super();
        this.clientModel = model;
    }
	
	@Override
	public void RechercherClientScreen() {
		
		clientModel.rechercherClientScreen();
	}

	@Override
	public void AjouterClient() {
		
		clientModel.ajouterClient();
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

	@Override
	public void EditerClient(ClientActionEvent event) {
		
		
	}

	@Override
	public void init() {
		
		
	}

	@Override
	public void ValiderAjoutClient(ClientActionEvent event) throws DalException {
		
		List<Client> client;
		try {
			client = clientManager.getListeClient();
			clientModel.loadClient(client);	
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Client getByName(String name) throws BLLException {
		return clientManager.getByName(name);
	}

	@Override
	public void RechercherClient(String name) {
		
		try {
			clientManager.getByName(name);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
