package fr.eni.clinique.bll.manager.impl;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl;

public class AgendaManagerImpl implements AgendaManager{

	private AgendaDAOJdbcImpl agendaDao = DaoFactory.agendaDao();
	
	private static AgendaManagerImpl instance;
	
    public static AgendaManagerImpl getInstance() {
        if(instance == null) {
            instance = new AgendaManagerImpl();
        }
        return instance;
    }
	
	@Override
	public List<Agenda> getAgendaOfPersonnel(Personnel personnel, Date dateRdv) throws BLLException {
		
		List<Agenda> agenda = null;
		
		try {
			agenda = agendaDao.getAgendaOfPersonnel(personnel, dateRdv);
        } catch (DalException e) {
            throw new BLLException("Erreur récupération liste animaux of client", e);
        }
		
		return agenda;
	}

	
	
}
