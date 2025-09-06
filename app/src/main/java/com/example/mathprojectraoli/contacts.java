package com.example.mathprojectraoli;

// The "unused import" warning is likely to disappear once the switch is fixed.
// If not, and if R is truly not used elsewhere, we could remove it.
// For now, let's assume it's needed due to the R.id.drawer_layout etc. in onCreate.
import com.dismathinyourhands.mathprojectraoli.R; 
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class contacts extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Add null check for actionBar
        if (actionBar != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
            actionBar.setBackgroundDrawable(colorDrawable);
            actionBar.setDisplayHomeAsUpEnabled(true); // Moved here as well
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // this.getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Original position, handled above

        NavigationView navigationView = findViewById(R.id.navigationView); // Removed redundant cast
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Get item id once

        if (itemId == R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (itemId == R.id.Share) {
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body = "Your body here";
            String sub = "Your Subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
            myIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(myIntent, "Share Using"));
        } else if (itemId == R.id.AboutUs) {
            Intent aboutUs = new Intent(this, aboutUs.class);
            startActivity(aboutUs);
        } else if (itemId == R.id.Contacts) {
            Intent contactUs = new Intent(this, contacts.class);
            startActivity(contactUs);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
