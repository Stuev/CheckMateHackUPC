package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onChangeFrequencyPressed(View v) {
        EditText f = (EditText) findViewById(R.id.frequencyInput);
        String fd = f.getText().toString();
        int x = Integer.parseInt(fd);
        MainActivity.user.setDelay(x);
    }

    public void onAddFriendPressed(View v) {

    }

    public void onHomeButtonPressed(View v) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}
