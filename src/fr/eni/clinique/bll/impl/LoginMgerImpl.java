package fr.eni.clinique.bll.impl;

import java.util.List;

import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;

public class LoginMgerImpl implements LoginMger{

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
	public List<Personnels> getLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnels addPersonnel(Personnels personnel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePersonnel(Personnels personnel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePersonnel(Personnels personnel) {
		// TODO Auto-generated method stub
		
	}
}
