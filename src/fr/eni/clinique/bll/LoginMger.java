package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Personnels;

public interface LoginMger {

	List<Personnels> getLogin();
    
	Personnels addPersonnel(Personnels personnel);
    
    void updatePersonnel(Personnels personnel);
    
    void removePersonnel(Personnels personnel);
	
}
