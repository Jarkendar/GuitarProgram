package com.example.jarek.guitarprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void random_click(View view) {
        ButtonAnimation(view);
        Intent random_option = new Intent(this, randomActivity.class);
        startActivity(random_option);
    }

    public void note_click(View view) {
        ButtonAnimation(view);
        Intent note_option = new Intent(this, noteActivity.class);
        startActivity(note_option);
    }

    public void chord_click(View view) {
        ButtonAnimation(view);
        Intent chord_option = new Intent(this, chordActivity.class);
        startActivity(chord_option);
    }

    public void power_chord_click(View view) {
        ButtonAnimation(view);
        Intent power_chord_option = new Intent(this, powerchordActivity.class);
        startActivity(power_chord_option);
    }

    private void ButtonAnimation(View view){
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.button_click_scale);
        view.startAnimation(scale);
    }

    public void endClick(View view) {
        ButtonAnimation(view);
        finish();
    }
}
