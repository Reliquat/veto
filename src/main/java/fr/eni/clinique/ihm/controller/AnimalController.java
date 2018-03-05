package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;

public class AnimalController {

	private AnimalManagerImpl animalManager = new AnimalManagerImpl();
	
	public AnimalController() {
		
	}
	
	public Animal insertAnimal(Animal animal) {
		
		try {
			animal = animalManager.insertAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return animal;
	}
	
	public Animal updateAnimal(Animal animal) {
		
		try {
			animal = animalManager.updateAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return animal;
	}
	
	public void deleteAnimal(Animal animal) {

		try {
			animalManager.deleteAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Animal> getAnimauxOfClient(Client client) {
		
		List<Animal> animaux = null;
		
		try {
			animaux = animalManager.getAnimauxOfClient(client);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return animaux;
	}
}
