/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

/**
 *
 * @author myu
 */
public class User {

    @Size(min = 2)
    private String username;
    private List<Post> posts = new ArrayList<Post>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
