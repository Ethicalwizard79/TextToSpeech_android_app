package com.example.textpronounciator;

import android.os.Build;import
        android.os.Bundle;
import android.speech.tts.TextToSpeech;import
        android.view.View;
import android.widget.Button;import
        android.widget.EditText;
import android.widget.ImageButton;
import
        android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;import
        java.util.Locale;
public class MainActivity extends AppCompatActivity {

    ImageButton imgButton;
    Button btnSpeak;
    Button btnToast;
    Button button5;Button
            radio5;
    Button button2;Button
            radio2;
    Button radio;
    Button radio4;
    Button radio6;
    Button
            radio3;
    EditText
            editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast =findViewById(R.id.t1);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Please Select a Language", Toast.LENGTH_SHORT).show();
            }
        });

        imgButton=(ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is Text To Speech",Toast.LENGTH_SHORT).show();
            }
        });

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getApplicationContext(), "This language is not supported!",
                                Toast.LENGTH_SHORT);
                    } else {
                        btnSpeak.setEnabled(true);
                        textToSpeech.setPitch(0.8f);
                        textToSpeech.setSpeechRate(0.9f);

                        speak();
                    }
                }
            }
        });

        radio = (Button) findViewById(R.id.radioButton);
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.ENGLISH);

            }
        });

        radio2 = (Button) findViewById(R.id.radioButton2);
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.FRANCE);

            }
        });

        radio3 = (Button) findViewById(R.id.radioButton3);
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.ITALIAN);

            }
        });

        radio4 = (Button) findViewById(R.id.radioButton4);
        radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.JAPAN);

            }
        });

        radio5 = (Button) findViewById(R.id.radioButton5);
        radio5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.TRADITIONAL_CHINESE);

            }
        });

        radio6 = (Button) findViewById(R.id.radioButton6);
        radio6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = textToSpeech.setLanguage(Locale.KOREAN);

            }
        });

        btnSpeak = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.et1);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.stop();
            }
        });
    }

    private void speak() {
        String text = editText.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
        }
        else {
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    protected void onDestroy() {
        if
        (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}