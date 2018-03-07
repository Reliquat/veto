package fr.eni.clinique;

import javax.swing.SwingUtilities;

import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.AgendaController;
import fr.eni.clinique.ihm.model.AgendaModel;
import fr.eni.clinique.ihm.screen.agenda.AgendaScreen;

public class Main {
	public static void main(String[] args) {
		try {
			
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	
	            	/*LoginScreen.main(args);
	            	
	            	
	            	LoginModel loginModel = new LoginModel();
	            	LoginController loginController = new LoginController(loginModel);
	            	
	            	LoginScreen logScreen = new LoginScreen(AppConstants.APP_NAME);
	                
	                logScreen.setVisible(true);
	                logScreen.setLocationRelativeTo(null);
	                logScreen.setActionListener(loginController);
	                
	                ScreenClient custScreen = new ScreenClient(AppConstants.APP_NAME);
	                
	                custScreen.main(args);*/
	            	
	            	AgendaModel agendaModel = new AgendaModel();
	            	AgendaController agendaController = new AgendaController(agendaModel);
	            	
	            	AgendaScreen agendaScreen = new AgendaScreen();
	            	
	            	agendaScreen.frmAgenda.setVisible(true);
	            	agendaScreen.frmAgenda.setLocationRelativeTo(null);
	            	
	            }
	        });
	    } catch (Exception e) {
	        throw new TechnicalException("Erreur Technique", e);
	    }
	}
}
