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

public class Chapter4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {
                findViewById(R.id.chap41_btn),
                findViewById(R.id.chap42_btn),
                findViewById(R.id.chap43_btn),
                findViewById(R.id.chap44_btn)
        };
        String[] pdfNames = {
                "04_counting_methods_01_permutation.pdf",
                "04_counting_methods_02_combination.pdf",
                "04_counting_methods_03_examples.pdf",
                "04_counting_methods_04_identities.pdf"
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