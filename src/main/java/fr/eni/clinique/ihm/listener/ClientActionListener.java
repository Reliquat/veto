package fr.eni.clinique.ihm.listener;

import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.ihm.event.ClientActionEvent;

public interface ClientActionListener {

	void RechercherClientScreen();
	
	void RechercherClient(String name);
	
	void AjouterClient();
	
	void SupprimerClient(ClientActionEvent event) throws DalException;

	void ValiderClient(ClientActionEvent event) throws DalException;
	
	void ValiderAjoutClient(ClientActionEvent event) throws DalException;
	
	void EditerClient(ClientActionEvent event) throws DalException;
	
	void init();
}
