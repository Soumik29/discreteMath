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

public class Chapter9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter9);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {findViewById(R.id.chap91_btn), findViewById(R.id.chap92_btn), findViewById(R.id.chap93_btn), findViewById(R.id.chap94_btn)};
        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        String[] pdfNames = {
                "09_01_mathematical_induction.pdf",
                "09_02_mathematical_induction.pdf",
                "09_03_mathematical_induction.pdf",
                "09_04_mathematical_induction.pdf"
        };
        for(int i = 0; i < pdfNames.length; i++){
            int finalI = i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pdfView.fromAsset(pdfNames[finalI]).load();
                }
            });
        }
    }
}