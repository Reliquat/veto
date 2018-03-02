package fr.eni.clinique.ihm.event;

import fr.eni.clinique.bo.Client;

public class ClientActionEvent {

	private Client client;
	
    public ClientActionEvent(Client client) {
        super();
        this.client = client;
    }

    /**
     * @return the article
     */
    public Client getClient() {
        return client;
    }
	
}
