package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Client;
import fr.eni.clinique.dal.exception.DalException;

public interface ClientDAO {
	
	Client selectById(int id) throws DalException;
	
	List<Client> selectByName(String name) throws DalException;
	
	Client insertClient (Client client) throws DalException;
	
	void updateClient(Client client) throws DalException;
	
	void deleteClient(Integer CodeClient) throws DalException;
	
	List<Client> selectAll() throws DalException;
}
