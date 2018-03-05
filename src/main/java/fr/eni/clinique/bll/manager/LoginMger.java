package fr.eni.clinique.bll.manager;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;

public interface LoginMger {
	
	Personnel checkLogin(String name, String password) throws BLLException;

//	List<Personnel> getLogin();
	
}
