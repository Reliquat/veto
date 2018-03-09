package fr.eni.clinique.ihm.screen.agenda;

import fr.eni.clinique.ihm.controller.AgendaController;
import fr.eni.clinique.ihm.model.AgendaModel;

public class Osef {

	public static void main(String[] args) {

    	AgendaModel agendaModel = new AgendaModel();
    	AgendaController agendaController = new AgendaController(agendaModel);
    	AgendaScreen agendaScreen = new AgendaScreen();

        agendaScreen.frmAgenda.setVisible(true);
        agendaScreen.frmAgenda.setLocationRelativeTo(null);
        agendaScreen.setActionListener(agendaController);
	}
}
