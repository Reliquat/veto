package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bo.Personnel;

public interface LoginMger {

	List<Personnel> getLogin();
    
	Personnel addPersonnel(Personnel personnel);
    
    void updatePersonnel(Personnel personnel);
    
    void removePersonnel(Personnel personnel);
	
}
