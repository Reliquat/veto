package fr.eni.clinique.ihm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.ClientManagerImpl;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.event.ClientActionEvent;
import fr.eni.clinique.ihm.listener.RdvActionListener;
import fr.eni.clinique.ihm.model.RdvModel;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public class RdvController implements RdvActionListener {
	ClientManager clientManager = ClientManagerImpl.getInstance();
	AgendaManager agendaManager = ManagerFactory.agendaManager();
	AnimalManager animalManager = new AnimalManagerImpl();
	PersonnelManager personnelManager = ManagerFactory.personnelManager();
	RdvModel model;

	public RdvController(RdvModel model) {
		super();
		this.model = model;
		List<Client> clients = new ArrayList<>();
		List<Personnel> vetos = new ArrayList<>();
		try {
			clients = clientManager.getListeClient();
			for (Client client : clients){
				client.setAnimaux(animalManager.getAnimauxOfClient(client));
			}
			vetos = personnelManager.getListeVeto();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.Init(vetos, clients);
	}

	public void addRdv(Agenda agenda, Personnel personnel) {

	}

	public void addClient(Client client) {
		try {
			model.addClient(clientManager.addClient(client));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAnimal(Animal animal) {
		try {
			model.addAnimal(animalManager.insertAnimal(animal));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getRdvJour(Personnel veto, Date date) {
		agendaManager.getAgendaOfPersonnel(veto, date);
	}

	public void deleteRdv(Agenda agenda, Personnel personnel) {

	}

	@Override
	public void RechercherClientScreen(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AjouterClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SupprimerClient(Client client) throws DalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ValiderClient(ClientActionEvent event) throws DalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRecherche(ScreenRechercheClient screen) {
		// TODO Auto-generated method stub
		
	}
}
