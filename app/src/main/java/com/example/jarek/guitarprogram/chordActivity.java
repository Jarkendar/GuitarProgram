package com.example.jarek.guitarprogram;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class chordActivity extends AppCompatActivity {

    private Button bA;
    private Button bB;
    private Button bC;
    private Button bD;
    private String[] pchord = new String[9];
    private byte choose;
    private int soundID;
    private MediaPlayer mp;
    private int score = 0;
    private TextView scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord);

        bA = (Button) findViewById(R.id.button_rA);
        bB = (Button) findViewById(R.id.button_rB);
        bC = (Button) findViewById(R.id.button_rC);
        bD = (Button) findViewById(R.id.button_rD);
        pchord[0] = "A-dur";
        pchord[1] = "A-moll";
        pchord[2] = "C-dur";
        pchord[3] = "D-dur";
        pchord[4] = "D-moll";
        pchord[5] = "E-dur";
        pchord[6] = "E-moll";
        pchord[7] = "F-dur";
        pchord[8] = "G-dur";
        RandomChooses();
        scoreboard = (TextView) findViewById(R.id.number_score);
        score = 0;
    }

    public void choose_option(View view) {
        ButtonAnimation(view);
        int ch = view.getId();
        String download;
        Toast commun = Toast.makeText(getApplicationContext(), "Źle", Toast.LENGTH_SHORT);
        switch (ch) {// weryfikacja poprawności wybranej odpowiedzi
            case R.id.button_rA: {
                download = (String) bA.getText();
                if (pchord[choose].equals(download)) {
                    score++;
                    commun = Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT);
                    RandomChooses();
                    break;
                }
                score = 0;
                break;
            }
            case R.id.button_rB: {
                download = (String) bB.getText();
                if (pchord[choose].equals(download)) {
                    score++;
                    commun = Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT);
                    RandomChooses();
                    break;
                }
                score = 0;
                break;
            }
            case R.id.button_rC: {
                download = (String) bC.getText();
                if (pchord[choose].equals(download)) {
                    score++;
                    commun = Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT);
                    RandomChooses();
                    break;
                }
                score = 0;
                break;
            }
            case R.id.button_rD: {
                download = (String) bD.getText();
                if (pchord[choose].equals(download)) {
                    score++;
                    commun = Toast.makeText(getApplicationContext(), "Dobrze", Toast.LENGTH_SHORT);
                    RandomChooses();
                    break;
                }
                score = 0;
                break;
            }
        }
        commun.show();
        scoreboard.setText(""+score);
    }

    public void end_click(View v){
        ButtonAnimation(v);
        finish();
    }

    public void play_click(View view) {
        ButtonAnimation(view);
        playSound();
    }

    private void playSound() {
        if (mp != null) {//zabezpieczenie przed odtworzeniem poprzedniego wyboru
            mp.release();
        }
        mp = MediaPlayer.create(this, soundID);
        mp.start();
    }

    private void RandomChooses() {
        Random rand = new Random(System.currentTimeMillis());//losowa losowość
        byte ch1, ch2, ch3, ch4, opA, opB, opC, opD;
        //losowanie utworów bez dubli
        choose = ch1 = (byte) rand.nextInt(8);
        do {
            ch2 = (byte) rand.nextInt(8);
        } while (ch1 == ch2);
        do {
            ch3 = (byte) rand.nextInt(8);
        } while (ch1 == ch3 || ch2 == ch3);
        do {
            ch4 = (byte) rand.nextInt(8);
        } while (ch1 == ch4 || ch2 == ch4 || ch3 == ch4);
        //losowanie miejsca bez dubli
        opA = (byte) rand.nextInt(4);
        do {
            opB = (byte) rand.nextInt(4);
        } while (opA == opB);
        do {
            opC = (byte) rand.nextInt(4);
        } while (opA == opC || opB == opC);
        do {
            opD = (byte) rand.nextInt(4);
        } while (opA == opD || opB == opD || opC == opD);

        switch (opA) {
            case 0: {
                bA.setText(pchord[ch1]);
                break;
            }
            case 1: {
                bA.setText(pchord[ch2]);
                break;
            }
            case 2: {
                bA.setText(pchord[ch3]);
                break;
            }
            case 3: {
                bA.setText(pchord[ch4]);
                break;
            }
        }
        switch (opB) {
            case 0: {
                bB.setText(pchord[ch1]);
                break;
            }
            case 1: {
                bB.setText(pchord[ch2]);
                break;
            }
            case 2: {
                bB.setText(pchord[ch3]);
                break;
            }
            case 3: {
                bB.setText(pchord[ch4]);
                break;
            }
        }
        switch (opC) {
            case 0: {
                bC.setText(pchord[ch1]);
                break;
            }
            case 1: {
                bC.setText(pchord[ch2]);
                break;
            }
            case 2: {
                bC.setText(pchord[ch3]);
                break;
            }
            case 3: {
                bC.setText(pchord[ch4]);
                break;
            }
        }
        switch (opD) {
            case 0: {
                bD.setText(pchord[ch1]);
                break;
            }
            case 1: {
                bD.setText(pchord[ch2]);
                break;
            }
            case 2: {
                bD.setText(pchord[ch3]);
                break;
            }
            case 3: {
                bD.setText(pchord[ch4]);
                break;
            }
        }
        //wybór wylosowanego utworu klucza
        switch (choose) {
            case 0: {
                soundID = R.raw.a_dur;
                break;
            }
            case 1: {
                soundID = R.raw.a_moll;
                break;
            }
            case 2: {
                soundID = R.raw.c_dur;
                break;
            }
            case 3: {
                soundID = R.raw.d_dur;
                break;
            }
            case 4: {
                soundID = R.raw.d_moll;
                break;
            }
            case 5: {
                soundID = R.raw.e_dur;
                break;
            }
            case 6: {
                soundID = R.raw.e_moll;
                break;
            }
            case 7: {
                soundID = R.raw.f_dur;
                break;
            }
            case 8: {
                soundID = R.raw.g_dur;
                break;
            }
        }
        playSound();
    }

    private void ButtonAnimation(View view){
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.button_click_scale);
        view.startAnimation(scale);
    }
}
