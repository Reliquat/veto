package fr.eni.clinique;

import javax.swing.SwingUtilities;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.AppConstants;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.AccueilController;
import fr.eni.clinique.ihm.controller.LoginController;
import fr.eni.clinique.ihm.controller.PersonnelController;
import fr.eni.clinique.ihm.model.LoginModel;
import fr.eni.clinique.ihm.model.PersonnelModel;
import fr.eni.clinique.ihm.screen.admin.AdminScreen;
import fr.eni.clinique.ihm.screen.login.LoginScreen;

public class Main {
	public static void main(String[] args) {
		try {
			
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {

	            	LoginModel loginModel = new LoginModel();
	            	LoginController loginController = new LoginController(loginModel);
	            	LoginScreen loginScreen = new LoginScreen(AppConstants.APP_NAME);

	                loginScreen.setVisible(true);
	                loginScreen.setLocationRelativeTo(null);
	                loginScreen.setActionListener(loginController);
	            }
	        });
	        
	    } catch (Exception e) {
	        throw new TechnicalException("Erreur Technique", e);
	    }
	}
	
	public static void launchApp(Personnel personnel) {
		
		new AccueilController();
    	
		switch (personnel.getRole()) {

			case "sec":
                break;
                
			case "vet":
				break;
				
			case "adm":
				AdminScreen adminScreen = new AdminScreen();
				PersonnelModel personnelModel = new PersonnelModel();
				PersonnelController personnelController = new PersonnelController(personnelModel);
				adminScreen.setActionListener(personnelController);
				adminScreen.frmGestionDuPersonnel.setVisible(true);
				break;
		}
    }
}
