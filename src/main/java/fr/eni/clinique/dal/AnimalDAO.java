package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DalException;

public interface AnimalDAO {

	Animal insertAnimal(Animal animal) throws DalException;
	
	void updateAnimal(Animal animal) throws DalException;
	
	void deleteAnimal(Animal animal) throws DalException;
	
	Animal selectById(int CodeAnimal) throws DalException;
	
	List<Animal> getAnimauxOfClient(Client client) throws DalException;
	
	List<String> getRaces() throws DalException;
	
	List<String> getEspecesByRace(String race) throws DalException;
}
