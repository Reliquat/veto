package fr.eni.clinique.ihm.listener;

import java.util.Date;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.event.ClientActionEvent;
import fr.eni.clinique.ihm.screen.client.ScreenRechercheClient;

public interface RdvActionListener {

	void RechercherClientScreen(String nom);
	
	void AjouterClient(Client client);
	
	void SupprimerClient(Client client) throws DalException;

	void ValiderClient(ClientActionEvent event) throws DalException;
	
	void setRecherche(ScreenRechercheClient screen);

	void getRdvJour(Personnel veto, Date date);
}
