package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void onSignupPressed(View v) {
        EditText name = (EditText) findViewById(R.id.signupNameInput);
        EditText email = (EditText) findViewById(R.id.signupUsernameInput);
        EditText password = (EditText) findViewById(R.id.signupPasswordInput);
        //TODO get checkbox info
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
