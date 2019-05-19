package com.velaphi.displayjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    public static final String EXTRAS_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        TextView joke_textview = findViewById(R.id.joke_textView);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRAS_JOKE)){
            String jokeToDisplay = intent.getStringExtra(EXTRAS_JOKE);
            joke_textview.setText(jokeToDisplay);
        }
    }
}
