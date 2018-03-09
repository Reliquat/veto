package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;

public interface PersonnelDAO {

	Personnel selectById(int id) throws DalException;
	
	List<Personnel> selectByName(String name) throws DalException;
	
	List<Personnel> selectByRole(String role) throws DalException;
	
	List<Personnel> selectAll() throws DalException;
	
	Personnel insertPersonnel(Personnel personnel) throws DalException;
	
	void updatePersonnel(Personnel personnel) throws DalException;
	
	void deletePersonnel(Integer CodePers) throws DalException;
}
