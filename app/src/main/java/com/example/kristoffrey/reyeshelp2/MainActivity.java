package com.example.kristoffrey.reyeshelp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    String[] menuView = {
            "Go to Main App!",
            "Settings",
            "Help!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView header, helper;
        header = (TextView)findViewById(R.id.menuHeader);
        helper = (TextView)findViewById(R.id.helper);
        header.setText("Kit's Simple App");
        helper.setText("Reads a text file when you tap 'Help'");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuView);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent goToMain = new Intent(MainActivity.this, mainApp.class);
                        startActivity(goToMain);
                        break;
                    case 1:
                        Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(goToSettings);
                        break;
                    case 2:
                        Intent goToHelp = new Intent(MainActivity.this, HelpMe.class);
                        startActivity(goToHelp);
                        break;
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}