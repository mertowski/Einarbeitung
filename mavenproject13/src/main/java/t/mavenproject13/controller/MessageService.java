package t.mavenproject13.controller;

import javax.ejb.Stateless;

/**
 *
 * @author jho
 */
@Stateless
public class MessageService {
    
    public String getMessage(){
        return "cool";
    }
    
}
