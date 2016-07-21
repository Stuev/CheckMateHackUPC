package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
        CheckBox check = (CheckBox) findViewById(R.id.checkBox);
        boolean ischeck = check.isChecked();
        if (ischeck) {
            Tutorial.nextCheck = true;
        } else {
            Tutorial.nextCheck = false;
        }
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }
}
