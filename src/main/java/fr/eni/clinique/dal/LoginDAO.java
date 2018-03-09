package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;

public interface LoginDAO {

	Personnel selectByName(String name) throws DalException;
	
	Personnel login(String nom, String motPasse) throws DalException;
}
