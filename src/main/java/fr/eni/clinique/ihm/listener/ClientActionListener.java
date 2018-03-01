package fr.eni.clinique.ihm.listener;

import fr.eni.clinique.dal.exception.DalException;

public interface ClientActionListener {

	void Rechercher();
	
	void Ajouter();
	
	void Supprimer(int CodePers) throws DalException;

	void Valider(int CodePers);
	
	void Editer(int CodePers);
	
	void Annuler();
	
	void init();
}
