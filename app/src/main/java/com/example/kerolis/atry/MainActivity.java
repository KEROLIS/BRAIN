package com.example.kerolis.atry;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     int x;
     int y;
     int wow;
     int la;
    static int times=0;
    static int correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Button go= (Button) findViewById(R.id.Go);
        final RelativeLayout game= (RelativeLayout) findViewById(R.id.game);
        final LinearLayout ready= (LinearLayout) findViewById(R.id.ready);
        final RelativeLayout main= (RelativeLayout) findViewById(R.id.activity_main);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {game.setVisibility(View.VISIBLE);
                ready.setVisibility(View.GONE);
                play();
                tim();

            }});
    }
   public void play()
    {
        Random rand=new Random();

        Button choose[]=
                {       (Button) findViewById(R.id.cho1),
                        (Button) findViewById(R.id.cho2),
                        (Button) findViewById(R.id.cho3),
                        (Button) findViewById(R.id.cho4)
                };
        x=rand.nextInt(21);
        y=rand.nextInt(21);
        TextView equation= (TextView) findViewById(R.id.eq);
        equation.setText(x+" + "+y);
        wow=rand.nextInt(4);
        for (int i = 0; i <4 ; i++) {
            if(i==wow)
            { choose[i].setText(x+y+" ");
                choose[i].setTag(2);
            }
            else{la=rand.nextInt(41);
                if (la==x+y)i--;
                else
                choose[i].setText(la+" ");
                }




        }
    }
  public void press(View view)
    {TextView score= (TextView) findViewById(R.id.score);
        times++;
        if (Integer.parseInt(view.getTag().toString())==2)
    {Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        correct++;}
         else
             {Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();}
              score.setText(correct+" / "+times);

        play();
    }
    public  void tim()
    {
        final TextView ti= (TextView) findViewById(R.id.ti);

        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                ti.setText ((int) (millisUntilFinished/1000)+" ");
            }

            @Override
            public void onFinish()
            {
               final  Intent intent=new Intent(MainActivity.this,winning.class);
                startActivity(intent);
                finish();
            }
        }.start();


    }
    public void aga()
    {
        correct=0;
        times=0;


    }

}
