package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Settings extends AppCompatActivity {

    ListView lv = (ListView) findViewById(R.id.mateList);
    Database d = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        addFriendsToList();
        System.out.println(Login.loggedIn);
    }

    public void addFriendsToList() {

        List<String> your_array_list = new ArrayList<String>();


        for (User u : Login.loggedIn.getFriends().values()) {
            String isOK = "";
            try {
                isOK =  ": " + d.isGood((Check) u);
            } catch (Exception e) {
                Log.d("HomeMate", "OOPS");
            }
            your_array_list.add(u.getUsername() + isOK);
        }


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);
    }

    public void onChangeFrequencyPressed(View v) {
        EditText f = (EditText) findViewById(R.id.frequencyInput);
        String fd = f.getText().toString();
        int x = Integer.parseInt(fd);
        Check temp = (Check) Login.loggedIn;
        temp.setDelay(x);
        TimeManager.delay = x*1000*60;
    }

    public void onAddFriendPressed(View v) {
        EditText friendName = (EditText) findViewById(R.id.newFriendName);
        EditText username = (EditText) findViewById(R.id.newFriendUsername);
        String friendNameString = (String) friendName.getText().toString();
        String userNameString = (String) username.getText().toString();
        Login.loggedIn.addFriend(MainActivity.getMate(userNameString));
        addFriendsToList();
        lv.invalidateViews();
    }

    public void onHomeButtonPressed(View v) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void onToggleButtonPressed(View v) {
        ToggleButton a = (ToggleButton) findViewById(R.id.disableButton);
        Boolean isEnabled = a.isEnabled();
        if (isEnabled) {
            //turn on alarm
            Toast.makeText(Settings.this, "The check in notifications have been turned on.", Toast.LENGTH_SHORT).show();
        } else {
            //turn off alarm
            Toast.makeText(Settings.this, "The check in notifications have been turned off.", Toast.LENGTH_SHORT).show();
        }
    }

}
