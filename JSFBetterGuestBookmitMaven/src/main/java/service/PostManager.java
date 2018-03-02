/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Date;

import domain.Post;
import domain.User;
import javax.ejb.Stateless;

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
}
