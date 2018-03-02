package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.manager.LoginMger;
import fr.eni.clinique.bll.manager.impl.LoginMgerImpl;
import fr.eni.clinique.ihm.listener.LoginActionListener;
import fr.eni.clinique.ihm.model.ClientModel;
import fr.eni.clinique.ihm.model.LoginModel;

public class LoginController implements LoginActionListener{

	private LoginModel loginModel;
	private LoginMger loginManager = LoginMgerImpl.getInstance();
	
    public LoginController(LoginModel model) {
        super();
        this.loginModel = model;
    }
	
	@Override
	public void ConnexionPage() {
		
		loginModel.ConnexionPage();
		
	}

}
