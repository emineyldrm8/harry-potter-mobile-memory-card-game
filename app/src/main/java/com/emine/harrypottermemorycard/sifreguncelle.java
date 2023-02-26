package com.emine.harrypottermemorycard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class sifreguncelle extends AppCompatActivity {
    private EditText kullanicisifre,kullaniciad,kullaniciyenisifre;

    private String txtkullanicisifre,txtkullaniciad,txtyenisifre;
    private Button buton,sifrebutton;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private Button anasayfa;
    private TextView textView3;
    private HashMap<String,Object> mData;
    MediaPlayer play,ply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifreguncelle);

        ply= MediaPlayer.create(sifreguncelle.this,R.raw.prologue);
        ply.start();
        kullanicisifre=(EditText)findViewById(R.id.eskisifre);
        kullaniciad=(EditText)findViewById(R.id.k_uyemail);
        kullaniciyenisifre=(EditText)findViewById(R.id.yenisifre);
        anasayfa=(Button)findViewById(R.id.button2);
        buton=(Button)findViewById(R.id.button);
        sifrebutton=(Button)findViewById(R.id.sifredegis);
        kullaniciad.setText("");
        kullanicisifre.setText("");
        kullaniciyenisifre.setText("");
        mAuth=FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ikincisayfagecis=new Intent(sifreguncelle.this, MainActivity.class);
                startActivity(ikincisayfagecis);
            }
        });
        buton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtkullanicisifre=kullanicisifre.getText().toString();
                txtkullaniciad=kullaniciad.getText().toString();

                if(!TextUtils.isEmpty(txtkullanicisifre) && !TextUtils.isEmpty(txtkullaniciad)){

                    Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(txtkullaniciad, txtkullanicisifre).addOnSuccessListener(sifreguncelle.this,new OnSuccessListener<AuthResult>(){

                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(sifreguncelle.this, "GİRİŞ BAŞARILI!", Toast.LENGTH_SHORT).show();
                            mUser = mAuth.getCurrentUser();
                            if (mUser != null) {
                                VerileriGetir(mUser.getUid());
                            }
                        }
                    });
                }else{
                    Toast.makeText(sifreguncelle.this,"KULLANICI ADI VE ŞİFRE BOŞ BIRAKILAMAZ!",Toast.LENGTH_SHORT).show();

                }

            }


        });
        sifrebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtyenisifre=kullaniciyenisifre.getText().toString();
                if(!TextUtils.isEmpty(txtyenisifre))
                {
                    mData=new HashMap<>();

                    mData.put("kullaniciSifre",txtyenisifre);
                    assert mUser!=null;
                    veriGuncelle(mData,mUser.getUid());

                }
                else
                {
                    Toast.makeText(sifreguncelle.this,"GÜNCELLENECEK DEĞER BOŞ OLAMAZ!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    //verileri getir baslangic
    private void VerileriGetir(String uid)
    {
       mReference= FirebaseDatabase.getInstance().getReference().child(uid);
       mReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot snp:snapshot.getChildren())
               {
                   System.out.println(snp.getKey()+"="+snp.getValue());
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


    }
    //verileri getir bitiş
    //veri guncelle baslangic
    private void veriGuncelle(HashMap<String,Object> hashmap, final String uid)
    {
     mReference=FirebaseDatabase.getInstance().getReference("kullanicilar").child(uid);
     mReference.updateChildren(hashmap).addOnCompleteListener(this,new OnCompleteListener<Void>()
    {


        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if(task.isSuccessful())
            {
                Toast.makeText(sifreguncelle.this,"ŞİFRE GÜNCELLENDİ!",Toast.LENGTH_SHORT).show();

            }
        }
    });



    }
    //veriguncelle bitiş
    //sifredegisbaslangic
    public void sifredegis(View view)
    {
             txtyenisifre=kullaniciyenisifre.getText().toString();
             if(!TextUtils.isEmpty(txtyenisifre))
             {
                 mData=new HashMap<>();

                 mData.put("kullaniciSifre",txtyenisifre);
                         assert mUser!=null;
                 veriGuncelle(mData,mUser.getUid());

             }
             else
             {
                 Toast.makeText(sifreguncelle.this,"GÜNCELLENECEK DEĞER BOŞ OLAMAZ!",Toast.LENGTH_SHORT).show();
             }

    }
}