package fr.eni.clinique.dal.factory;

import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;

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
}
