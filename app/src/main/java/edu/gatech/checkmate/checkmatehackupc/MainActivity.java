package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static Check check = new Check(new Date(2016, 9, 16), 100, false, new HashMap<String, Mate>());
    public static Mate m = new Mate("mate", "mate", "mate");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Date d = new Date(2016, 9, 16);
        //Mate m
        //HashMap<String, Mate> h = new HashMap<>();
        //h.put("Mate test", m);
        check.addFriend(m);
        m.addFriend(check);
        TimeManager alarm = new TimeManager();
        alarm.SetAlarm(this);
        CheckInManager cm = new CheckInManager();
        cm.SetAlarm(this);
    }

    public void onLoginButtonPressed(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void onSignupButtonPressed(View v) {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }


}
