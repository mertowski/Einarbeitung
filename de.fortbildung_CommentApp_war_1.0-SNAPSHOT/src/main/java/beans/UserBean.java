/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import domain.User;

/**
 *
 * @author myu
 */
@Named
@RequestScoped
public class UserBean {

    private User newUser = new User();

    /**
     * The session to store the user in.
     */
    @Inject
    private SessionBean sessionBean;

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public void createUser() {
        sessionBean.setCurrentUser(newUser);
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Neue Person erstellt!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
