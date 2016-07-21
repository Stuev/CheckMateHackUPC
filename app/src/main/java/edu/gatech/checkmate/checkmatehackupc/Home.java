package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onSettingsPressed(View v) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void onOKButtonPressed(View v) {
        MainActivity.user.setIsDisabled(false);
        TimeManager.hasCheckedIn = true;
    }

    public void onNotOKButtonPressed(View v) {
        MainActivity.user.setIsDisabled(true);
    }
}
