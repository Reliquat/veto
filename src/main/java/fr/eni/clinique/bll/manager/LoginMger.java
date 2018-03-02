package fr.eni.clinique.bll.manager;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;

public interface LoginMger {
	
	Personnel checkLogin(String name, String password) throws DalException;

//	List<Personnel> getLogin();
	
}
