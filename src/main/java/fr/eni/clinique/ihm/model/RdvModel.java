package fr.eni.clinique.ihm.model;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.screen.rdv.ScreenRdv;

public class RdvModel {
	private List<Personnel> vetos;
	private List<Client> clients;
	
	public void Init(List<Personnel> vetos, List<Client> clients){
		this.vetos = vetos;
		this.clients = clients;
		ScreenRdv.getInstance().init(clients, vetos);
	}
	
	public void sendAgenda(Personnel personnel){
		ScreenRdv.getInstance().setAgenda(personnel);
	}

	public void addClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	public void addAnimal(Animal animal) {
		// TODO Auto-generated method stub
		
	}
	
}
