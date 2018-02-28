package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface PersonnelManager {

	List<Personnel> getListePersonnel();
    
	Personnel addPersonnel(Personnel personnel);
    
    void updatePersonnel(Personnel personnel);
    
    void removePersonnel(Personnel personnel);
	
}
