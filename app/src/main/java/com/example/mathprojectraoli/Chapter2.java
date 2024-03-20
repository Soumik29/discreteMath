package com.example.mathprojectraoli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.Locale;

public class Chapter2 extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button[] btns = {
                findViewById(R.id.chap21_btn),
                findViewById(R.id.chap22_btn),
                findViewById(R.id.chap23_btn),
                findViewById(R.id.chap24_btn)};
        String[] pdfNames = {
                "02_set_theory_01_definition.pdf",
                "02_set_theory_02_subset_power_set.pdf",
                "02_set_theory_03_set_operations.pdf",
                "02_set_theory_04_set_identities.pdf"
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