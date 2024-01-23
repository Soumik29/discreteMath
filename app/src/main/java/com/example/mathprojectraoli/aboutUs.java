package com.example.mathprojectraoli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import mehdi.sakout.aboutpage.AboutPage;


public class aboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(
                        "This app is intended to be a supplement for the teaching " +
                        "and learning of Math 174 Discrete Math for Computer " +
                        "Science at the University of South Carolina Aiken. " +
                        "It started with an assignment of CSCI 340 Mobile Application " +
                        "Development at the University of South Carolina Aiken " +
                        "and evolved into the current form."
                )
                .addGroup("CONNECT WITH US!")
                .addEmail("RaoL@usca.edu")
                .create();
        setContentView(aboutPage);
    }
}