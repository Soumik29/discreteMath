package com.example.mathprojectraoli; // Changed

import com.dismathinyourhands.mathprojectraoli.R; // Added
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

//import com.example.mathprojectraoli.R;
//import com.example.mathprojectraoli.databinding.ActivityAboutUsBinding;

import mehdi.sakout.aboutpage.AboutPage;

public class aboutUs extends AppCompatActivity {

    //ActivityAboutUsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_about_us);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                //.setImage(R.drawable.dummy_image)
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
                //.addWebsite("http://medyo.github.io/")
                //.addFacebook("the.medy")
                //.addTwitter("medyo80")
                //.addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                //.addPlayStore("com.ideashower.readitlater.pro")
                //.addGitHub("medyo")
                //.addInstagram("medyo80")
                .create();
        setContentView(aboutPage);
    }
}