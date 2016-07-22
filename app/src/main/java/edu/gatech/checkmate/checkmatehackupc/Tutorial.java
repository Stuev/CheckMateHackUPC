package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Tutorial extends AppCompatActivity {

    public static boolean nextCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
    }

    public void onNextPressed(View v) {
        /*if (nextCheck) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, SettingsMate.class);
            startActivity(intent);
        }*/
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
