package fr.eni.clinique.ihm.model;

import java.util.Observable;

import fr.eni.clinique.ihm.screen.adminScreen;

public class LoginModel extends Observable{

	public void ConnexionPage(){
		
		adminScreen.main(null);
		
	}
	
	
}
