package fr.eni.clinique.ihm.model;

import java.util.Observable;

import fr.eni.clinique.ihm.screen.admin.AdminScreen;

public class LoginModel extends Observable{

	public void ConnexionPage(){
		
		AdminScreen adminScreen = new AdminScreen();
		adminScreen.frmGestionDuPersonnel.setVisible(true);
		
		
		
	}
	
	
}
