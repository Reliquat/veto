package fr.eni.clinique.dal.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class ClientDAOJdbcImpl {

	private final static String SELECT_BY_NAME = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients WHERE NomClient = ?";
    private final static String SELECT_BY_ID = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients WHERE CodeClient = ?";
    private final static String SELECT_ALL = "SELECT CodeClient, NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients";
    private final static String INSERT_QUERY = "INSERT INTO Clients(NomClient, PrenomClient, Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String UPDATE_QUERY = "UPDATE Clients SET NomClient = ?, PrenomClient = ?, Adresse1 = ?, Adresse2 = ?, CodePostal = ?, Ville = ?, NumTel = ?, Assurance = ?, Email = ?, Remarque = ?, Archive = ? WHERE CodeClient = ?;";
    private final static String DELETE_QUERY = "DELETE FROM Clients WHERE @CodeClient = ?";
    
    private static ClientDAOJdbcImpl SINGLETON = null;
    
    private ClientDAOJdbcImpl() {
    	
    }
    
    public static ClientDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new ClientDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    private Client createClient(ResultSet resultSet) throws SQLException {
        
    	Client client = new Client();
        client.setCodeClient(resultSet.getInt("CodeClient"));
        client.setNomClient(resultSet.getString("NomClient"));
        client.setPrenomClient(resultSet.getString("PrenomClient"));
        client.setAdresse1(resultSet.getString("Adresse1"));
        client.setAdresse2(resultSet.getString("Adresse2"));
        client.setCodePostal(resultSet.getString("CodePostal"));
        client.setVille(resultSet.getString("Ville"));
        client.setNumTel(resultSet.getString("NumTel"));
        client.setAssurance(resultSet.getString("Assurance"));
        client.setEmail(resultSet.getString("Email"));
        client.setRemarque(resultSet.getString("Remarque"));
        client.setArchive(resultSet.getBoolean("Archive"));
        System.out.println(client);
        return client;
    }
    
    public Client selectById(int id) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_ID);
            
            statement.setInt(1, id);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	client = createClient(resultSet);
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY ID Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return client;
    }
    
    public List<Client> selectByName(String name) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Client> clients = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_NAME);
            
            statement.setString(1, name);
            
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
            	
            	clients.add(createClient(resultSet));
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY NAME Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return clients;
    }
    
    public Client insertClient (Client client) throws DalException {
    	
    	ObjectUtil.checkNotNull(client);
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, client.getNomClient());
            statement.setString(2, client.getPrenomClient());
            statement.setString(3, client.getAdresse1());
            statement.setString(4, client.getAdresse2());
            statement.setString(5, client.getCodePostal());
            statement.setString(6, client.getVille());
            statement.setString(7, client.getNumTel());
            statement.setString(8, client.getAssurance());
            statement.setString(9, client.getEmail());
            statement.setString(10, client.getRemarque());
            statement.setBoolean(11, client.getArchive());
            
            if(statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) {
                	client.setCodeClient(resultSet.getInt(1));
                }
            }
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete INSERT_QUERY Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        return client;
    }
    
    public void updateClient(Client client) throws DalException {
    	
    	ObjectUtil.checkNotNull(client);
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, client.getNomClient());
            statement.setString(2, client.getPrenomClient());
            statement.setString(3, client.getAdresse1());
            statement.setString(4, client.getAdresse2());
            statement.setString(5, client.getCodePostal());
            statement.setString(6, client.getVille());
            statement.setString(7, client.getNumTel());
            statement.setString(8, client.getAssurance());
            statement.setString(9, client.getEmail());
            statement.setString(10, client.getRemarque());
            statement.setBoolean(11, client.getArchive());
            
            statement.executeUpdate();
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete SELECT BY NAME Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
    }
    
    public void deleteClient(Integer CodeClient) throws DalException {
        
        ObjectUtil.checkNotNull(CodeClient);
        
        Connection connection = null;
        CallableStatement statement = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareCall(DELETE_QUERY);
            
            statement.setInt("CodeClient", CodeClient);
            statement.execute();
            
        } catch (SQLException e) {
            throw new DalException("Erreur d'execution de la requete DELETE Client", e);
        } finally {
            ResourceUtil.safeClose(connection, statement);
        }
    }
    
    public List<Client> selectAll() throws DalException {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Client> liste = new ArrayList<Client>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                liste.add(createClient(resultSet));
            }
        } catch(SQLException e) {
            throw new DalException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return liste;
    }
    
}
