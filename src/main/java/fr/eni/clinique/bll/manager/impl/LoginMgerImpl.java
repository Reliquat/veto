package fr.eni.clinique.bll.manager.impl;

import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;

public class LoginMgerImpl{

	private ConnexionDAOJdbcImpl connexionDAOJdbcImpl =  DaoFactory.connexionDao();
	
	private static LoginMgerImpl instance;
    
    private LoginMgerImpl() {
        
    }
    
    public static LoginMgerImpl getInstance() {
        if(instance == null) {
            instance = new LoginMgerImpl();
        }
        return instance;
    }

    
    
}
