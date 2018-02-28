package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Personnel;


public class PersonnelModel extends Observable {


    private List<Personnel> personnels = new ArrayList<>();
    public boolean dataChanged;

    public void loadPersonnel(List<Personnel> personnels) {
    	this.personnels = personnels;
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
