package com.emine.harrypottermemorycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secimEkrani extends AppCompatActivity {
    private Button tek,cok;
    MediaPlayer play,ply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secim_ekrani);
        ply= MediaPlayer.create(secimEkrani.this,R.raw.prologue);
        ply.start();
        tek=(Button)findViewById(R.id.buton1);
        cok=(Button)findViewById(R.id.buton2);
        tek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(secimEkrani.this, zorluksecim.class);
                startActivity(ikincisayfagecis);
            }
        });
        cok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(secimEkrani.this, zorluksecimcift.class);
                startActivity(ikincisayfagecis);
            }
        });

    }
}