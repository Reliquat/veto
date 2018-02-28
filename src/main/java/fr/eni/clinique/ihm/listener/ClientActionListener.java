package fr.eni.clinique.ihm.listener;

public interface ClientActionListener {

	void Rechercher();
	
	void Ajouter();
	
	void Supprimer();

	void Valider();
	
	void Editer();
	
	void Annuler();
	
	void init();
}
