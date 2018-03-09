package fr.eni.clinique.bll.manager;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Personnel;

public interface AgendaManager {

	List<Agenda> getAgendaOfPersonnel(Personnel personnel, String dateRdv) throws BLLException;

	void ajoutRdv(Agenda agenda, Personnel personnel) throws BLLException;
	
	void deleteRdv(Agenda agenda, Personnel personnel) throws BLLException;
	
	Agenda getAgendaWithRow(int rowNumber) throws BLLException;
}
