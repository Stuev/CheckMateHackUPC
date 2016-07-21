package edu.gatech.checkmate.checkmatehackupc;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Courtney on 7/21/16.
 */
public class Check extends User {

    private Date nextCheckIn;
    private int delay;
    private boolean isDisabled;
    private HashMap<String, Mate> friends;

    public Check(String name, String username, String password) {
        super(name, username, password);
        nextCheckIn = new Date(new Date().getTime() + 60000);
        delay = 2;
        isDisabled = false;
        friends = new HashMap<>();
    }
    public Check(Date nextCheckIn, int delay, boolean isDisabled, HashMap<String, Mate> friends) {
        super();
        this.nextCheckIn = nextCheckIn;
        this.delay = delay;
        this.isDisabled = isDisabled;
        this.friends = friends;
    }

    public Date getNextCheckIn() {
        return nextCheckIn;
    }

    public void setNextCheckIn(Date nextCheckIn) {
        this.nextCheckIn = nextCheckIn;
    }


    public void setFriends(HashMap<String, Mate> friends) {
        this.friends = friends;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }

    public void addFriend(Mate friend) {
        friends.put(friend.getUsername(), friend);
    }

    public void dropFriend(String username) {
        friends.remove(username);
    }
}
