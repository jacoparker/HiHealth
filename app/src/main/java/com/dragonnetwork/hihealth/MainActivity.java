package com.dragonnetwork.hihealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dragonnetwork.hihealth.cloudio.CloudIO;
import com.dragonnetwork.hihealth.data.Medication;
import com.dragonnetwork.hihealth.data.Reminder;
import com.dragonnetwork.hihealth.data.User;
import com.dragonnetwork.hihealth.medication.MedicationActivity;
import com.dragonnetwork.hihealth.medication.MedicationAdaptor;
import com.dragonnetwork.hihealth.reminder.ReminderAdaptor;
import com.dragonnetwork.hihealth.user.UserProfile;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    protected DrawerLayout drawer;
    protected ActionBarDrawerToggle drawerToggle;
    protected NavigationView navigationView;
    final String TAG = "MainActivity";
    protected int contentView;
    int selected;
    ReminderAdaptor adapter;
    Button markTakenBtn;
    RecyclerView rv_morning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = R.id.nav_reminders;
        setContentView(R.layout.activity_main);

        markTakenBtn = findViewById(R.id.toggle_taken_btn);
        selected = -1;

        // Attaching the layout to the toolbar object
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // Setting toolbar as the ActionBar with setSupportActionBar() call
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.reminders_layout);
        onCreateDrawer();

        View header = navigationView.getHeaderView(0);
        TextView navUsername = (TextView)header.findViewById(R.id.username_nav);
        navUsername.setText(User.getName());
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });

        //CloudIO.initCloud();
        rv_morning = (RecyclerView) findViewById(R.id.rv_reminders);

        User.fetchReminders();
        adapter = new ReminderAdaptor(this.getApplicationContext(),User.getReminders());
        adapter.setOnItemClickListener(new ReminderAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (selected != -1)
                    ((ReminderAdaptor.ViewHolder)rv_morning.findViewHolderForAdapterPosition(selected)).
                            parentLayout.setBackground(getDrawable(R.drawable.backgroundborder));
                selected = position;
                ReminderAdaptor.ViewHolder v = (ReminderAdaptor.ViewHolder)rv_morning.findViewHolderForAdapterPosition(position);
                v.parentLayout.setBackground(getDrawable(R.drawable.backgroundbordergreen));
            }
        });
        if(User.getMedicationIDs()!=null)
            User.fetchReminders();
        adapter.notifyDataSetChanged();
        Log.w(TAG,"@@@@@@@@@Reminders: " + User.getReminders());
            // Attach the adapter to the recyclerview to populate items
        rv_morning.setAdapter(adapter);
        // Set layout manager to position the items
        rv_morning.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected  void onStart() {
        super.onStart();
        if(User.getMedicationIDs()!=null)
            User.fetchReminders();
        adapter.notifyDataSetChanged();
    }
    protected void onCreateDrawer() {
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    public void onTakenButtonClicked(View v) {
        int i = selected;
        if (i < 0) return;  // no item is selected.

        // determine if the item selected is already marked taken
        List<Reminder> reminders = User.getReminders();

        ReminderAdaptor.ViewHolder sel = (ReminderAdaptor.ViewHolder)rv_morning.findViewHolderForAdapterPosition(i);

        if (reminders.get(i).getTaken()) {
            reminders.get(i).setTaken();
            // set the correct icon
            sel.icon.setImageResource(R.drawable.ic_check_white_24dp);
            sel.icon.setBackgroundColor(Color.rgb(22, 194, 54));
            // update the usage count

        } else {
            reminders.get(i).setTaken();
            // set correct icon
            sel.icon.setImageResource(R.drawable.pills);
            sel.icon.setBackgroundColor(Color.rgb(255, 255, 255));
            // update the usage count

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;

        switch (menuItem.getItemId()) {
            case R.id.nav_medications:
                intent = new Intent(this, MedicationActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.nav_reminders:
                drawer.closeDrawer(Gravity.LEFT);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.nav_calendar:
                intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.nav_reports:
                intent = new Intent(this, ReportsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;
            case R.id.nav_symptoms:
                intent = new Intent(this, SymptomsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        }
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
