package com.example.jarek.guitarprogram;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class powerchordActivity extends AppCompatActivity {

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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerchord);

        bA = (Button) findViewById(R.id.button_rA);
        bB = (Button) findViewById(R.id.button_rB);
        bC = (Button) findViewById(R.id.button_rC);
        bD = (Button) findViewById(R.id.button_rD);
        pchord[0] = "A5";
        pchord[1] = "B5";
        pchord[2] = "Bb5";
        pchord[3] = "C5";
        pchord[4] = "D5";
        pchord[5] = "E5";
        pchord[6] = "F5";
        pchord[7] = "G5";
        pchord[8] = "e5";
        RandomChooses();
        scoreboard = (TextView) findViewById(R.id.number_score);
        score = 0;
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    public void end_click(View v) {
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
        Random rand = new Random(System.currentTimeMillis());
        byte ch1, ch2, ch3, ch4, opA, opB, opC, opD;
        //losowanie utworów
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
        //losowanie miejsca
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

        switch (choose) {
            case 0: {
                soundID = R.raw.a5;
                break;
            }
            case 1: {
                soundID = R.raw.b5;
                break;
            }
            case 2: {
                soundID = R.raw.bb5;
                break;
            }
            case 3: {
                soundID = R.raw.c5;
                break;
            }
            case 4: {
                soundID = R.raw.d5;
                break;
            }
            case 5: {
                soundID = R.raw.e50;
                break;
            }
            case 6: {
                soundID = R.raw.f5;
                break;
            }
            case 7: {
                soundID = R.raw.g5;
                break;
            }
            case 8: {
                soundID = R.raw.e57;
                break;
            }
        }
        playSound();
    }

    private void ButtonAnimation(View view){
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.button_click_scale);
        view.startAnimation(scale);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "powerchord Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.jarek.guitarprogram/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "powerchord Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.jarek.guitarprogram/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
