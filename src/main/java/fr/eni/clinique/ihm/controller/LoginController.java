package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.factory.ManagerFactory;
import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.listener.LoginActionListener;
import fr.eni.clinique.ihm.model.LoginModel;

public class LoginController implements LoginActionListener{

	private LoginModel loginModel;
	private LoginMger loginManager = ManagerFactory.loginManager();
	
    public LoginController(LoginModel model) {
        super();
        this.loginModel = model;
    }
	
	@Override
	public Personnel ConnexionPage(String name, String password){
		Personnel personnel = null;
		
		try {
			personnel = loginManager.checkLogin(name, password);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnel;
	}
}
