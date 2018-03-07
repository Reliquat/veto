package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.screen.admin.adminScreen;

public class PersonnelModel extends Observable {

	private List<Personnel> personnels = new ArrayList<>();
	private adminScreen view = adminScreen.getInstance();
	public boolean dataChanged;

	public PersonnelModel() {
		super();
	}

	public void loadPersonnel(List<Personnel> personnels) {
		this.personnels.clear();
		for(Personnel personnel : personnels){
			if(!personnel.isArchive()){
				this.personnels.add(personnel);
			}
		}
		view.update(this, this.personnels);
	}

	public void addPersonnel(Personnel personnel) {
		personnels.add(personnel);
		view.update(this, this.personnels);
	}

	public void removePersonnel(Personnel personnel) {
		personnels.remove(personnel);
		view.update(this, personnels);
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

	public void resetPassword(Personnel personnel) {
		// TODO Auto-generated method stub
		for(Personnel oldPersonnel : this.personnels){
			if (oldPersonnel.getCodePers() == personnel.getCodePers()){
				oldPersonnel = personnel;
			}
		}
		view.update(this, this.personnels);
	}

}
