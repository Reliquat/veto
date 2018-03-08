package fr.eni.clinique.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.PersonnelManager;
import fr.eni.clinique.bll.manager.impl.PersonnelManagerImpl;
import fr.eni.clinique.bo.Personnel;
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
	public void newPersonnel(Personnel personnel) throws BLLException {
		personnelModel.addPersonnel(personnelManager.addPersonnel(personnel));
	}

	@Override
	public void deletePersonnel(Personnel personnel) throws Exception {
		personnel.setArchive(true);
		personnelManager.updatePersonnel(personnel);
		personnelModel.removePersonnel(personnel);
	}

	@Override
	public void resetPwdPersonnel(Personnel personnel) throws Exception {
		
		personnelManager.updatePersonnel(personnel);
		personnelModel.resetPassword(personnel);
	}

	@Override
	public void getListeVeto(Personnel personnel) throws Exception {
		
		personnelManager.getListeVeto();
		
	}

	@Override
	public List<Personnel> selectByName(String name) throws Exception {
		List<Personnel> personnels = new ArrayList<>();
		
		personnels = personnelManager.selectByName(name);
		
		return personnels;
	}
}
