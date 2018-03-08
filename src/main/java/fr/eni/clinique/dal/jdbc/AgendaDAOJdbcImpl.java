package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Agenda;
import fr.eni.clinique.bo.Animal;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.common.util.ResourceUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.factory.MSSQLConnectionFactory;

public class AgendaDAOJdbcImpl {

    private final static String SELECT_BY_PERSONNEL_DATERDV = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agenda WHERE CodeVeto = ? AND convert(DATE,DateRdv) = ?";
    private final static String INSERT_QUERY = "INSERT INTO Agenda(CodeVeto, DateRdv, CodeAnimal) VALUES (?, ?, ?);";
            
    private static AgendaDAOJdbcImpl SINGLETON = null;
    
    private AgendaDAOJdbcImpl() {
    	
    }
    
    public static AgendaDAOJdbcImpl getInstance() {
        if(SINGLETON == null) {
            SINGLETON = new AgendaDAOJdbcImpl();
        }
        return SINGLETON;
    }
    
    public Agenda createAgenda(ResultSet resultSet) throws SQLException {
        
    	AnimalDAOJdbcImpl animalDao = DaoFactory.animalDao();
        Animal animal = new Animal();
    	Agenda agenda = new Agenda();
    	agenda.setDateRdv(resultSet.getDate("DateRdv"));
    	
    	try {
			animal = animalDao.selectById(resultSet.getInt("CodeAnimal"));
		} catch (DalException e) {
			e.printStackTrace();
		}
    	agenda.setAnimal(animal);

        return agenda;
    }
    
    public void ajoutAgenda(Agenda agenda, Personnel personnel) throws DalException {
    	
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(INSERT_QUERY);
            
            statement.setInt(1, personnel.getCodePers());
            statement.setDate(2, (java.sql.Date) agenda.getDateRdv());
            statement.setInt(3, agenda.getAnimal().getCodeAnimal());
            resultSet = statement.executeQuery();
        } catch(SQLException e) {
        	throw new DalException("Erreur d'execution de la requete SELECT BY PERSONNEL Agenda", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
    }

    public List<Agenda> getAgendaOfPersonnel(Personnel personnel, Date dateRdv) throws DalException {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Agenda> liste = new ArrayList<Agenda>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_BY_PERSONNEL_DATERDV);
            
            statement.setInt(1, personnel.getCodePers());
            statement.setDate(2, dateRdv);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                liste.add(createAgenda(resultSet));
            }

        } catch(SQLException e) {
        	throw new DalException("Erreur d'execution de la requete SELECT BY PERSONNEL Agenda", e);
        } finally {
            ResourceUtil.safeClose(connection, statement, resultSet);
        }
        
        return liste;
    }
}
