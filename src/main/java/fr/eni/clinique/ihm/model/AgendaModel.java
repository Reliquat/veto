package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.screen.agenda.AgendaScreen;

public class AgendaModel extends Observable{

	private List<Personnel> personnels = new ArrayList<>();
	
	private AgendaScreen view = AgendaScreen.getInstance();
	
	public void loadPersonnel(List<Personnel> personnels) {
		this.personnels.clear();
		for(Personnel personnel : personnels){
			if(!personnel.isArchive()){
				this.personnels.add(personnel);
			}
		}
		view.update(this, this.personnels);
	}
	
	
	
}
