package edu.gatech.checkmate.checkmatehackupc;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

/**
 * Created by Steven on 7/21/2016.
 */
public class Mate extends User{
    private Map<String, User> friends;

    public Mate() {
        super();
        friends = new HashMap<>();
    }

    public void addFriend(User friend) throws IllegalArgumentException {
        if(friends.put(friend.getUsername(), friend) == null) {
            throw new IllegalArgumentException("Friend already added.");
        }

    }

    public void dropFriend(String username) {
        if (friends.remove(username) == null) {
            throw new IllegalArgumentException("Friend does not exist");
        }
    }
}
