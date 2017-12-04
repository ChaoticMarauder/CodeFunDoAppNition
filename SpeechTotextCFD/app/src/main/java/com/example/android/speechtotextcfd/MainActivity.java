package com.example.android.speechtotextcfd;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {

    TextView spokenText;
    ImageButton mic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spokenText=(TextView) findViewById(R.id.txtSpeechInput);
        mic=(ImageButton) findViewById(R.id.btnSpeak);



        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();
            }
        });
    }

public void promptSpeechInput()
{
    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something");

    try {
        startActivityForResult(intent, 100);
    }
    catch(ActivityNotFoundException a) {
        Toast.makeText(getApplicationContext(),
                "Sorry! Speech isn't working.",
                Toast.LENGTH_SHORT).show();
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case 100:
                if(RESULT_OK==resultCode && null!=data){
                    ArrayList<String> output =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    spokenText.setText(output.get(0));

                }
                break;
        }
    }
}

