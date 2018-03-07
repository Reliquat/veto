package fr.eni.clinique.ihm.screen.client;

import fr.eni.clinique.ihm.controller.ClientController;
import fr.eni.clinique.ihm.model.ClientModel;

public class TestClient {

	public static void main(String[] args) {
		
		ScreenClient screenClient = new ScreenClient("Clients");
		
		ClientModel clientModel = new ClientModel();
		ClientController clientController = new ClientController(clientModel);
		
		screenClient.setActionListener(clientController);
	}

}
