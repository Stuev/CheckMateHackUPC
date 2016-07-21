package edu.gatech.checkmate.checkmatehackupc;

import java.util.Date;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

/**
 * Created by Steven on 7/21/2016.
 */
public class Mate extends User{
    private Map<String, Check> friends;

    public Mate() {
        super();
        friends = new HashMap<String, Check>();
    }

    public void addFriend(Check friend) throws IllegalArgumentException {
        if(friends.put(friend.getUsername(), friend) == null) {
            throw new IllegalArgumentException("Friend already added.");
        }

    }

    public void dropFriend(String username) throws IllegalArgumentException {
        if (friends.remove(username) == null) {
            throw new IllegalArgumentException("Friend does not exist");
        }
    }

    public boolean isFriendOk(String username) throws IllegalArgumentException {
        Check friend = friends.get(username);
        if (friend == null) {
            throw new IllegalArgumentException("Friend does not exist");
        }
        return friend.getNextCheckIn().after(new Date());
    }
}
