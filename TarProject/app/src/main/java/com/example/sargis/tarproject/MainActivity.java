package com.example.sargis.tarproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText urlText = findViewById(R.id.urlEditText);
        final Button button = findViewById(R.id.urlButton);
        button.setOnClickListener(new View.OnClickListener() {
            Intent intent;

            @Override
            public void onClick(View v) {
                String sb = urlText.getText().toString();
                if (validateUrl(sb)) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + urlText.getText().toString()));
                    startActivity(intent);
                } else {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?source=hp&ei=_-cvW8PrDIiH6ATj-L3AAQ&q="
                            + urlText.getText().toString()));
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validateUrl(String adress) {
        return android.util.Patterns.WEB_URL.matcher(adress).matches();
    }
}
