package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ConnexionDAOJdbcImpl {

    private final static String SELECT_BY_NAME = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE Nom = ?";
    
    private static ConnexionDAOJdbcImpl SINGLETON = null;
    
    private ConnexionDAOJdbcImpl() {
    	
    }
    
    public static ConnexionDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new ConnexionDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    private Personnel createPersonnel(ResultSet resultSet) throws SQLException {
        
    	Personnel personnel = new Personnel();
        personnel.setCodePers(resultSet.getInt("CodePers"));
        personnel.setNom(resultSet.getString("Nom"));
        personnel.setMotPasse(resultSet.getString("MotPasse"));
        personnel.setRole(resultSet.getString("Role"));
        personnel.setArchive(resultSet.getBoolean("Archive"));
        
        return personnel;
    }
    
    public Personnel selectByName(String name) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Personnel personnel = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_NAME);
            
            statement.setString(1, name);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                personnel = createPersonnel(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY ID Personnel (connexion)", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return personnel;
    }
}