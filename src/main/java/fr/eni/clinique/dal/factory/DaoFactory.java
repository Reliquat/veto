package fr.eni.clinique.dal.factory;

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
