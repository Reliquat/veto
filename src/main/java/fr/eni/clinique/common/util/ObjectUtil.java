package fr.eni.clinique.common.util;

import fr.eni.clinique.common.AppConstants;

/**
 * Object Utilities.
 * 
 * @author externe
 *
 */
public class ObjectUtil {

    private ObjectUtil() {
        
    }
    
    public static final String nullToBlank(String data) {
        
        String result = AppConstants.EMPTY;
        
        if(data != null) {
            result = data; 
        }
        
        return result;
    }
    
    /**
     * Check If Not blank.
     * 
     * @param element
     */
    public static void checkNotBlank(String element) {
        if(element == null || element.length() == 0) {
            throw new IllegalArgumentException(String.format("%s must not be blank !", element));
        }
    }
    
    /**
     * Check If Not null.
     * 
     * @param element
     */
    public static void checkNotNull(Object element) {
        if(element == null) {
            throw new IllegalArgumentException(String.format("NULL is not Permitted in this method"));
        }
    }
    
    /**
     * Check if not blank with message.
     * 
     * @param element
     * @param message
     */
    public static void checkNotBlankWithMessage(String element, String message) {
        if(element == null || element.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }
    
    /**
     * Check If Not null with message.
     * 
     * @param element
     */
    public static void checkNotNullWithMessage(Object element, String message) {
        if(element == null) {
            throw new IllegalArgumentException(message);
        }
    }
}