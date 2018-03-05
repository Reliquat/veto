package fr.eni.clinique.bll.factory;

import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.LoginMgerImpl;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;

public class ManagerFactory {

	public static PersonnelManager personnelManager(){
		
		return PersonnelManagerImpl.getInstance();
		
	}
	
	public static LoginMger loginManager(){
		
		return LoginMgerImpl.getInstance();
		
	}
	
}
