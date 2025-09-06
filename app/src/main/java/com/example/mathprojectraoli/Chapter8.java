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

public class Chapter8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter8);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {findViewById(R.id.chap81_btn), findViewById(R.id.chap82_btn), findViewById(R.id.chap83_btn), findViewById(R.id.chap84_btn)};
        String[] pdfNames = {
                "08_01_introduction_to_relations.pdf",
                "08_02_equivalence_relations.pdf",
                "08_03_equivalence_relations_and_partitions.pdf",
                "08_04_the_representations_of_relations.pdf"
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