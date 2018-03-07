package fr.eni.clinique.bll.factory;

import fr.eni.clinique.bll.manager.AgendaManager;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.AgendaManagerImpl;
import fr.eni.clinique.bll.manager.impl.AnimalManagerImpl;
import fr.eni.clinique.bll.manager.impl.LoginMgerImpl;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;

public class ManagerFactory {

	public static PersonnelManager personnelManager(){
		
		return PersonnelManagerImpl.getInstance();
		
	}
	
	public static LoginMger loginManager(){
		
		return LoginMgerImpl.getInstance();
		
	}
	
	public static AgendaManager agendaManager(){
		
		return AgendaManagerImpl.getInstance();
		
	}
	
	public static AnimalManager animalManager(){
		
		return AnimalManagerImpl.getInstance();
		
	}
}
