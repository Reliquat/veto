package fr.eni.clinique.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.ihm.screen.animal.GestionAnimalScreen;
import fr.eni.clinique.ihm.screen.client.ScreenClient;

public class AnimalController {

	private AnimalManager animalManager;
	private ClientManager clientManager;
	private GestionAnimalScreen gestionAnimalScreen;
	private List<String> races;
	
	private static AnimalController instance;
	
    public static AnimalController getInstance() {
        if(instance == null) {
            instance = new AnimalController();
        }
        return instance;
    }
	
	public AnimalController() {
		
		animalManager = ManagerFactory.animalManager();
		clientManager = ManagerFactory.clientManager();
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
		animal.setAntecedents("");
		animal.setArchive(false);
		animal.setSexe("H");
		races = getRaces();
		gestionAnimalScreen = new GestionAnimalScreen(this, animal, races);
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
		gestionAnimalScreen.hide();
	}
	
	public void updateAnimalScreen(Animal animal) {

		races = getRaces();
		gestionAnimalScreen = new GestionAnimalScreen(this, animal, races);
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
		gestionAnimalScreen.hide();
	}
	
	public void updateAnimal(Animal animal) {
		
		try {
			animalManager.updateAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAnimal(Animal animal) {

		try {
			animalManager.deleteAnimal(animal);
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getRaces() {
		
		List<String> races = new ArrayList<String>();
		
		try {
			races = animalManager.getRaces();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return races;
	}
	
	public List<String> getEspecesFromRace(String race) {
		
		List<String> especes = new ArrayList<String>();
		
		try {
			especes = animalManager.getEspecesByRace(race);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return especes;
	}
	
	public void exitScreen() {
		gestionAnimalScreen.hide();
	}
	
	public Animal getAnimalById(int id) {
		
		Animal animal = null;
		
		try {
			animal = animalManager.getAnimalById(id);
			animal.setClient(clientManager.getById(animal.getClient().getCodeClient()));
			
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return animal;
	}
	
	public void archiveAnimal(Animal animal) {
		
		animal.setArchive(true);
		
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
	}
}
