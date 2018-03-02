package fr.eni.clinique.ihm.listener;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.ihm.event.PersonnelActionEvent;

public interface PersonnelActionListener {
	
	void init() throws Exception;

    /**
     * New personnel Notification
     * @throws BLLException 
     */
    void newPersonnel() throws BLLException;
    
    /**
     * Delete personnel Notification.
     * 
     * @param event
     */
    void deletePersonnel(PersonnelActionEvent event) throws Exception;
    
    /**
     * Reset password Notification.
     * 
     * @param event
     */
    void resetPwdPersonnel(PersonnelActionEvent event) throws Exception;
}