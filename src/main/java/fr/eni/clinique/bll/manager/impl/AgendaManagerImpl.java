package fr.eni.clinique.bll.manager.impl;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;

public class AgendaManagerImpl implements AgendaManager{

	private AgendaDAOJdbcImpl agendaDao = DaoFactory.agendaDao();
	private AnimalDAOJdbcImpl animalDao = DaoFactory.animalDao();
	private ClientDAOJdbcImpl clientDao = DaoFactory.clientDao();
	
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
		Animal animal = null;
		Client client = null;
		
		try {
			agenda = agendaDao.getAgendaOfPersonnel(personnel, dateRdv);
			for(Agenda a : agenda){
				animal = animalDao.selectById(a.getCodeAnimal().getCodeAnimal());
				client = clientDao.selectById(animal.getClient().getCodeClient());
			}
        } catch (DalException e) {
            throw new BLLException("Erreur récupération liste animaux of client", e);
        }
		
		return agenda;
	}

	
	
}
