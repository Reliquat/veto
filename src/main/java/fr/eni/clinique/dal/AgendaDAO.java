package fr.eni.clinique.dal;

import java.sql.Timestamp;
import java.util.List;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;

public interface AgendaDAO {
	
	List<Agenda> getRdvOfPersonnel(Personnel personnel, String dateRdv) throws DalException;
}
