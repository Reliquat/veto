package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.event.PersonnelActionEvent;
import fr.eni.clinique.ihm.listener.PersonnelActionListener;
import fr.eni.clinique.ihm.model.PersonnelModel;

public class PersonnelController implements PersonnelActionListener{

	private PersonnelModel personnelModel;
	private PersonnelManager personnelManager = PersonnelManagerImpl.getInstance();
	
	
	
	public PersonnelController(PersonnelModel personnelModel) {
		super();
		this.personnelModel = personnelModel;
	}

	@Override
	public void init() throws Exception {
		
		personnelModel = new PersonnelModel();
		personnelModel.loadPersonnel(personnelManager.getListePersonnel());
	}

	@Override
	public void newPersonnel() throws BLLException {
	}

	@Override
	public void deletePersonnel(PersonnelActionEvent event) throws Exception {
		// TODO Auto-generated method stub
		if(event.getPersonnel().getCodePers() != 0){
			personnelManager.removePersonnel(event.getPersonnel());
		}
	}

	@Override
	public void resetPwdPersonnel(PersonnelActionEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
