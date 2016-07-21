package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButtonPressed(View v) {
        EditText username = (EditText) findViewById(R.id.loginUsernameInput);
        EditText password = (EditText) findViewById(R.id.loginPasswordInput);
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

}
