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
        if (username.getText().toString().equals("mate")) {
            System.out.println("HI");
            Intent intent = new Intent(this, HomeMate.class);
            startActivity(intent);
        } else if (username.getText().toString().equals("check")) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
    }

}
