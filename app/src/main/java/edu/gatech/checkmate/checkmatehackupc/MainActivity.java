package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    public static Check check = new Check(new Date(2016, 9, 16), 100, false, new HashMap<String, Mate>());
    public static Mate m = new Mate("mate", "mate", "mate");
    public static HashMap<String, Mate> mates = new HashMap<>();
    public static  HashMap<String, Check> checks = new HashMap<>();
    public static Mate mate2 = new Mate("mate2", "mate2", "mate2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Date d = new Date(2016, 9, 16);
        //Mate m
        //HashMap<String, Mate> h = new HashMap<>();
        //h.put("Mate test", m);
        Database d = new Database(this);
        try {
            d.addUser(check);
        } catch (Exception e) {
            Log.d("MainActivity", "OOPS");
        }
        check.addFriend(m);
        m.addFriend(check);
        mates.put(m.getUsername(), m);
        mates.put(mate2.getUsername(), mate2);
        checks.put(check.getUsername(), check);
        TimeManager alarm = new TimeManager();
        alarm.SetAlarm(this);

        Log.d("MainActivity", "About to call CheckInManager");
        CheckInManager cm = new CheckInManager();
        cm.SetAlarm(this);
        Log.d("MainActivity", "End onCreate MainActivity");
    }

    public void onLoginButtonPressed(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void onSignupButtonPressed(View v) {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public static Mate getMate(String username) {
        return mates.get(username);
    }

    public static Check getCheck(String useername) {
        return checks.get(useername);
    }

}
