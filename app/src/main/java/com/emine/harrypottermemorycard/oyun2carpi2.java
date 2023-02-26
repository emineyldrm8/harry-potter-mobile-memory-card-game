package com.emine.harrypottermemorycard;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import java.util.Random;
import android.content.Intent;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class oyun2carpi2 extends AppCompatActivity {
    int b;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mReference;
    private DocumentReference mdoc;//bu sadece dokuman almak için
    private Button buton;
    BitmapDrawable[] bitmapdizisi=new BitmapDrawable[44];
    private TextView textView3;
    private TextView timeText;
    private FirebaseFirestore mFirestore;
    int kontrol;
    int kartno1,kartno2,karttoplam,cikarilacak;
    Bitmap[] base64format=new Bitmap[44];
    ArrayList<Integer> imagenes5=new ArrayList<Integer>(44);
    int a;
    ImageButton imagebuton0,imagebuton1,imagebuton2,imagebuton3;
    ImageButton[] tablom = new ImageButton[4];
    Button oyunuYenidenbaslat,oyunuBitir;
    TextView skorBoard;
    int puanDegeri;
    int hedef;
    Bitmap[] imagenes=new Bitmap[2];
    Bitmap[] imagenes3=new Bitmap[44];
    ArrayList<Bitmap> imagenes1=new ArrayList<Bitmap>(44);
    ArrayList<String> imagenes6=new ArrayList<String>(44);
    int randomNumber1,randomNumber2;
    MediaPlayer Caldir, Oynat;
    int sonuc=0;
    int sonuc1=0;
    //imagenes
    int arkaplanid;
    ArrayList<Integer> karistirmaDizisi;
    ImageButton ilk;
    int ilkkartnumarasi,ikincikartnumarasi;
    boolean kontrolbayraki = false;
   Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        Oynat = MediaPlayer.create(oyun2carpi2.this, R.raw.prologue); //Oyun basladiginda muzik caliyor.
        Oynat.start();//muzik baslatiliyor.
        Oynat = MediaPlayer.create(oyun2carpi2.this, R.raw.prologue); //Oyun basladiginda muzik caliyor.
        init();

      //  sure = (TextView) findViewById(R.id.sureBilgisi);
      //  cikisButonu = findViewById(R.id.oyunuBitirButonu);
       // init();
       /* new CountDownTimer(45000, 1000) { //Kalan sure hesaplaniyor.
            @Override
            public void onTick(long millisUntilFinished) {
                sure.setText("Kalan Süre: " + millisUntilFinished / 1000);//Kullaniciya gosteriliyor.
            }

            @Override
            public void onFinish() {
                Caldir = MediaPlayer.create(kolayTek.this, R.raw.basarisiz);//Kullanici basarisiz oldugunda calacak muzik
                Caldir.start();
                sure.setText("Süre Bitti!");
                cikisButonu.callOnClick();
            }
        }.start();*/


    }
    public void calFonksiyon(View view) {
        Oynat.start();
    }

    public void durdurFonksiyon(View view) {
        Oynat.pause();
    }
    private void tabloOlustur(){
        imagebuton0= findViewById(R.id.boton00);
        imagebuton1= findViewById(R.id.boton01);
        imagebuton2= findViewById(R.id.boton02);
        imagebuton3= findViewById(R.id.boton03);
        tablom[0] = imagebuton0;
        tablom[1] =  imagebuton1;
        tablom[2] =  imagebuton2;
        tablom[3] =  imagebuton3;
    }
    private void butonlariAktifEt(){
        oyunuYenidenbaslat = findViewById(R.id.botonJuegoReiniciar);
        oyunuBitir= findViewById(R.id.botonJuegoSalir);
        oyunuYenidenbaslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        oyunuBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void kartAyarla(){
        skorBoard= findViewById(R.id.texto_puntuacion);
        puanDegeri= 0;
        sonuc=0;
        sonuc1=0;
        hedef= 0;
        skorBoard.setText("PUANINIZ: " +puanDegeri);
    }
    private void resimlereRandomAta(){

        int i;
        ArrayList<Bitmap> authors = new ArrayList<Bitmap>();
        authors=anafonksiyon();
        imagenes3=authors.toArray(new Bitmap[44]);
        //imagenesa 8 deger ata,imagenes3 teki degerleri atiycaksın imagenesa
        imagenes[0]=imagenes3[randomNumber1];
        imagenes[1]=imagenes3[randomNumber2];
        arkaplanid = R.drawable.a;
    }
    private ArrayList<Integer> oyunDuzeni(int longitud){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            result.add(i % longitud);
        }
        Collections.shuffle(result);
        // System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private void resimKarsilastir(int i, final ImageButton imgb){
        if(ilk== null){
            ilk= imgb;
            ilk.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ilk.setImageBitmap(imagenes[karistirmaDizisi.get(i)]);
            ilk.setEnabled(false);
            ilkkartnumarasi= karistirmaDizisi.get(i);
        } else {
            kontrolbayraki= true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageBitmap(imagenes[ karistirmaDizisi.get(i)]);
            imgb.setEnabled(false);
            ikincikartnumarasi =  karistirmaDizisi.get(i);
            if(ilkkartnumarasi==ikincikartnumarasi){
                ilk= null;
                kontrolbayraki= false;
                hedef++;

                puanyazdir();


                if(hedef == imagenes.length){

                    Toast toast = Toast.makeText(getApplicationContext(), "KAZANDINIZ!", Toast.LENGTH_LONG);
                    toast.show();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ilk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        ilk.setImageResource(arkaplanid);
                        ilk.setEnabled(true);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(arkaplanid);
                        imgb.setEnabled(true);
                        kontrolbayraki= false;
                        ilk= null;
                        puanyazdir2();

                    }
                }, 1000);
            }
        }
    }

    private void init(){
        tabloOlustur();
        butonlariAktifEt();
        kartAyarla();
        resimlereRandomAta();
        karistirmaDizisi= oyunDuzeni(imagenes.length);
        for(int i=0; i<tablom.length; i++){
            tablom[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablom[i].setImageBitmap(imagenes[ karistirmaDizisi.get(i)]);

        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<tablom.length; i++){
                    tablom[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tablom[i].setImageResource(arkaplanid);
                }
            }
        }, 500);
        for(int i=0; i<tablom.length; i++) {
            final int j = i;
            tablom[i].setEnabled(true);
            tablom[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!kontrolbayraki){
                        resimKarsilastir(j,tablom[j]);
                }
            }
        });

    }}
    private ArrayList<Bitmap> anafonksiyon()
    {    int k;
        //   ArrayList<Bitmap> imagenes = new ArrayList<>(44);
        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                //    Toast.makeText(CiftOyuncu.this, Objects.requireNonNull(e.getLocalizedMessage()), Toast.LENGTH_LONG).show();
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();

                    String isim = (String) data.get("name");

                    String resim = (String) data.get("image");

                    byte[] imageBytes = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    imagenes1.add(bitmap);


                    String ev = (String) data.get("house");

                }
            }
        });


        return imagenes1;
    }
    private void puanyazdir() {
        int k;
        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                //    Toast.makeText(CiftOyuncu.this, Objects.requireNonNull(e.getLocalizedMessage()), Toast.LENGTH_LONG).show();
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    String isim = (String) data.get("name");

                    String resim = (String) data.get("image");

                    byte[] imageBytes = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    int puan = (int) puan1;
                    imagenes5.add(puan);


                    String ev = (String) data.get("house");
                    imagenes6.add(ev);

                }

            }

            int sonuc1=0;
            int sonuc2=0;
            int sonuc3=0;
            int evkontrol1 = puanigetir(randomNumber1);
            String evkontrol1puan=Integer.toString(evkontrol1);
            int evkontrol2 = puanigetir(randomNumber2);
            String evkontrol2puan=Integer.toString(evkontrol2);
            int toplam=evkontrol1+evkontrol2;
            String evkontroltoplampuan=Integer.toString(toplam);
            sonuc=sonuc+evkontrol1+evkontrol2;

            if(sonuc>0) {
                skorBoard.setText("PUANINIZ: " + sonuc);
            }




        });
    }
    private void puanyazdir2() {
        int k;
        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                //    Toast.makeText(CiftOyuncu.this, Objects.requireNonNull(e.getLocalizedMessage()), Toast.LENGTH_LONG).show();
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    String isim = (String) data.get("name");

                    String resim = (String) data.get("image");

                    byte[] imageBytes = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    int puan = (int) puan1;
                    imagenes5.add(puan);


                    String ev = (String) data.get("house");
                    imagenes6.add(ev);

                }

            }

            int evkontrol1 = kaybedilenpuan(randomNumber1);
            String evkontrol1puan=Integer.toString(evkontrol1);
            int evkontrol2 =kaybedilenpuan(randomNumber2);
            String evkontrol2puan=Integer.toString(evkontrol2);
            int toplam=evkontrol1+evkontrol2;
            String evkontroltoplampuan=Integer.toString(toplam);
            sonuc1=sonuc1-evkontrol1-evkontrol2;


            skorBoard.setText("PUANINIZ: " + sonuc1);



        });

    }
    private int puanigetir(int randomNumber1)
    {

        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    int puan = (int) puan1;
                    imagenes5.add(puan);
                    String ev = (String) data.get("house");
                    imagenes6.add(ev);
                }
            }


            if (imagenes6.get(randomNumber1).equals("gryffindor") || imagenes6.get(randomNumber1).equals("slytherin")) {
                kontrol= 2 * (imagenes5.get(randomNumber1));
            }
            if (imagenes6.get(randomNumber1).equals("hufflepuff") || imagenes6.get(randomNumber1).equals("ravenclaw")) {
                kontrol= 1 * (imagenes5.get(randomNumber1));
            }
            if (imagenes6.get(randomNumber2).equals("gryffindor") || imagenes6.get(randomNumber2).equals("slytherin")) {
                kontrol=2 * (imagenes5.get(randomNumber2));
            }
            if (imagenes6.get(randomNumber2).equals("hufflepuff") || imagenes6.get(randomNumber2).equals("ravenclaw")) {
                kontrol=1* (imagenes5.get(randomNumber2));
            }

        });
        return kontrol;
    }
    private int kaybedilenpuan(int RandomNumber1)
    {

        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    int puan = (int) puan1;
                    imagenes5.add(puan);
                    String ev = (String) data.get("house");
                    imagenes6.add(ev);
                }
            }
            if(imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno2;
                int cikarilacak;
                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam/2);


                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);


                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);


                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);


                }}
            if(!imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno1;

                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam);


                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);

                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);


                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);


                }}
        });
        return cikarilacak;
    }

}
