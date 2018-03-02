/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;
import javax.ejb.Stateless;
import domain.Post;
import domain.User;

/**
 *
 * @author myu
 */
@Stateless
public class PostManager {

    public void create(Post post, User user) {
        post.setDate(new Date());
        user.getPosts().add(post);
    }

    /*
    public void delete(Post post, User user) {
        user.getPosts().remove(0);
    }
     */
}
