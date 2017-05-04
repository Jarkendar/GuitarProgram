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

public class noteActivity extends AppCompatActivity {

    private Button bA;
    private Button bB;
    private Button bC;
    private Button bD;
    private String[] pchord = new String[37];
    private byte choose;
    private int soundID;
    private MediaPlayer mp;
    private int score = 0;
    private TextView scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        bA = (Button) findViewById(R.id.button_rA);
        bB = (Button) findViewById(R.id.button_rB);
        bC = (Button) findViewById(R.id.button_rC);
        bD = (Button) findViewById(R.id.button_rD);
        pchord[0] = "A 110Hz";
        pchord[1] = "a 220Hz";
        pchord[2] = "a1 440Hz";
        pchord[3] = "Ais 117Hz";
        pchord[4] = "ais 233Hz";
        pchord[5] = "ais1 466Hz";
        pchord[6] = "B 123Hz";
        pchord[7] = "b 246Hz";
        pchord[8] = "b1 493Hz";
        pchord[9] = "c 131Hz";
        pchord[10] = "c1 261Hz";
        pchord[11] = "c2 523Hz";
        pchord[12] = "cis 139Hz";
        pchord[13] = "cis1 277Hz";
        pchord[14] = "cis2 554Hz";
        pchord[15] = "d 147Hz";
        pchord[16] = "d1 293Hz";
        pchord[17] = "d2 587Hz";
        pchord[18] = "dis 155Hz";
        pchord[19] = "dis1 311Hz";
        pchord[20] = "dis2 622Hz";
        pchord[21] = "E 82Hz";
        pchord[22] = "e 165Hz";
        pchord[23] = "e1 330Hz";
        pchord[24] = "e2 660Hz";
        pchord[25] = "F 87Hz";
        pchord[26] = "f 174Hz";
        pchord[27] = "f1 349Hz";
        pchord[28] = "Fis 92Hz";
        pchord[29] = "fis 185Hz";
        pchord[30] = "fis1 369Hz";
        pchord[31] = "G 98Hz";
        pchord[32] = "g 196Hz";
        pchord[33] = "g1 390Hz";
        pchord[34] = "Gis 104Hz";
        pchord[35] = "gis 207Hz";
        pchord[36] = "gis1 415Hz";
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
        Random rand = new Random(System.currentTimeMillis());
        byte ch1, ch2, ch3, ch4, opA, opB, opC, opD;
        //losowanie utworów
        choose = ch1 = (byte) rand.nextInt(36);
        do {
            ch2 = (byte) rand.nextInt(36);
        } while (ch1 == ch2);
        do {
            ch3 = (byte) rand.nextInt(36);
        } while (ch1 == ch3 || ch2 == ch3);
        do {
            ch4 = (byte) rand.nextInt(36);
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
                soundID = R.raw.a_110hz;
                break;
            }
            case 1: {
                soundID = R.raw.a_220hz;
                break;
            }
            case 2: {
                soundID = R.raw.a1_440hz;
                break;
            }
            case 3: {
                soundID = R.raw.ais_117hz;
                break;
            }
            case 4: {
                soundID = R.raw.ais_233hz;
                break;
            }
            case 5: {
                soundID = R.raw.ais1_466hz;
                break;
            }
            case 6: {
                soundID = R.raw.b_123hz;
                break;
            }
            case 7: {
                soundID = R.raw.b_246hz;
                break;
            }
            case 8: {
                soundID = R.raw.b1_493hz;
                break;
            }
            case 9: {
                soundID = R.raw.c_131hz;
                break;
            }
            case 10: {
                soundID = R.raw.c1_261hz;
                break;
            }
            case 11: {
                soundID = R.raw.c2_523hz;
                break;
            }
            case 12: {
                soundID = R.raw.cis_139hz;
                break;
            }
            case 13: {
                soundID = R.raw.cis1_277hz;
                break;
            }
            case 14: {
                soundID = R.raw.cis2_554hz;
                break;
            }
            case 15: {
                soundID = R.raw.d_147hz;
                break;
            }
            case 16: {
                soundID = R.raw.d1_293hz;
                break;
            }
            case 17: {
                soundID = R.raw.d2_587hz;
                break;
            }
            case 18: {
                soundID = R.raw.dis_155hz;
                break;
            }
            case 19: {
                soundID = R.raw.dis1_311hz;
                break;
            }
            case 20: {
                soundID = R.raw.dis2_622hz;
                break;
            }
            case 21: {
                soundID = R.raw.e_82hz;
                break;
            }
            case 22: {
                soundID = R.raw.e_165hz;
                break;
            }
            case 23: {
                soundID = R.raw.e1_330hz;
                break;
            }
            case 24: {
                soundID = R.raw.e2_660hz;
                break;
            }
            case 25: {
                soundID = R.raw.f_87hz;
                break;
            }
            case 26: {
                soundID = R.raw.f_174hz;
                break;
            }
            case 27: {
                soundID = R.raw.f1_349hz;
                break;
            }
            case 28: {
                soundID = R.raw.fis_92hz;
                break;
            }
            case 29: {
                soundID = R.raw.fis_185hz;
                break;
            }
            case 30: {
                soundID = R.raw.fis1_369hz;
                break;
            }
            case 31: {
                soundID = R.raw.g_98hz;
                break;
            }
            case 32: {
                soundID = R.raw.g_196hz;
                break;
            }
            case 33: {
                soundID = R.raw.g1_390hz;
                break;
            }
            case 34: {
                soundID = R.raw.gis_104hz;
                break;
            }
            case 35: {
                soundID = R.raw.gis_207hz;
                break;
            }
            case 36: {
                soundID = R.raw.gis1_415hz;
            }
        }
        playSound();
    }

    private void ButtonAnimation(View view){
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.button_click_scale);
        view.startAnimation(scale);
    }
}
