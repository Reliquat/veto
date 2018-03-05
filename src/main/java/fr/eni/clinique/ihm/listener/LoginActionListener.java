package fr.eni.clinique.ihm.listener;

import fr.eni.clinique.bo.Personnel;

public interface LoginActionListener {

	Personnel ConnexionPage(String name, String password);
	
}
