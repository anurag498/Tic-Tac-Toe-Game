package com.example.tictactoe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    int[] setPosition = {2,2,2,2,2,2,2,2,2};
    int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void playAgain(View view){

        Button play = findViewById(R.id.button);
        Button cancel1 = findViewById(R.id.button2);
        play.setVisibility(View.INVISIBLE);
        cancel1.setVisibility(View.INVISIBLE);
//        GridLayout gridLayout = findViewById(R.id.gridLayout);
//        for(int i = 0; i < gridLayout.getChildCount(); i++) {
//            ImageView posi = (ImageView) gl.getChildAt(i);
//            posi.setImageDrawable(null);
//        }
        ((ImageView)findViewById(R.id.imageView)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView8)).setImageDrawable(null);
        int activePlayer = 0;
        for(int i = 0;i<setPosition.length;i++) {
            setPosition[i] = 2;
        }
        gameActive = true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void closeApp(View view){
        finishAndRemoveTask();
    }
    public void position(View view){
        ImageView posi = (ImageView) view;

        int target = Integer.parseInt(posi.getTag().toString());
        if(setPosition[target] == 2 && gameActive)
        {
            posi.setTranslationY(-1500);
           setPosition[target] = activePlayer;
           if(activePlayer == 0) {
              activePlayer = 1;
              posi.setImageResource(R.drawable.blue);
           }
           else{
            activePlayer = 0;
            posi.setImageResource(R.drawable.red);
           }
           posi.animate().translationYBy(1500).alpha(1).setDuration(300);
           String winner = "";
           for(int[] winPos : winningPos) {
                if (setPosition[winPos[0]] == setPosition[winPos[1]] && setPosition[winPos[1]] == setPosition[winPos[2]] && setPosition[winPos[0]] != 2) {
                   if (activePlayer == 1) {
                    winner = "Blue won the match";

                    }
                   else if (activePlayer == 0) {
                    winner = "Red won the match";
                    }
                gameActive = false;
                Toast.makeText(this, Html.fromHtml("<big><b>"+winner+"</b><big>"), Toast.LENGTH_SHORT).show();
                    Button play = findViewById(R.id.button);
                    Button cancel = findViewById(R.id.button2);
                    play.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                }

           }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}