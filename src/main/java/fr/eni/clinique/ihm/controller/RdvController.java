package fr.eni.clinique.ihm.controller;

import java.util.Date;

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
import fr.eni.clinique.ihm.listener.AgendaActionListener;
import fr.eni.clinique.ihm.listener.RdvActionListener;
import fr.eni.clinique.ihm.model.RdvModel;

public class RdvController implements RdvActionListener{
	ClientManager clientManager = ClientManagerImpl.getInstance();
	AgendaManager agendaManager = ManagerFactory.agendaManager();
	AnimalManager animalManager = new AnimalManagerImpl();
	PersonnelManager personnelManager = ManagerFactory.personnelManager();
	
	RdvModel model;
	
	public RdvController(RdvModel model) {
		super();
		this.model = model;
		try {
			model.Init(personnelManager.getListeVeto(), clientManager.getListeClient());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
		java.sql.Date dateSql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDate()); 
		try {
			
			veto.setAgenda(agendaManager.getAgendaOfPersonnel(veto, dateSql));
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteRdv(Agenda agenda, Personnel personnel){
		
	}
}
