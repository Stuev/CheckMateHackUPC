package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static Check user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date d = new Date(2016, 9, 16);
        Mate m = new Mate();
        HashMap<String, Mate> h = new HashMap<>();
        h.put("Mate test", m);
        user = new Check(d, 100, false, h);
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
