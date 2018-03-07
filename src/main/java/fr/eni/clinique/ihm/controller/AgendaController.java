package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.ihm.model.AgendaModel;

public class AgendaController {

	private AgendaModel agendaModel;
	private AgendaManager agendaManager = ManagerFactory.agendaManager();
	
    public AgendaController(AgendaModel model) {
        super();
        this.agendaModel = model;
    }
	
}
