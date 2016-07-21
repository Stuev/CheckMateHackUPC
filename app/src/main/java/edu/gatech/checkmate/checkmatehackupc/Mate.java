package edu.gatech.checkmate.checkmatehackupc;

import java.util.HashMap;
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

    public Mate(String name, String username, String password) {
        super(name, username, password);
        friends = new HashMap<String, Check>();
    }


    public void dropFriend(String username){
        friends.remove(username);
    }

/*    public boolean isFriendOk(String username) throws IllegalArgumentException {
        Check friend = friends.get(username);
        if (friend == null) {
            throw new IllegalArgumentException("Friend does not exist");
        }
        return friend
    }*/
}
