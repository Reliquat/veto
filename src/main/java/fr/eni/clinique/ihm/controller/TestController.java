package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;

public class TestController {

	public static void main(String[] args) throws DalException {
		
		AnimalController ac = new AnimalController();
		ClientDAOJdbcImpl clientDao = DaoFactory.clientDao();
		AnimalDAOJdbcImpl animalDao = DaoFactory.animalDao();
		Client client = clientDao.selectById(2);
		Animal animal = animalDao.selectById(3, client);
		//System.out.println(animal);
		ac.createAnimalScreen(client);
	}

}
