package fr.eni.clinique.bll.manager.impl;

import java.util.List;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bll.manager.ClientManager;
import fr.eni.clinique.bo.Client;
import fr.eni.clinique.common.exception.TechnicalException;
import fr.eni.clinique.common.util.ObjectUtil;
import fr.eni.clinique.dal.exception.DalException;
import fr.eni.clinique.dal.factory.DaoFactory;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;

public class ClientManagerImpl implements ClientManager{

	private ClientDAOJdbcImpl clientDAO =  DaoFactory.clientDao();
	
	private static ClientManagerImpl instance;
    
    private ClientManagerImpl() {
        
    }
    
    public static ClientManagerImpl getInstance() {
        if(instance == null) {
            instance = new ClientManagerImpl();
        }
        return instance;
    }

	@Override
	public List<Client> getListeClient() throws BLLException {
		List<Client> clients = null;
        
        try {
            clients = clientDAO.selectAll();
            
        } catch (DalException e) {
            throw new BLLException("Erreur récupération liste client", e);
        }
        
        return clients;
	}

	@Override
	public Client addClient(Client client) throws BLLException{
		
		if(client.getCodeClient() != 0 ) {
            throw new BLLException("Client deja existant.");
        }
        
        try {
        	validerClient(client);
            
            client = clientDAO.insertClient(client);
            
        } catch (DalException e) {
            throw new BLLException("Echec addClient", e);
        }
        return client;
	}

	@Override
	public void updateClient(Client client) throws BLLException {
		
		try {
            validerClient(client);
            
            clientDAO.updateClient(client);
            
        } catch (DalException e) {
            throw new BLLException(String.format("Echec updateClient-Client: %s", client), e);
        }
	}

	@Override
	public void removeClient(Client client) throws BLLException {
		
		try {
			clientDAO.deleteClient(client.getCodeClient());
            
        } catch (DalException e) {
            throw new BLLException("Echec de la suppression du Client - ", e);
        }
	}
	
    private void validerClient(Client client) throws BLLException {

        try {
            ObjectUtil.checkNotNullWithMessage(client, "Une erreur technique est survenue");
            ObjectUtil.checkNotBlankWithMessage(client.getNomClient(), "Le nom est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getPrenomClient(), "Le prenom est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getAdresse1(), "L'adresse est obligatoire");
            //ObjectUtil.checkNotBlankWithMessage(Client.getAdresse2(), "L'adresse est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getCodePostal(), "Le code postal est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getVille(), "La ville est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getNumTel(), "Le numéro de téléphone est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getAssurance(), "L'assurance est obligatoire");
            ObjectUtil.checkNotBlankWithMessage(client.getEmail(), "L'Email est obligatoire");
            
        } catch (IllegalArgumentException e) {
            throw new BLLException(String.format("Erreur de validation : %s", e.getMessage()), e);
        } catch (Exception e) {
            throw new TechnicalException(e.getMessage(), e);
        }
    }
	
    public Client getById(int id) throws BLLException {
    	
    	Client client = null;
    	
    	try {
			client = clientDAO.selectById(id);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(), e);
		}
    	return client;
    }
    
    public Client getByName(String name) throws BLLException {
    	
    	Client client = null;
    	
    	try {
			client = clientDAO.selectByName(name);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			throw new BLLException(e.getMessage(), e);
		}
    	return client;
    }
}
