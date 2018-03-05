package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.AnimalManager;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;

public class AnimalManagerImpl implements AnimalManager {
	
	private AnimalDAOJdbcImpl animalDao = DaoFactory.animalDao();

	@Override
	public List<Animal> getAnimauxOfClient(Client client) throws BLLException {
		
		List<Animal> animaux = null;
		
		try {
			animaux = animalDao.getAnimauxOfClient(client);
        } catch (DalException e) {
            throw new BLLException("Erreur r�cup�ration liste animaux of client", e);
        }
		
		return animaux;
	}

	@Override
	public void deleteAnimal(Animal animal) throws BLLException {
    	
    	ObjectUtil.checkNotNull(animal);
		
		try {
			animalDao.deleteAnimal(animal);
        } catch (DalException e) {
            throw new BLLException("Erreur delete animal", e);
        }
	}

	@Override
	public Animal updateAnimal(Animal animal) throws BLLException {
    	
    	ObjectUtil.checkNotNull(animal);
		
		try {
			animal = animalDao.updateAnimal(animal);
        } catch (DalException e) {
            throw new BLLException("Erreur update animal", e);
        }
		
		return animal;
	}

	@Override
	public Animal insertAnimal(Animal animal) throws BLLException {
    	
    	ObjectUtil.checkNotNull(animal);

		try {
			animal = animalDao.insertAnimal(animal);
        } catch (DalException e) {
            throw new BLLException("Erreur insert animal", e);
        }
		
		return animal;
	}
}