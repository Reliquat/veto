package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.ihm.screen.accueil.AccueilScreen;
import fr.eni.clinique.ihm.screen.admin.AdminScreen;
import fr.eni.clinique.ihm.screen.agenda.AgendaScreen;
import fr.eni.clinique.ihm.screen.client.ScreenClient;
import fr.eni.clinique.ihm.screen.login.LoginScreen;

public class AccueilController {

	AccueilScreen accueilScreen;
	LoginScreen loginScreen;
	AgendaScreen agendaScreen;
	AdminScreen adminScreen;
	ScreenClient clientScreen;
	
	public AccueilController() {
		accueilScreen = new AccueilScreen(this);
	}
	
	public void openAdminScreen() {
		adminScreen = new AdminScreen();
		adminScreen.frmGestionDuPersonnel.setVisible(true);
	}
	
	public void openClientScreen() {
		clientScreen = ScreenClient.getInstance();
	}
}