package fr.eni.clinique;

import javax.swing.SwingUtilities;

import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.ihm.controller.AnimalController;
import fr.eni.clinique.ihm.controller.ClientController;
import fr.eni.clinique.ihm.model.AnimalModel;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.screen.animal.ScreenGestionAnimal;
import fr.eni.clinique.ihm.screen.client.ScreenClient;

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
	            	
	            	/*AgendaScreen agendaScreen = new AgendaScreen();
	            	
	            	AgendaModel agendaModel = new AgendaModel();
	            	AgendaController agendaController = new AgendaController(agendaModel);
	            	
	            	agendaScreen.setActionListener(agendaController);
	            	
	            	agendaScreen.frmAgenda.setVisible(true);
	            	agendaScreen.frmAgenda.setLocationRelativeTo(null);*/
	            	
	            	ScreenClient screenClient = new ScreenClient("Clients");
	        		
	        		ClientModel clientModel = new ClientModel();
	        		ClientController clientController = new ClientController(clientModel);
	        		
	        		screenClient.setActionListener(clientController);
	            	
	            	
	            }
	        });
	    } catch (Exception e) {
	        throw new TechnicalException("Erreur Technique", e);
	    }
	}
}
