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

public class Chapter7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter7);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {findViewById(R.id.chap71_btn), findViewById(R.id.chap72_btn)};
        String[] pdfNames = {
                "07_01_terminology_in_matrices.pdf",
                "07_02_matrix_operations.pdf"
        };

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);

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