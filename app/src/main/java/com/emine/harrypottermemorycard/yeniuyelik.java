package com.emine.harrypottermemorycard;

import static android.app.ProgressDialog.show;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class yeniuyelik extends AppCompatActivity {
    private EditText uyemail,kullaniciad,kullanicisifre;
    private String txtkullanicisifre,txtkullaniciad,txtuyemail;
    private Button buton,kullanicigiris;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private HashMap<String,Object> mData;//hangi turde kayıt olacagını bilemediğim için
    MediaPlayer play,ply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeniuyelik);
        ply= MediaPlayer.create(yeniuyelik.this,R.raw.prologue);
        ply.start();
        kullanicisifre=(EditText)findViewById(R.id.eskisifre);
        kullaniciad=(EditText)findViewById(R.id.k_uyemail);
        uyemail=(EditText)findViewById(R.id.uyemail);
        buton=(Button)findViewById(R.id.uyekaydol);
        kullanicigiris=(Button)findViewById(R.id.kullanicigiris);
        mAuth=FirebaseAuth.getInstance();
        kullanicigiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(yeniuyelik.this, MainActivity.class);
                startActivity(ikincisayfagecis);
            }
        });
        mReference= FirebaseDatabase.getInstance().getReference();
        uyemail.setText("");
        kullaniciad.setText("");
        kullanicisifre.setText("");
        buton.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {

                txtkullanicisifre=kullanicisifre.getText().toString();
                txtkullaniciad=kullaniciad.getText().toString();
                txtuyemail=uyemail.getText().toString();
                if(!TextUtils.isEmpty(txtkullanicisifre) && !TextUtils.isEmpty(txtkullaniciad) && !TextUtils.isEmpty(txtuyemail))
                {
                    mAuth.createUserWithEmailAndPassword(txtuyemail,txtkullanicisifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {   mUser=mAuth.getCurrentUser();
                                mData=new HashMap<>();
                                mData.put("kullaniciAdi",txtkullaniciad);
                                mData.put("kullaniciMail",txtuyemail);
                                mData.put("kullaniciSifre",txtkullanicisifre);
                                mData.put("kullaniciId",mUser.getUid());
                                //realtimedatabase ekleme
                                mReference.child("kullanicilar").child("kullaniciAdi").setValue(mData).addOnCompleteListener(yeniuyelik.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())//kayıt işlemi basarı ile gercekleştiyse
                                        {
                                            Toast.makeText(yeniuyelik.this,"Kayıt İşlemi Başarı ile Gerçekleşti.",Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(yeniuyelik.this,"Kayıt İşlemi Başarısız!",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                            }
                        }
                    });


                }}
            });
        }
    }
   /* public void uyekaydolcalistir()
    {
      txtkullanicisifre=kullanicisifre.getText().toString();
      txtkullaniciad=kullaniciad.getText().toString();
      txtuyemail=uyemail.getText().toString();
      if(!TextUtils.isEmpty(txtkullanicisifre) && !TextUtils.isEmpty(txtkullaniciad) && !TextUtils.isEmpty(txtuyemail))
      {
         mAuth.createUserWithEmailAndPassword(txtuyemail,txtkullanicisifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful())
                 {   mUser=mAuth.getCurrentUser();
                     mData=new HashMap<>();
                     mData.put("kullaniciAdi",txtkullaniciad);
                     mData.put("kullaniciMail",txtuyemail);
                     mData.put("kullaniciSifre",txtkullanicisifre);
                     mData.put("kullaniciId",mUser.getUid());
                     mReference.child("kullanicilar").child(mUser.getUid()).setValue(mData).addOnCompleteListener(yeniuyelik.this, new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {
                             if(task.isSuccessful())//kayıt işlemi basarı ile gercekleştiyse
                             {
                                 Toast.makeText(yeniuyelik.this,"Kayıt İşlemi Başarı ile Gerçekleşti.",Toast.LENGTH_SHORT).show();
                             }
                             else{
                                 Toast.makeText(yeniuyelik.this,"Kayıt İşlemi Başarısız!",Toast.LENGTH_SHORT).show();
                             }
                         }
                     });

                 }
             }
         });


}*/

