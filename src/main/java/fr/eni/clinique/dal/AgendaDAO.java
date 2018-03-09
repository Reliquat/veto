package fr.eni.clinique.dal;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;

public interface AgendaDAO {
	
	List<Agenda> getAgendaOfPersonnel(Personnel personnel, Date dateRdv) throws DalException;
}
