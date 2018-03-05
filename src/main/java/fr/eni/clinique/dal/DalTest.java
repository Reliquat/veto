package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

public class DalTest {

	public static void main(String[] args) throws DalException {

		ConnexionDAOJdbcImpl connexionDao = DaoFactory.connexionDao();
		PersonnelDAOJdbcImpl personnelDao = DaoFactory.personnelDao();
		AnimalDAOJdbcImpl animalDao = DaoFactory.animalDao();
		ClientDAOJdbcImpl clientDao = DaoFactory.clientDao();
		
//		Personnel personnel = new Personnel();
//		personnel.setNom("lol");
//		personnel.setMotPasse("jj");
//		personnel.setArchive(false);
//		personnel.setRole("jsp");
		
		//personnel = personnelDao.insertPersonnel(personnel);
		//System.out.println(personnel.toString());
		
//		Client client = new Client();
//		client.setNomClient("nom");
//		client.setPrenomClient("prenom");
//		client.setAdresse1("adresse1");
//		client.setAdresse2("adresse2");
//		client.setCodePostal("44000");
//		client.setVille("ville");
//		client.setNumTel("0202020202");
//		client.setAssurance("assurance");
//		client.setEmail("email");
//		client.setRemarque("remarque");
//		client.setArchive(false);
		
		//client = clientDao.insertClient(client);
		
//		Client client = clientDao.selectById(2);
//		
//		Animal animal = new Animal();
//		
//		animal.setNomAnimal("nomAnimal2");
//		animal.setSexe("M");
//		animal.setCouleur("couleur2");
//		animal.setRace("Panda");
//		animal.setEspece("Panda Roux");
//		animal.setClient(client);
//		animal.setTatouage("tatouage2");
//		animal.setAntecedents("antecedents2");
//		animal.setArchive(false);
//		
//		animal = animalDao.insertAnimal(animal);
		
		Client client = clientDao.selectById(2);
		List<Animal> animauxClient = animalDao.getAnimauxOfClient(client);
		
		System.out.println(animauxClient);
	}
}
