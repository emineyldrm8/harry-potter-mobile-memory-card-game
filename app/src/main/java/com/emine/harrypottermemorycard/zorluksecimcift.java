package com.emine.harrypottermemorycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class zorluksecimcift extends AppCompatActivity {
    private Button kolay,orta,zor;
    MediaPlayer play,ply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zorluksecim);
        ply= MediaPlayer.create(zorluksecimcift.this,R.raw.prologue);
        ply.start();
        kolay=(Button)findViewById(R.id.button5);
        orta=(Button)findViewById(R.id.buton1);
        zor=(Button)findViewById(R.id.button6);
        kolay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(zorluksecimcift.this,zor2carpi2.class);
                startActivity(ikincisayfagecis);
            }
        });
        orta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(zorluksecimcift.this,oyun.class);
                startActivity(ikincisayfagecis);
            }
        });
        zor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(zorluksecimcift.this,cift6carpi6.class);
                startActivity(ikincisayfagecis);
            }
        });

    }
}