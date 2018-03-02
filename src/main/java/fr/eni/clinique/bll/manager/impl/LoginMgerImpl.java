package fr.eni.clinique.bll.manager.impl;

import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;

public class LoginMgerImpl implements LoginMger{

	private ConnexionDAOJdbcImpl personnelDAO =  DaoFactory.connexionDao();
	
	private static LoginMgerImpl instance;
    
    private LoginMgerImpl() {
        
    }
    
    public static LoginMgerImpl getInstance() {
        if(instance == null) {
            instance = new LoginMgerImpl();
        }
        return instance;
    }

	@Override
	public Personnel checkLogin(String name, String password) throws DalException {

		Personnel personnel = null;
		
		ObjectUtil.checkNotNull(name);
		ObjectUtil.checkNotNull(password);
		
		personnel = personnelDAO.selectByName(name);
		
		if (personnel != null && !personnel.getMotPasse().equals(password)) {
			personnel = null;
		}
		
		return personnel;
	}

}
