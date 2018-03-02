/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import service.PostManager;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Post;

/**
 *
 * @author myu
 */
@Named
@RequestScoped
public class PostBean {

    /**
     * A post to be created.
     */
    private Post newPost = new Post();
    /**
     * A manager class to create the post.
     */
    @EJB
    private PostManager postManager;
    /**
     * The session where the current user is stored.
     */

    @Inject
    private SessionBean sessionBean;

    public Post getNewPost() {
        return newPost;
    }

    public void setNewPost(Post newPost) {
        this.newPost = newPost;
    }

    /**
     * Create the #newPost using the #postManager.
     */
    public void createPost() {
        postManager.create(newPost, sessionBean.getCurrentUser());
    }

}
