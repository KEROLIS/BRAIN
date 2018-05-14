package com.example.kerolis.atry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;



public class winning extends AppCompatActivity {

MainActivity s=new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_winning);
        TextView sco= (TextView) findViewById(R.id.sco);
        final TextView s= (TextView) findViewById(R.id.textView3);
        Button again = (Button) findViewById(R.id.again);
        sco.setText(MainActivity.correct+" / "+MainActivity.times);
        s.setTranslationY(-1000f);
        s.animate().rotation(360f).translationYBy(1000f).setDuration(300);
        sco.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(1000);
        again.animate().alpha(1f).setDuration(1500);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final  Intent intent=new Intent(winning.this,MainActivity.class);

                MainActivity a=new MainActivity();
                a.aga();

                startActivity(intent);
                finish();


            }
        });

    }
}
