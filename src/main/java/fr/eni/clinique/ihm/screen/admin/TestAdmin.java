package fr.eni.clinique.ihm.screen.admin;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fr.eni.clinique.ihm.controller.PersonnelController;
import fr.eni.clinique.ihm.model.PersonnelModel;

public class TestAdmin {

	public static void main(String[] args) {

try {
            
            // Appliquer le Look And Feel Windows
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    
                    // Create A personnel Model.
                    PersonnelModel personnelModel = new PersonnelModel();
                    
                    // Create A personnel controller
                    PersonnelController personnelController = new PersonnelController(personnelModel);
                    
                    // Create A admin View
                    AdminScreen screen = new AdminScreen();
                    
                    // The View Observes the Model.
                    personnelModel.addObserver(screen);
                    
                    screen.setActionListener(personnelController);
                    
                    screen.frmGestionDuPersonnel.setVisible(true);
                    
                    
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
