package fr.eni.clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class PersonnelDAOJdbcImpl {

    private final static String SELECT_BY_NAME = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE Nom = ?";
    private final static String SELECT_BY_ID = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels WHERE CodePers = ?";
    private final static String INSERT_QUERY = "INSERT INTO Personnels(Nom, MotPasse, Role, Archive) VALUES (?, ?, ?, ?);";
    private final static String UPDATE_QUERY = "UPDATE Personnels SET Nom = ?, MotPasse = ?, Role = ?, Archive = ? WHERE CodePers = ?;";
    private final static String DELETE_QUERY = "DELETE FROM Personnels WHERE @CodePers = ?";
    
    private static PersonnelDAOJdbcImpl SINGLETON = null;
    
    private PersonnelDAOJdbcImpl() {
    	
    }
    
    public static PersonnelDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new PersonnelDAOJdbcImpl();
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
    
    public Personnel selectById(int id) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Personnel personnel = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_ID);
            
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                personnel = createPersonnel(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY ID Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
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
            throw new DalException("Erreur d'execution de la requete SELECT BY NAME Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return personnel;
    }
    
    public Personnel insertPersonnel(Personnel personnel) throws DalException {
    	
    	ObjectUtil.checkNotNull(personnel);
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, personnel.getNom());
            statement.setString(2, personnel.getMotPasse());
            statement.setString(3, personnel.getRole());
            statement.setBoolean(4, personnel.isArchive());
            
            if(statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) {
                    personnel.setCodePers(resultSet.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete INSERT_QUERY Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return personnel;
    }
    
    public void updatePersonnel(Personnel personnel) throws DalException {
    	
    	ObjectUtil.checkNotNull(personnel);
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, personnel.getNom());
            statement.setString(2, personnel.getMotPasse());
            statement.setString(3, personnel.getRole());
            statement.setBoolean(4, personnel.isArchive());
            statement.setInt(5, personnel.getCodePers());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY NAME Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
    }
    
    public void deletePersonnel(Integer CodePers) throws DalException {
        
        ObjectUtil.checkNotNull(CodePers);
        
        Connection connection = null;
        CallableStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareCall(DELETE_QUERY);
            
            statement.setInt("CodePers", CodePers);
            statement.execute();
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete DELETE Personnel", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
    }
}