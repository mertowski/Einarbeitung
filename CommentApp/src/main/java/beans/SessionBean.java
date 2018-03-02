/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import domain.Post;
import domain.User;

/**
 *
 * @author myu
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    /**
     * A version number to satisfy the implementation of Serializable.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The current active user.
     */
    private User currentUser;

    private final List<Post> posts = new ArrayList<>();

    public List<Post> getPostsFromSession() {
        return posts;
    }

    /**
     * @return The current active user.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String endSession() {
        currentUser = null;
        return "login.xhtml?faces-redirect=true";
    }
}
