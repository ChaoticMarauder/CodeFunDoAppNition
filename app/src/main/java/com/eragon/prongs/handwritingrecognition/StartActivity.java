package com.eragon.prongs.handwritingrecognition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    TextView tss_tv,stt_tv,hr_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    tss_tv=(TextView) findViewById(R.id.tss);
    stt_tv=(TextView) findViewById(R.id.stt);
    hr_tv=(TextView) findViewById(R.id.hr);

    tss_tv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(StartActivity.this,TextToSpeechActivity.class);
            startActivity(intent);
        }
    });

        stt_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(StartActivity.this,SpeechToTextActivity.class);
                startActivity(intent1);
            }
        });

        hr_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(StartActivity.this,HRCameraActivity.class);
                startActivity(intent2);
            }
        });



    }



}
