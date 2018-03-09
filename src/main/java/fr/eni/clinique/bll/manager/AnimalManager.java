package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public interface AnimalManager {

	List<Animal> getAnimauxOfClient(Client client) throws BLLException;
	
	Animal insertAnimal(Animal animal) throws BLLException;
	
	void updateAnimal(Animal animal) throws BLLException;
	
	void deleteAnimal(Animal animal) throws BLLException;
	
	List<String> getRaces() throws BLLException;
	
	List<String> getEspecesByRace(String race) throws BLLException;
	
	Animal getAnimalById(int id) throws BLLException;
}
