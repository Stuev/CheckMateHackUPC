package edu.gatech.checkmate.checkmatehackupc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HomeMate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mate);

        ListView lv = (ListView) findViewById(R.id.checkList);

        List<String> your_array_list = new ArrayList<String>();

        Database d = new Database(this);
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

    public void onSettingsPressed(View v) {
        Intent intent = new Intent(this, SettingsMate.class);
        startActivity(intent);
    }
}
