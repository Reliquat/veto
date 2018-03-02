package fr.eni.clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class AnimalDAOJdbcImpl {
    private final static String SELECT_BY_ID = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedants Archive FROM Personnels WHERE CodeAnimal = ?";
//    private final static String SELECT_ALL = "SELECT CodePers, Nom, MotPasse, Role, Archive FROM Personnels";
//    private final static String INSERT_QUERY = "INSERT INTO Personnels(Nom, MotPasse, Role, Archive) VALUES (?, ?, ?, ?);";
//    private final static String UPDATE_QUERY = "UPDATE Personnels SET Nom = ?, MotPasse = ?, Role = ?, Archive = ? WHERE CodePers = ?;";
//    private final static String DELETE_QUERY = "DELETE FROM Personnels WHERE @CodePers = ?";
    
    private static AnimalDAOJdbcImpl SINGLETON = null;
    
    private AnimalDAOJdbcImpl() {
    	
    }
    
    public static AnimalDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new AnimalDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    private Animal createAnimal(ResultSet resultSet) throws SQLException {
        
    	Animal animal = new Animal();
    	animal.setClient(resultSet.get);
    	animal.setNomAnimal(resultSet.getString("NomAnimal"));
    	animal.setSexe(resultSet.getString("Sexe"));
    	animal.setCouleur(resultSet.getString("Couleur"));
    	animal.setRace(resultSet.getString("Race"));
    	animal.setEspece(resultSet.getString("Espece"));
    	animal.setTatouage(resultSet.getString("Tatouage"));
    	animal.setAntecedents(resultSet.getString("Antecedants"));
    	animal.setArchive(resultSet.getBoolean("Archive"));
        
        return animal;
    }
    
    public Animal selectById(int CodeAnimal) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Animal animal = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_ID);
            
            statement.setInt(1, CodeAnimal);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                animal = createAnimal(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY ID Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return animal;
    }
    
    public List<Animal> selectAllNotArchived() throws DalException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Animal> liste = new ArrayList<Animal>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_NOT_ARCHIVED);

            while (resultSet.next()) {
                liste.add(createAnimal(resultSet));
            }
        } catch(SQLException e) {
            throw new DalException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return liste;
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
