package fr.eni.clinique.ihm.controller;

import java.util.Date;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.ClientManagerImpl;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.listener.AgendaActionListener;
import fr.eni.clinique.ihm.model.RdvModel;

public class RdvController implements AgendaActionListener{
	ClientManager clientManager = ClientManagerImpl.getInstance();
	AgendaManager agendaManager = ManagerFactory.agendaManager();
	AnimalManager animalManager = new AnimalManagerImpl();
	
	RdvModel model;
	
	public void addRdv(Agenda agenda, Personnel personnel){
		
	}
	
	public void addClient(Client client){
		try {
			model.addClient(clientManager.addClient(client));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addAnimal(Animal animal){
		try {
			model.addAnimal(animalManager.insertAnimal(animal));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getRdvJour(Personnel veto, Date date){
		
	}
	
	public void deleteRdv(Agenda agenda, Personnel personnel){
		
	}
}
