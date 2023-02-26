package com.emine.harrypottermemorycard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText kullanicisifre,kullaniciad;
    private Button kullanicigiris,kullaniciyeniuyelik,sifredegis;
    private String txtkullanicisifre,txtkullaniciad;
    private Button buton;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private TextView textView3;
    MediaPlayer play,ply;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ply= MediaPlayer.create(MainActivity.this,R.raw.prologue);
        ply.start();
        kullanicisifre=(EditText)findViewById(R.id.eskisifre);
        kullaniciad=(EditText)findViewById(R.id.k_uyemail);
        sifredegis=(Button)findViewById(R.id.sifredegis);
        kullanicigiris=(Button)findViewById(R.id.kullanicigris);
        kullaniciyeniuyelik=(Button)findViewById(R.id.kullaniciyeniuyelik);

        mAuth=FirebaseAuth.getInstance();//mAuth initilaize edilir
        String path;
        //DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("kullanicilar");
        mReference= FirebaseDatabase.getInstance().getReference().child("kullanicilar");
        kullaniciad.setText("");
        kullanicisifre.setText("");
        kullaniciyeniuyelik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(MainActivity.this, yeniuyelik.class);
                startActivity(ikincisayfagecis);
            }
        });
        sifredegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(MainActivity.this, sifreguncelle.class);
                startActivity(ikincisayfagecis);
            }
        });

        kullanicigiris.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtkullanicisifre=kullanicisifre.getText().toString();
                txtkullaniciad=kullaniciad.getText().toString();

                if(!TextUtils.isEmpty(txtkullanicisifre) && !TextUtils.isEmpty(txtkullaniciad)){
                    mAuth.signInWithEmailAndPassword(txtkullaniciad,txtkullanicisifre).addOnSuccessListener(MainActivity.this,new OnSuccessListener<AuthResult>()
                    {

                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity.this,"GİRİŞ BAŞARILI!",Toast.LENGTH_SHORT).show();
                            Intent ikincisayfagecis=new Intent(MainActivity.this, secimEkrani.class);
                            startActivity(ikincisayfagecis);
                        }
                    }).addOnFailureListener(MainActivity.this,new OnFailureListener()
                    {

                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this,"KULLANICI ADI VE ŞİFRE BOŞ BIRAKILAMAZ!",Toast.LENGTH_SHORT).show();

                }

                }


    });}}
