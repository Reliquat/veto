package fr.eni.clinique.ihm.model;

import java.util.Observable;

import fr.eni.clinique.ihm.screen.admin.adminScreen;

public class LoginModel extends Observable{

	public void ConnexionPage(){
		
		adminScreen adminScreen = new adminScreen();
		adminScreen.frmGestionDuPersonnel.setVisible(true);
		
		
		
	}
	
	
}
