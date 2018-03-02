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
		this.personnels = personnels;
		view.update(this, this.personnels);
	}

	public void addPersonnel(Personnel personnel) {
		personnels.add(personnel);
	}

	public void removeCurrentPersonnel(int index) {
		personnels.remove(index);
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
