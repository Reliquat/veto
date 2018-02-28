package fr.eni.clinique.dal;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DalTest {

	public static void main(String[] args) throws DalException {

		ConnexionDAOJdbcImpl connexionDao = DaoFactory.connexionDao();
		PersonnelDAOJdbcImpl personnelDao = DaoFactory.personnelDao();
		
		Personnel personnel = new Personnel();
		personnel.setNom("lol");
		personnel.setMotPasse("jj");
		personnel.setArchive(false);
		personnel.setRole("jsp");
		
		personnel = personnelDao.insertPersonnel(personnel);

		System.out.println(personnel.toString());
	}
}
