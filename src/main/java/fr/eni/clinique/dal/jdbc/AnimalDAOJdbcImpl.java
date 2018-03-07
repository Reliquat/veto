package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class AnimalDAOJdbcImpl {
	
    private final static String SELECT_BY_ID = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeAnimal = ?";
    private final static String SELECT_BY_CLIENT = "SELECT CodeAnimal, NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient = ?";
    private final static String INSERT_QUERY = "INSERT INTO Animaux(NomAnimal, Sexe, Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_QUERY = "UPDATE Animaux SET NomAnimal = ?, Sexe = ?, Couleur = ?, Race = ?, Espece = ?, CodeClient = ?, Tatouage = ?, Antecedents = ?, Archive = ? WHERE CodeAnimal = ?";
    private final static String DELETE_QUERY = "DELETE FROM Animaux WHERE CodeAnimal = ?";
    private final static String SELECT_RACES = "SELECT DISTINCT Race FROM Races";
    
    private static AnimalDAOJdbcImpl SINGLETON = null;
    
    private AnimalDAOJdbcImpl() {
    	
    }
    
    public static AnimalDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new AnimalDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    private Animal createAnimal(ResultSet resultSet, Client client) throws SQLException {
        
    	Animal animal = new Animal();
    	animal.setCodeAnimal(resultSet.getInt("CodeAnimal"));
    	animal.setClient(client);
    	animal.setNomAnimal(resultSet.getString("NomAnimal"));
    	animal.setSexe(resultSet.getString("Sexe"));
    	animal.setCouleur(resultSet.getString("Couleur"));
    	animal.setRace(resultSet.getString("Race"));
    	animal.setEspece(resultSet.getString("Espece"));
    	animal.setTatouage(resultSet.getString("Tatouage"));
    	animal.setAntecedents(resultSet.getString("Antecedents"));
    	animal.setArchive(resultSet.getBoolean("Archive"));
        
        return animal;
    }
    
    public Animal insertAnimal(Animal animal) throws DalException {
    	
    	ObjectUtil.checkNotNull(animal);
    	
    	Connection connection = null;
    	PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
        	System.out.println("requete");
            connection = MSSQLConnectionFactory.get();
            
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, animal.getNomAnimal());
        	System.out.println(animal.getNomAnimal());
            statement.setString(2, animal.getSexe());
        	System.out.println(animal.getSexe());
            statement.setString(3, animal.getCouleur());
        	System.out.println(animal.getCouleur());
            statement.setString(4, animal.getRace());
        	System.out.println(animal.getRace());
            statement.setString(5, animal.getEspece());
        	System.out.println(animal.getEspece());
            statement.setInt(6, animal.getClient().getCodeClient());
        	System.out.println(animal.getClient().getCodeClient());
            statement.setString(7, animal.getTatouage());
        	System.out.println(animal.getTatouage());
            statement.setString(8, animal.getAntecedents());
        	System.out.println(animal.getAntecedents());
            statement.setBoolean(9, animal.isArchive());
        	System.out.println(animal.isArchive());
            
            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                	animal.setCodeAnimal(resultSet.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete INSERT Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return animal;
    }
    
    public void updateAnimal(Animal animal) throws DalException {
    	
    	ObjectUtil.checkNotNull(animal);
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, animal.getNomAnimal());
            statement.setString(2, animal.getSexe());
            statement.setString(3, animal.getCouleur());
            statement.setString(4, animal.getRace());
            statement.setString(5, animal.getEspece());
            statement.setInt(6, animal.getClient().getCodeClient());
            statement.setString(7, animal.getTatouage());
            statement.setString(8, animal.getAntecedents());
            statement.setBoolean(9, animal.isArchive());
            statement.setInt(10, animal.getCodeAnimal());
            
            statement.executeQuery();

        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete UPDATE_QUERY Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
    }
    
    public void deleteAnimal(Animal animal) throws DalException {
    	
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, animal.getCodeAnimal());
            statement.executeQuery();
            
        } catch(SQLException e) {
        	throw new DalException("Erreur d'execution de la requete DELETE Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
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
            	Client client = new Client();
            	client.setCodeClient(resultSet.getInt("CodeClient"));
                animal = createAnimal(resultSet, client);
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY ID Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return animal;
    }
    
    public List<Animal> getAnimauxOfClient(Client client) throws DalException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Animal> liste = new ArrayList<Animal>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_CLIENT);
            
            statement.setInt(1, client.getCodeClient());
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                liste.add(createAnimal(resultSet, client));
            }

        } catch(SQLException e) {
        	throw new DalException("Erreur d'execution de la requete SELECT BY CLIENT Animal", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return liste;
    }
}
