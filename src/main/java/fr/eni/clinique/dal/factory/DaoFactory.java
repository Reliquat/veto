package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.PersonnelDAOJdbcImpl;

/**
 * DAO Fabric.
 * 
 * @author externe
 *
 */
public class DaoFactory {
   
    /**
     * Returns ConnexionDAOJdbcImpl.
     *  
     * @return
     */
    public static ConnexionDAOJdbcImpl connexionDao() {
        return ConnexionDAOJdbcImpl.getInstance();
    }
    
    /**
     * Returns PersonnelDAOJdbcImpl.
     * @return
     */
    public static PersonnelDAOJdbcImpl personnelDao(){
    	return PersonnelDAOJdbcImpl.getInstance();
    }
    
    public static ClientDAOJdbcImpl clientDao(){
    	return ClientDAOJdbcImpl.getInstance();
    }
    
    public static AnimalDAOJdbcImpl animalDao(){
    	return AnimalDAOJdbcImpl.getInstance();
    }
}
