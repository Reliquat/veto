package fr.eni.clinique.ihm.listener;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;

public interface AgendaActionListener {

	void init() throws Exception;
	
	List<Personnel> getListeVeto() throws BLLException ;
	
	void getAgendaOfPersonnel(Personnel personnel, Date dateRdv) throws BLLException ;
	
}
