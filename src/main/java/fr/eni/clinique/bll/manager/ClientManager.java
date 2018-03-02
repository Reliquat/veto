package fr.eni.clinique.bll.manager;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Client;

public interface ClientManager {

	List<Client> getListeClient() throws BLLException;
    
	Client addClient(Client client) throws BLLException;
    
    void updateClient(Client client) throws BLLException;
    
    void removeClient(Client client) throws BLLException;
	
}
