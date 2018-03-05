package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class LoginDAOJdbcImpl {

    private final static String SELECT_BY_NAME_PW = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE Nom = ? AND MotPasse = ?";
    
    private static LoginDAOJdbcImpl SINGLETON = null;
    
    private LoginDAOJdbcImpl() {
    	
    }
    
    public static LoginDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new LoginDAOJdbcImpl();
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
            statement = connection.prepareStatement(SELECT_BY_NAME_PW);
            
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
    
	public Personnel login(String nom, String motPasse) throws DalException {
        // Check not null 
        ObjectUtil.checkNotNull(nom);
        ObjectUtil.checkNotNull(motPasse);
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;        
        Personnel personnel = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_NAME_PW);
            statement.setString(1, nom);
            statement.setString(2, motPasse);
            
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
            	personnel = new Personnel();
            	personnel.setArchive(resultSet.getBoolean("Archive"));
            	if (!personnel.isArchive()) {
            		personnel.setCodePers(resultSet.getInt("CodePers"));
            		personnel.setNom(resultSet.getString("Nom"));
            		personnel.setMotPasse(resultSet.getString("MotPasse"));
            		personnel.setRole(resultSet.getString("Role"));

            	}
            }
        } catch (SQLException e) {
            throw new DalException("Connexion failed", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return personnel;
	}
}