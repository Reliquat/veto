package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.animal.ScreenGestionAnimal;
import fr.eni.clinique.ihm.screen.client.ScreenClient;

public class AnimalController {

	private AnimalManager animalManager;
	ScreenGestionAnimal screenGestionAnimal;
	
	private static AnimalController instance;
	
    public static AnimalController getInstance() {
        if(instance == null) {
            instance = new AnimalController();
        }
        return instance;
    }
	
	public AnimalController() {
		
		animalManager = ManagerFactory.animalManager();
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
		screenGestionAnimal = new ScreenGestionAnimal(this, animal);
	}
	
	public void createAnimalSubmit(Animal animal) {
		
		try {
			System.out.println(animal);
			animal = animalManager.insertAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Client client = animal.getClient();
		try {
			client.setAnimaux(animalManager.getAnimauxOfClient(client));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		ScreenClient.getInstance().update(null, animal.getClient());
		screenGestionAnimal.hide();
	}
	
	public void updateAnimalScreen(Animal animal) {

		screenGestionAnimal = new ScreenGestionAnimal(this, animal);
	}
	
	public void updateAnimalSubmit(Animal animal) {
		
		try {
			animalManager.updateAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		Client client = animal.getClient();
		try {
			client.setAnimaux(animalManager.getAnimauxOfClient(client));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		ScreenClient.getInstance().update(null, client);
		screenGestionAnimal.hide();
	}
	
	public void deleteAnimal(Animal animal) {

		try {
			animalManager.deleteAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}
