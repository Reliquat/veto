package fr.eni.clinique.ihm.listener;

import fr.eni.clinique.bll.exception.BLLException;
import fr.eni.clinique.bo.Personnel;
import fr.eni.clinique.ihm.event.PersonnelActionEvent;

public interface PersonnelActionListener {
	
	void init() throws Exception;

    /**
     * New personnel Notification
     * @param personnel
     * @throws BLLException 
     */
    void newPersonnel(Personnel personnel) throws BLLException;
    
    /**
     * Delete personnel Notification.
     * 
     * @param event
     */
    void deletePersonnel(Personnel personnel) throws Exception;
    
    /**
     * Reset password Notification.
     * 
     * @param personnel
     */
    void resetPwdPersonnel(Personnel personnel) throws Exception;
}
