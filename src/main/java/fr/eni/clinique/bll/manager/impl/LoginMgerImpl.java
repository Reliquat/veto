package fr.eni.clinique.bll.manager.impl;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.LoginDAOJdbcImpl;

public class LoginMgerImpl implements LoginMger{

	private LoginDAOJdbcImpl loginDAO =  DaoFactory.connexionDao();
	
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
	public Personnel checkLogin(String name, String password) throws BLLException{

		ObjectUtil.checkNotNull(name);
		ObjectUtil.checkNotNull(password);
		
		Personnel personnel = null;
		
		try {
			personnel = loginDAO.login(name, password);
		} catch (DalException e) {
			throw new BLLException("Mauvais nom ou mot de passe", e);
		}
		
		return personnel;
	}

}
