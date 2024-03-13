package com.example.quizgame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizgame.buttons.ButtonTypes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Map<ButtonTypes, Button> _playButton = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _playButton.put(ButtonTypes.Play, findViewById(R.id.Play));
        _playButton.put(ButtonTypes.Settings, findViewById(R.id.Settings));
        _playButton.put(ButtonTypes.Quit, findViewById(R.id.Quit));

        _playButton.get(ButtonTypes.Play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Play.class);
                startActivity(myIntent);
            }
        });
        _playButton.get(ButtonTypes.Settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Settings.class);
                startActivity(myIntent);
            }
        });
    }
}