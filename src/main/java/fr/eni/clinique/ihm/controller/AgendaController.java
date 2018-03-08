package fr.eni.clinique.ihm.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.AgendaManagerImpl;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.listener.AgendaActionListener;
import fr.eni.clinique.ihm.model.AgendaModel;

public class AgendaController implements AgendaActionListener{

	private AgendaModel agendaModel;
	private AgendaManager agendaManager = AgendaManagerImpl.getInstance();
	private List<Personnel> personnels = new ArrayList<>();
	private PersonnelManager personnelManager = PersonnelManagerImpl.getInstance();
	
	@Override
	public void init() throws Exception {
		
		agendaModel = new AgendaModel();
		agendaModel.loadPersonnel(personnelManager.getListeVeto());
		
	}
	
    public AgendaController(AgendaModel model) {
        super();
        this.agendaModel = model;
    }

	@Override
	public List<Personnel> getListeVeto() throws BLLException {
		
		return personnelManager.getListeVeto();
		
	}

	@Override
	public List<Agenda> getAgendaOfPersonnel(Personnel personnel, Date dateRdv) throws BLLException{
		
		return agendaManager.getAgendaOfPersonnel(personnel, dateRdv);
		
	}

	@Override
	public List<Personnel> selectByName(String name) throws BLLException {
		
		return personnelManager.selectByName(name);
		
	}	
}
