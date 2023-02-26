//4*4 cift oyuncu
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

public class oyun extends AppCompatActivity {
    int b;
    private FirebaseAuth authentication;
    private FirebaseUser kullanici;
    private DatabaseReference dataReferans;
    private DocumentReference dokuman;//bu sadece dokuman almak için
    private Button buton;
    BitmapDrawable[] bitmapDizi =new BitmapDrawable[44];
    private TextView textView3;
    private TextView sure;
    private FirebaseFirestore mFirestore;
    MediaPlayer play;

    String [] kartadidizi= new String[44];//0.indexte karta adi,1.indexte kart evi,2.indexte kart pauni,3.indexte kartın resmi
    String [] kartevidizi= new String[44];
    String [] kartpuanidizi= new String[44];
    String [] kartresmidizi= new String[44];
    Bitmap[] base64format=new Bitmap[44];
    ImageView[] dizi2=new ImageView[44];
    ImageView resim1;

    ImageView resim2;

    ImageView resim3 ;

    ImageView resim4;
    ImageView resim5;

    ImageView resim6 ;
    ImageView resim7;
    int puan2;
    ImageView resim8 ;

    ImageView resim9;

    ImageView resim10;

    ImageView resim11;

    ImageView resim12;

    ImageView resim13;

    ImageView resim14;

    ImageView resim15;
    ArrayList<String> resimler6 =new ArrayList<String>(44);
    ArrayList<Integer> resimler5=new ArrayList<Integer>(44);
    int randomSayi1;
    int randomSayi2;
    int sonuc;
    ImageView resim16;
    ImageView resim17;
    ImageView resim18 ;
    int kontrol;
    ImageButton birinci2;
    ImageView resim19;
    // ImageView dizi2[]=new ImageView[44];
    ImageView resim20;

    ImageView resim21;

    ImageView resim22;

    ImageView resim23;

    ImageView resim24;

    ImageView resim25;

    ImageView resim26;

    ImageView resim27;
    ImageView resim28 ;

    ImageView resim29;

    ImageView resim30;

    ImageView resim31;

    ImageView resim32;

    ImageView resim33;

    ImageView resim34;

    ImageView resim35;

    ImageView resim36;
    ImageView resim37;
    ImageView resim38 ;

    ImageView resim39;

    ImageView resim40;

    ImageView resim41;

    ImageView resim42;

    ImageView resim43;

    ImageView resim44;
    int[] dizi=new int[44];


    int a;




    // variables para los componentes de la vista
    ImageButton resimButon0, resimButon1, resimButon2, resimButon3, resimButon4, resimButon5, resimButon6, resimButon7, resimButon8, resimButon9, resimButon10, resimButon11, resimButon12, resimButon13, resimButon14, resimButon15;
    ImageButton[] tablo = new ImageButton[16];
    Button yenidenBaslatButon, cikisButon;
    TextView skor1;
    TextView skor2;
    int puan;
    int dogruCevap;
    Bitmap[] resimler =new Bitmap[8];
    Bitmap[] resimler3 =new Bitmap[44];
    ArrayList<Bitmap> resimler1 =new ArrayList<Bitmap>(44);

    //imagenes
    MediaPlayer ply;
    private TextView timer;
    int arkaPlan;


    ArrayList<Integer> karisikDizi;
    ImageButton birinci;
    int birinciNumara, ikinciNumara;
    boolean bloke = false;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        ply=MediaPlayer.create(oyun.this,R.raw.prologue);
        ply.start();
        init();
        timer=(TextView) findViewById(R.id.timer1);


        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Süre: "+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                ply=MediaPlayer.create(oyun.this,R.raw.basarisiz);
                ply.start();
                timer.setText("süre bitti");
                cikisButon.callOnClick();


            }
        }.start();





















        //initialize etme



















        init();
    }



    private void TabloOlustur(){
        resimButon0 = findViewById(R.id.boton00);
        resimButon1 = findViewById(R.id.boton01);
        resimButon2 = findViewById(R.id.boton02);
        resimButon3 = findViewById(R.id.boton03);
        resimButon4 = findViewById(R.id.boton04);
        resimButon5 = findViewById(R.id.boton05);
        resimButon6 = findViewById(R.id.boton06);
        resimButon7 = findViewById(R.id.boton07);
        resimButon8 = findViewById(R.id.boton08);
        resimButon9 = findViewById(R.id.boton09);
        resimButon10 = findViewById(R.id.boton10);
        resimButon11 = findViewById(R.id.boton11);
        resimButon12 = findViewById(R.id.boton12);
        resimButon13 = findViewById(R.id.boton13);
        resimButon14 = findViewById(R.id.boton14);
        resimButon15 = findViewById(R.id.boton15);

        tablo[0] = resimButon0;
        tablo[1] = resimButon1;
        tablo[2] = resimButon2;
        tablo[3] = resimButon3;
        tablo[4] = resimButon4;
        tablo[5] = resimButon5;
        tablo[6] = resimButon6;
        tablo[7] = resimButon7;
        tablo[8] = resimButon8;
        tablo[9] = resimButon9;
        tablo[10] = resimButon10;
        tablo[11] = resimButon11;
        tablo[12] = resimButon12;
        tablo[13] = resimButon13;
        tablo[14] = resimButon14;
        tablo[15] = resimButon15;
    }

    private void ButonYukle(){
        yenidenBaslatButon = findViewById(R.id.yenidenBaslatButon);
        cikisButon = findViewById(R.id.cikisButon);
        yenidenBaslatButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        cikisButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void SkorGoster(){
        skor1 = findViewById(R.id.texto_puntuacion);
        skor2 = findViewById(R.id.texto2_puntuacion);
        puan = 0;
        sonuc=0;
        dogruCevap = 0;
        skor1.setText("Puntuacion: " + puan);
    }


    private void ResimleriYukle(){

        int i;
        ArrayList<Bitmap> authors = new ArrayList<Bitmap>();
        authors=anafonksiyon();
        resimler3 =authors.toArray(new Bitmap[44]);
        //imagenesa 8 deger ata,imagenes3 teki degerleri atiycaksın imagenesa
        Random random = new Random();
        int randomSayi= random.nextInt(44);
        int randomSayi2 = random.nextInt(44);
        int randomSayi3= random.nextInt(44);
        int randomSayi4= random.nextInt(44);
        int randomSayi5= random.nextInt(44);
        int randomSayi6 = random.nextInt(44);
        int randomSayi7= random.nextInt(44);
        int randomSayi8= random.nextInt(44);


        resimler[0]= resimler3[randomSayi];
        resimler[1]= resimler3[randomSayi2];
        resimler[2]= resimler3[randomSayi3];
        resimler[3]= resimler3[randomSayi4];
        resimler[4]= resimler3[randomSayi5];
        resimler[5]= resimler3[randomSayi6];
        resimler[6]= resimler3[randomSayi7];
        resimler[7]= resimler3[randomSayi8];


        arkaPlan = R.drawable.a;








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

    private void OyunKontrol(int i, final ImageButton resimButonu){
        if(birinci == null){
            birinci = resimButonu;
            birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
            birinci.setImageBitmap(resimler[karisikDizi.get(i)]);
            birinci.setEnabled(false);
            play= MediaPlayer.create(oyun.this,R.raw.happy);
            play.start();
            birinciNumara = karisikDizi.get(i);
        } else {
            bloke = true;
            resimButonu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            resimButonu.setImageBitmap(resimler[karisikDizi.get(i)]);
            resimButonu.setEnabled(false);
            ikinciNumara = karisikDizi.get(i);
            if(birinciNumara == ikinciNumara){
                birinci = null;
                bloke = false;
                dogruCevap++;
                play=MediaPlayer.create(oyun.this,R.raw.alkis);
                play.start();
                puan++;
                skor1.setText("Puntuación: " + puan);
                if(dogruCevap == resimler.length){
                    Toast toast = Toast.makeText(getApplicationContext(), "Tebrikler!!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        birinci.setImageResource(arkaPlan);
                        birinci.setEnabled(true);
                        resimButonu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        resimButonu.setImageResource(arkaPlan);
                        resimButonu.setEnabled(true);
                        play= MediaPlayer.create(oyun.this,R.raw.basarisiz);
                        play.start();
                        bloke = false;
                        birinci = null;
                        OyunKontrol2(i,resimButonu);
                    }
                }, 1000);
            }
        }

    }

    private void OyunKontrol2(int i, final ImageButton resimButonu){
      //  skor2.setText("2YE UGRADIM BİR GECERKEN");
        resimButonu.setEnabled(true);
        resimButonu.setImageResource(arkaPlan);

        if(birinci == null){
          //  skor2.setText("2NİN NULLUNDAYIM");
            birinci = resimButonu;
            birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
            birinci.setImageBitmap(resimler[karisikDizi.get(i)]);
            birinci.setEnabled(false);
            birinciNumara = karisikDizi.get(i);
        } else {
          //  skor2.setText("PUAN HESAPLIYCAM SÖZ");
            bloke = true;
            resimButonu.setScaleType(ImageView.ScaleType.CENTER_CROP);
            resimButonu.setImageBitmap(resimler[karisikDizi.get(i)]);
            resimButonu.setEnabled(false);
            ikinciNumara = karisikDizi.get(i);
          //  skor2.setText("2.OYUNCU Puntuación: " + puan);
            if(birinciNumara == ikinciNumara){
                birinci = null;
                bloke = false;
                dogruCevap++;
                puan++;
              //  skor2.setText("2.OYUNCU Puntuación: " + puan);
                if(dogruCevap == resimler.length){
                    Toast toast = Toast.makeText(getApplicationContext(), "KAZANDINIZ!!", Toast.LENGTH_LONG);
                   toast.show();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                     //   skor2.setText("2.OYUNCU YANLIŞ BİLDİ");
                        birinci.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        birinci.setImageResource(arkaPlan);
                        birinci.setEnabled(true);
                        resimButonu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        resimButonu.setImageResource(arkaPlan);
                        resimButonu.setEnabled(true);
                        bloke = false;
                        birinci = null;

                        OyunKontrol(i,resimButonu);
                    }
                }, 1000);
            }
        }

    }


    private void init(){
        TabloOlustur();
        ButonYukle();
        SkorGoster();
        ResimleriYukle();
        karisikDizi = Karistir(resimler.length);
        for(int i = 0; i< tablo.length; i++){
            tablo[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablo[i].setImageBitmap(resimler[karisikDizi.get(i)]);
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
                    //  String puan = (String)(data.get("point"));
                    String isim = (String) data.get("name");

                    String resim = (String) data.get("image");

                    byte[] imageBytes = Base64.decode(resim, Base64.DEFAULT);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
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

            if(sonuc>-40 && sonuc<70) {
                skor1.setText("BİRİNCİ OYUNCU PUAN" + sonuc*25);
            }
            else {
                skor2.setText("İKİNCİ OYUNCU PUAN: " + sonuc*34);
            }





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
                    resimler5.add(puan);
                    String ev = (String) data.get("house");
                    resimler6.add(ev);
                }
            }


            if (resimler6.get(randomNumber1).equals("gryffindor") || resimler6.get(randomNumber1).equals("slytherin")) {
                kontrol= 2 * (resimler5.get(randomNumber1));
            }
            if (resimler6.get(randomNumber1).equals("hufflepuff") || resimler6.get(randomNumber1).equals("ravenclaw")) {
                kontrol= 1 * (resimler5.get(randomNumber1));
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

}