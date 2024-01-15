package com.example.mathprojectraoli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter12);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {findViewById(R.id.chap12_1_btn), findViewById(R.id.chap12_2_btn), findViewById(R.id.chap12_3_btn), findViewById(R.id.chap12_4_btn)};
        String[] pdfNames = {
                "12_1_sample_spaces_events_probability.pdf",
                "12_2_conditional_probability_and_independence_of_events.pdf",
                "12_03_additional_examples.pdf",
                "12_4_law_of_total_probability_and_theorem_of_bayes.pdf"
        };

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        for(int i = 0; i < pdfNames.length; i++)
        {
            int finalI = i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { pdfView.fromAsset(pdfNames[finalI]).load(); }
            });
        }
    }
}