package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static Check check;
    public static Mate m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date d = new Date(2016, 9, 16);
        Mate m = new Mate("mate", "mate", "mate");
        HashMap<String, Mate> h = new HashMap<>();
        h.put("Mate test", m);
        check = new Check(d, 100, false, h);
        TimeManager alarm = new TimeManager();
        alarm.SetAlarm(this);
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
