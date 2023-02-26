
package com.emine.harrypottermemorycard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.Random;

import android.os.CountDownTimer;
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

import java.util.ArrayList;
import java.util.Collections;

public class tek4carpi4 extends AppCompatActivity {
    int b;
    private FirebaseAuth authentication;
    private FirebaseUser kullanici;
    private DatabaseReference dataReferance;
    private DocumentReference dokuman;//bu sadece dokuman almak için
    private Button buton;
    BitmapDrawable[] bitmapDizi =new BitmapDrawable[44];
    private TextView textView3;
    private TextView sure;
    private FirebaseFirestore mFirestore;
    int kontrol;
    int kartno1,kartno2,karttoplam,cikarilacak;

    int a;

    // variables para los componentes de la vista
    ImageButton resim0, resim1, resim2, resim3;
    ImageButton resim4, resim5, resim6, resim7;
    ImageButton resim8, resim9, resim10, resim11;
    ImageButton resim12, resim13, resim14, resim15;


    ImageButton[] tablo = new ImageButton[16];
    Button yenidenBaslatButon, cikisYapButon;
    TextView skorboard;
    int puan;
    int dogruCevap;
    Bitmap[] resimler =new Bitmap[8];
    Bitmap[] resimler3 =new Bitmap[44];
    ArrayList<Bitmap> resimler1 =new ArrayList<Bitmap>(44);
    ArrayList<String> resimler6 =new ArrayList<String>(44);
    int randomSayi1, randomSayi2;
    int randomSayi3, randomSayi4;
    int randomSayi5, randomSayi6;
    int randomSayi7, randomSayi8;
    int sonuc=0;
    int sonuc1=0;
    //imagenes

    int arkaPlan;
    ArrayList<Integer> resimler5 =new ArrayList<Integer>(44);
    private TextView timer;
    MediaPlayer play,ply;
    ArrayList<Integer> karistirilmisDizi;
    ImageButton birinci;
    int birinciSayi, ikinciSayi;
    boolean bloke = false;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tek4carpi4);

        Random random = new Random();
        randomSayi1 = random.nextInt(44);
        randomSayi2 = random.nextInt(44);
        randomSayi3 = random.nextInt(44);
        randomSayi4 = random.nextInt(44);
        randomSayi5 = random.nextInt(44);
        randomSayi6 = random.nextInt(44);
        randomSayi7 = random.nextInt(44);
        randomSayi8 = random.nextInt(44);
        init();
        ply= MediaPlayer.create(tek4carpi4.this,R.raw.prologue);
        ply.start();
        init();
        timer=(TextView) findViewById(R.id.timer);


        new CountDownTimer(45000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Süre: "+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                ply=MediaPlayer.create(tek4carpi4.this,R.raw.basarisiz);
                ply.start();
                timer.setText("süre bitti");
                cikisYapButon.callOnClick();


            }
        }.start();

    }
    public void calCliked(View view){
        ply.start();
    }
    public void durdurClickes(View view){
        ply.pause();
    }




    private void TabloOlustur(){
        resim0 = findViewById(R.id.buton0);
        resim1 = findViewById(R.id.buton1);
        resim2 = findViewById(R.id.buton2);
        resim3 = findViewById(R.id.buton3);
        resim4 = findViewById(R.id.buton4);
        resim5 = findViewById(R.id.buton5);
        resim6 = findViewById(R.id.buton6);
        resim7 = findViewById(R.id.buton7);
        resim8 = findViewById(R.id.buton8);
        resim9 = findViewById(R.id.buton9);
        resim10 = findViewById(R.id.buton10);
        resim11 = findViewById(R.id.buton11);
        resim12 = findViewById(R.id.buton12);
        resim13 = findViewById(R.id.buton13);
        resim14 = findViewById(R.id.buton14);
        resim15 = findViewById(R.id.buton15);


        tablo[0] = resim0;
        tablo[1] = resim1;
        tablo[2] = resim2;
        tablo[3] = resim3;
        tablo[4] = resim4;
        tablo[5] = resim5;
        tablo[6] = resim6;
        tablo[7] = resim7;
        tablo[8] = resim8;
        tablo[9] = resim9;
        tablo[10] = resim10;
        tablo[11] = resim11;
        tablo[12] = resim12;
        tablo[13] = resim13;
        tablo[14] = resim14;
        tablo[15] = resim15;


    }

    private void ButonlariYukle(){
        yenidenBaslatButon = findViewById(R.id.oyunuYenidenBaslatButonu);
        cikisYapButon = findViewById(R.id.oyunuBitirButonu);
        yenidenBaslatButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        cikisYapButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void SkorGoster(){
        skorboard = findViewById(R.id.skorBoard);
        puan = 0;
        sonuc=0;
        sonuc1=0;
        dogruCevap = 0;
        skorboard.setText("Puan: " + puan);
    }


    private void ResimleriYukle(){

        int i;
        ArrayList<Bitmap> authors = new ArrayList<Bitmap>();
        authors=anafonksiyon();
        resimler3 =authors.toArray(new Bitmap[44]);
        //imagenesa 8 deger ata,imagenes3 teki degerleri atiycaksın imagenesa




        resimler[0]= resimler3[randomSayi1];
        resimler[1]= resimler3[randomSayi2];
        resimler[2]= resimler3[randomSayi3];
        resimler[3]= resimler3[randomSayi4];
        resimler[4]= resimler3[randomSayi5];
        resimler[5]= resimler3[randomSayi6];
        resimler[6]= resimler3[randomSayi7];
        resimler[7]= resimler3[randomSayi8];



        arkaPlan = R.drawable.a;


    }

















    private ArrayList<Integer> Karistir(int longitud){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            result.add(i % longitud);
        }
        Collections.shuffle(result);
        // System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private void OyunKontrol(int i, final ImageButton gelenResim){
        if(birinci == null){
            birinci = gelenResim;
            birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
            birinci.setImageBitmap(resimler[karistirilmisDizi.get(i)]);
            birinci.setEnabled(false);
            play=MediaPlayer.create(tek4carpi4.this,R.raw.happy);
            play.start();
            birinciSayi = karistirilmisDizi.get(i);
        } else {
            bloke = true;
            gelenResim.setScaleType(ImageView.ScaleType.CENTER_CROP);
            gelenResim.setImageBitmap(resimler[karistirilmisDizi.get(i)]);
            gelenResim.setEnabled(false);
            ikinciSayi = karistirilmisDizi.get(i);
            if(birinciSayi == ikinciSayi){
                birinci = null;
                bloke = false;
                dogruCevap++;
                play=MediaPlayer.create(tek4carpi4.this,R.raw.alkis);
                play.start();

                puanyazdir();


                if(dogruCevap == resimler.length){

                    Toast toast = Toast.makeText(getApplicationContext(), "KAZANDINIZ!", Toast.LENGTH_LONG);
                    toast.show();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        birinci.setImageResource(arkaPlan);
                        birinci.setEnabled(true);
                        gelenResim.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        gelenResim.setImageResource(arkaPlan);
                        gelenResim.setEnabled(true);
                        play= MediaPlayer.create(tek4carpi4.this,R.raw.basarisiz);
                        play.start();
                        bloke = false;
                        birinci = null;
                        puanyazdir2();

                    }
                }, 1000);
            }
        }
    }

    private void init(){
        TabloOlustur();
        ButonlariYukle();
        SkorGoster();
        ResimleriYukle();
        karistirilmisDizi = Karistir(resimler.length);
        for(int i = 0; i< tablo.length; i++){
            tablo[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablo[i].setImageBitmap(resimler[karistirilmisDizi.get(i)]);
            //tablero[i].setImageResource(fondo);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< tablo.length; i++){
                    tablo[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    //tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)]);
                    tablo[i].setImageResource(arkaPlan);
                }
            }
        }, 500);
        for(int i = 0; i< tablo.length; i++) {
            final int j = i;
            tablo[i].setEnabled(true);
            tablo[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloke)
                        OyunKontrol(j, tablo[j]);
                }
            });
        }

    }
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

                    byte[] resimBitleri = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(resimBitleri, 0, resimBitleri.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    resimler1.add(bitmap);


                    String ev = (String) data.get("house");

                }
            }
        });


        return resimler1;
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

                    byte[] resimBitleri = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(resimBitleri, 0, resimBitleri.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    int puan = (int) puan1;
                    resimler5.add(puan);


                    String ev = (String) data.get("house");
                    resimler6.add(ev);

                }

            }

            int sonuc1=0;
            int sonuc2=0;
            int sonuc3=0;
            int evkontrol1 = puanigetir(randomSayi1);
            String evkontrol1puan=Integer.toString(evkontrol1);
            int evkontrol2 = puanigetir(randomSayi2);
            String evkontrol2puan=Integer.toString(evkontrol2);
            int toplam=evkontrol1+evkontrol2;
            String evkontroltoplampuan=Integer.toString(toplam);
            sonuc=sonuc+evkontrol1+evkontrol2;

            if(sonuc>0) {
                skorboard.setText("Puan: " + sonuc*20);
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

                    byte[] resimBilgileri = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(resimBilgileri, 0, resimBilgileri.length);
                    BitmapDrawable drawable = new BitmapDrawable(bitmap);
                    int puan = (int) puan1;
                    resimler5.add(puan);


                    String ev = (String) data.get("house");
                    resimler6.add(ev);

                }

            }

            int evkontrol1 = kaybedilenpuan(randomSayi1);
            String evkontrol1puan=Integer.toString(evkontrol1);
            int evkontrol2 =kaybedilenpuan(randomSayi2);
            String evkontrol2puan=Integer.toString(evkontrol2);
            int toplam=evkontrol1+evkontrol2;
            String evkontroltoplampuan=Integer.toString(toplam);
            sonuc1=sonuc1-evkontrol1-evkontrol2;


            skorboard.setText("Puan: " + sonuc1*25);



        });

    }
    private int puanigetir(int randomSayi1)
    {

        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    int puan = (int) puan1;
                    resimler5.add(puan);
                    String ev = (String) data.get("house");
                    resimler6.add(ev);
                }
            }


            if (resimler6.get(randomSayi1).equals("gryffindor") || resimler6.get(randomSayi1).equals("slytherin")) {
                kontrol= 2 * (resimler5.get(randomSayi1));
            }
            if (resimler6.get(randomSayi1).equals("hufflepuff") || resimler6.get(randomSayi1).equals("ravenclaw")) {
                kontrol= 1 * (resimler5.get(randomSayi1));
            }
            if (resimler6.get(randomSayi2).equals("gryffindor") || resimler6.get(randomSayi2).equals("slytherin")) {
                kontrol=2 * (resimler5.get(randomSayi2));
            }
            if (resimler6.get(randomSayi2).equals("hufflepuff") || resimler6.get(randomSayi2).equals("ravenclaw")) {
                kontrol=1* (resimler5.get(randomSayi2));
            }

        });
        return kontrol;
    }
    private int kaybedilenpuan(int randomSayi1)
    {

        FirebaseFirestore.getInstance().collection("kartinBilgileri").addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
            }
            if (queryDocumentSnapshots != null) {
                for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {
                    Map<String, Object> data = snapshot.getData();
                    long puan1 = (Long) data.get("point");
                    int puan = (int) puan1;
                    resimler5.add(puan);
                    String ev = (String) data.get("house");
                    resimler6.add(ev);
                }
            }
            if(resimler6.get(randomSayi1).equals(resimler6.get(randomSayi2)))
            {
                kartno1= resimler5.get(randomSayi1);
                kartno2= resimler5.get(randomSayi2);
                karttoplam=kartno1+kartno2;
                int cikarilacak;
                if(resimler6.get(randomSayi2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam/2);


                }
                if(resimler6.get(randomSayi2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);


                }
                if(resimler6.get(randomSayi2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);


                }
                if(resimler6.get(randomSayi2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);


                }}
            if(!resimler6.get(randomSayi1).equals(resimler6.get(randomSayi2)))
            {
                kartno1= resimler5.get(randomSayi1);
                kartno2= resimler5.get(randomSayi2);
                karttoplam=kartno1+kartno1;

                if(resimler6.get(randomSayi2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam);


                }
                if(resimler6.get(randomSayi2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);

                }
                if(resimler6.get(randomSayi2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);


                }
                if(resimler6.get(randomSayi2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);


                }}





        });
        return cikarilacak;


        // textoPuntuacion.setText("Puntuación: " +sonuc);
    }
    /*   private int sonsonuc()
       {  int a=kaybedilenpuan(int Random)
          int sonsonuc=sonuc+sonuc1;
          return  sonsonuc;
       }*/
}
//yanliş eşleşme
          /*  int kartno1,kartno2,karttoplam;
            if(imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno1;
                int cikarilacak;
                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }}
            if(!imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno1;
                int cikarilacak;
                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }}

                int sonuc=0;
            sonuc=sonuc+toplam;*/



// textoPuntuacion.setText("Puntuación: " +sonuc);


   /* private void puanyazdir2(int randomNumber2)
    {    int k;
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
                    int puan=(int)puan1;
                    imagenes5.add(puan);



                    String ev = (String) data.get("house");
                    imagenes6.add(ev);

                }

            }
            int toplam=0;
            int toplam2=0;
            int eklenecek1=0;
            int eklenecek2=0;
            int eklenecek3=0;
            int eklenecek4=0;
            int eklenecek5=0;
            int eklenecek6=0;
            int eklenecek7=0;
            int eklenecek8=0;
 if(imagenes6.get(randomNumber2).equals("gryffindor"))
            {
               eklenecek5=2*(imagenes5.get(randomNumber2));
                toplam=toplam+eklenecek5;
                textoPuntuacion.setText("Puntuación: " +toplam);

            }
            if(imagenes6.get(randomNumber2).equals("slytherin"))
            {
               eklenecek6=2*(imagenes5.get(randomNumber2));
                toplam=toplam+eklenecek6;
                textoPuntuacion.setText("Puntuación: " +toplam);

            }
            if(imagenes6.get(randomNumber2).equals("hufflepuff"))
            {
               eklenecek7=1*(imagenes5.get(randomNumber2));
                toplam=toplam+eklenecek7;
                textoPuntuacion.setText("Puntuación: " +toplam);

            }
            if(imagenes6.get(randomNumber2).equals("ravenclaw"))
            {
                 eklenecek8=1*(imagenes5.get(randomNumber2));
                toplam=toplam+eklenecek8;
                textoPuntuacion.setText("Puntuación: " +toplam);

            }
            //yanliş eşleşme
          /*  int kartno1,kartno2,karttoplam;
            if(imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno1;
                int cikarilacak;
                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }}
            if(!imagenes6.get(randomNumber1).equals(imagenes6.get(randomNumber2)))
            {
                kartno1=imagenes5.get(randomNumber1);
                kartno2=imagenes5.get(randomNumber2);
                karttoplam=kartno1+kartno1;
                int cikarilacak;
                if(imagenes6.get(randomNumber2).equals("gryffindor"))
                {
                    cikarilacak=(int)(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("slytherin"))
                {
                    cikarilacak=(int)(karttoplam/2);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("hufflepuff"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }
                if(imagenes6.get(randomNumber2).equals("ravenclaw"))
                {
                    cikarilacak=(karttoplam);
                    toplam=toplam-cikarilacak;

                }}

                int sonuc=0;
            sonuc=sonuc+toplam;



            // textoPuntuacion.setText("Puntuación: " +sonuc);

        });

    }*/