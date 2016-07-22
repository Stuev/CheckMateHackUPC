package edu.gatech.checkmate.checkmatehackupc;

import java.util.HashMap;

/**
 *
 * Created by Courtney on 7/21/16.
 */
public class User {

    private String name;
    private String username;
    private String password;
    private HashMap<String, User> friends;


    public User() {
        name = "temp";
        username = "temp";
        password = "temp";
        friends = new HashMap<>();
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.friends = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int hashCode() {
        return username.hashCode();
    }

    public String toString() {
        return name + " " + username + " " + password;
    }

    public boolean equals(User u) {
        return username.equals(u.username);
    }

    public void addFriend(User u) {
        friends.put(u.getUsername(), u);
    }

    public HashMap<String, User> getFriends() {
        return friends;
    }
}
