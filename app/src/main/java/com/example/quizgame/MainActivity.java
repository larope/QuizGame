package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizgame.buttons.MenuButtons;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<MenuButtons, Button> _menuButtons = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _menuButtons.put(MenuButtons.Play, findViewById(R.id.Play));
        _menuButtons.put(MenuButtons.Settings, findViewById(R.id.Settings));
        _menuButtons.put(MenuButtons.Quit, findViewById(R.id.Quit));

        _menuButtons.get(MenuButtons.Play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Play.class);
                startActivity(myIntent);
            }
        });
        _menuButtons.get(MenuButtons.Settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), Settings.class);
                startActivity(myIntent);
            }
        });
    }
}