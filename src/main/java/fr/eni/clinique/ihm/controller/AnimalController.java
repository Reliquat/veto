package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.animal.ScreenGestionAnimal;
import fr.eni.clinique.ihm.screen.client.ScreenClient;

public class AnimalController {

	private AnimalManagerImpl animalManager = new AnimalManagerImpl();
	private ScreenGestionAnimal screenGestionAnimal = new ScreenGestionAnimal();
	
	public AnimalController() {
		
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
	
	public void createAnimalScreen(Client client) {

		Animal animal = new Animal();
		animal.setCodeAnimal(-1);
		animal.setClient(client);
		screenGestionAnimal.initialize(animal);
	}
	
	public void createAnimalSubmit(Animal animal) {
		
		try {
			animal = animalManager.insertAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		ScreenClient.getInstance().update(null, animal.getClient());
		
	}
	
	public void updateAnimalScreen(Animal animal) {

		screenGestionAnimal.initialize(animal);
	}
	
	public Animal updateAnimalSubmit(Animal animal) {
		
		try {
			animal = animalManager.updateAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Client client = animal.getClient();
		client.setAnimaux(animalManager.getAnimauxOfClient(client));
		List<Animal> animaux = animalManager.getAnimauxOfClient(animal.getClient());
		animal.getClient().setAnimaux(animaux);
		ScreenClient.getInstance().update(null, animal.getClient().);
	}
	
	public void deleteAnimal(Animal animal) {

		try {
			animalManager.deleteAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}
