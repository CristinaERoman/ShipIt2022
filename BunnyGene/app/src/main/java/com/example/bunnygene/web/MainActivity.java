package com.example.bunnygene.web;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;

import com.example.bunnygene.R;
import com.example.bunnygene.ReportingActivity;
import com.example.bunnygene.services.helpers.AsyncInput;
import com.example.bunnygene.services.helpers.AsyncJob;
import com.example.bunnygene.services.helpers.Notif;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Button buttonGetFirstName;
    private Button buttonNotifyUser;
    private TextView textView;


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    boolean notifSent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(!notifSent) {
            notifSent = true;
            sendNotifications();
        }
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendNotifications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AsyncInput input = new AsyncInput();
            input.frequency = 15000;
            input.times = 1;
            input.methodParam = () -> {
                Notif.showNotif(this,"Exercise " ,
                        "Be more physically active!","Notification 1"   );

                Notif.showNotif(this,"Eat Healthy " ,
                        "Eat your fruits and vegetables!","Notification 2"   );
                return null;
            };

            AsyncJob asyncJob = new AsyncJob();
            asyncJob.execute(input);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.    int id = item.getItemId();
        int id = item.getItemId();
        Intent i = new Intent();
        if (id == R.id.nav_reports) {
             i = new Intent(getApplicationContext(), ReportingActivity.class);
        } else if (id == R.id.nav_import) {
             i = new Intent(getApplicationContext(), ImportDnaActivity.class);
        } else if (id == R.id.nav_settings) {
             i = new Intent(getApplicationContext(), Settings.class);
        }

        startActivity(i);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}