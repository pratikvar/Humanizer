package com.skybase.humanizersample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTextClick(View view) {
        Intent starter = new Intent(this, TextHumanizerActivity.class);
        startActivity(starter);
    }

    public void onDateClick(View view) {
        Intent starter = new Intent(this, DateHumanizerActivity.class);
        startActivity(starter);
    }
}
