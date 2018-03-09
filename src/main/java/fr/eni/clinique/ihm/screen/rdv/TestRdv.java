package fr.eni.clinique.ihm.screen.rdv;

import fr.eni.clinique.ihm.controller.RdvController;
import fr.eni.clinique.ihm.model.RdvModel;

public class TestRdv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create A admin View
        ScreenRdv screen = new ScreenRdv();
		// Create A personnel Model.
        RdvModel personnelModel = new RdvModel();
        
        // Create A personnel controller
        RdvController personnelController = new RdvController(personnelModel);
        
        screen.setActionListener(personnelController);

	}

}
