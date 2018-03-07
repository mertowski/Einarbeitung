package t.mavenproject13.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.TestPojo;
import persistence.PojoPS;
import persistence.PojoService;

/**
 *
 * @author jho
 */
@Named
@RequestScoped
public class Message implements Serializable {
    
    List<String> messages = new ArrayList<>();

    @EJB
    private PojoService pojoService;
    
    @PostConstruct
    public void init() {
        messages.add("message1");
        messages.add("message2");
        messages.add("message3");
        messages.add("message4");
    }

    public String getPojoName(){
        return pojoService.getFirstPojo().getName();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    
    
    
}
