package fr.eni.clinique.ihm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.ihm.screen.animal.ScreenGestionAnimal;

public class AnimalModel extends Observable {

	private List<Animal> animaux = new ArrayList<>();

	public AnimalModel() {
		super();
	}
	
	public void addAnimal(Animal animal) {
		animaux.add(animal);
	}
}
