package com.example.mathprojectraoli;
import com.dismathinyourhands.mathprojectraoli.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class Chapter3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {
                findViewById(R.id.chap31_btn),
                findViewById(R.id.chap32_btn),
                findViewById(R.id.chap33_btn),
                findViewById(R.id.chap34_btn)
        };
        String[] pdfNames = {
                "03_counting_methods_01_pie.pdf",
                "03_counting_methods_02_pie.pdf",
                "03_counting_methods_03_product_rule.pdf",
                "03_counting_methods_04_product_rule.pdf"
        };

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        for(int i = 0; i < pdfNames.length; i++)
        {
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