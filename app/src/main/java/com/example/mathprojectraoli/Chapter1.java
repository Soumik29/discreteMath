package com.example.mathprojectraoli;
import com.dismathinyourhands.mathprojectraoli.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.github.barteksc.pdfviewer.PDFView;

public class Chapter1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {
                findViewById(R.id.chap11_btn),
                findViewById(R.id.chap12_btn),
                findViewById(R.id.chap13_btn),
                findViewById(R.id.chap14_btn)
        };
        String[] pdfNames = {
                "01_logic_01_definition.pdf",
                "01_logic_02_truth_table.pdf",
                "01_logic_03_tautology_equivalence.pdf",
                "01_logic_04_de_morgan.pdf"
        };


        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);

        for(int i = 0; i < pdfNames.length; i++){
            int finalI = i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pdfView.fromAsset(pdfNames[finalI]).enableSwipe(true).load();
                }
            });
        }
    }
}