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

public class Chapter11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter11);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {findViewById(R.id.chap11_1_btn), findViewById(R.id.chap11_2_btn), findViewById(R.id.chap11_3_btn), findViewById(R.id.chap11_4_btn)};
        String[] pdfNames = {
          "11_01_introduction_to_graphs.pdf",
          "11_02_the_handshaking_theorem.pdf",
          "11_03_trees.pdf",
          "11_04_eulerian_hamiltonian.pdf"
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