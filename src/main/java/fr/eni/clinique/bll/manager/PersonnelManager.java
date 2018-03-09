package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;

public interface PersonnelManager {

	List<Personnel> getListePersonnel() throws BLLException;
    
	Personnel addPersonnel(Personnel personnel) throws BLLException;
    
    void updatePersonnel(Personnel personnel) throws BLLException;
    
    void removePersonnel(Personnel personnel) throws BLLException;
	
    List<Personnel> getListeVeto() throws BLLException;
    
    List<Personnel> selectByName(String name) throws BLLException;
}
