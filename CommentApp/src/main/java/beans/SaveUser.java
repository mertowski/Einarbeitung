/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author myu
 */
@Named
@ApplicationScoped
public class SaveUser implements Serializable {

    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }
    
    public String toSavedUsers() {
        return "savedUsers.xhtml?faces-redirect=true";
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
