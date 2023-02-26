package com.emine.harrypottermemorycard;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

public class oyun6carpi6 extends AppCompatActivity {
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
    String [] kartadidizi= new String[44];//0.indexte karta adi,1.indexte kart evi,2.indexte kart pauni,3.indexte kartın resmi
    String [] kartevidizi= new String[44];
    String [] kartpuanidizi= new String[44];
    String [] kartresmidizi= new String[44];
    Bitmap[] base64format=new Bitmap[44];
    int a;
    // variables para los componentes de la vista
    ImageButton imb00, imb01, imb02, imb03, imb04, imb05, imb06, imb07, imb08, imb09;
    ImageButton  imb10, imb11, imb12, imb13, imb14, imb15, imb16, imb17, imb18, imb19;
    ImageButton  imb20, imb21, imb22, imb23, imb24, imb25, imb26, imb27, imb28, imb29;
    ImageButton  imb30, imb31, imb32, imb33, imb34, imb35;

    ImageButton[] tablero = new ImageButton[36];
    Button botonReiniciar, botonSalir;
    TextView textoPuntuacion;
    int puntuacion;
    int aciertos;
    Bitmap[] imagenes=new Bitmap[18];
    Bitmap[] imagenes3=new Bitmap[44];
    ArrayList<Bitmap> imagenes1=new ArrayList<Bitmap>(44);
    //imagenes
    int fondo;
    ArrayList<Integer> arrayDesordenado;
    ImageButton primero;
    int numeroPrimero, numeroSegundo;
    boolean bloqueo = false;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);
        init();
    }
    private void cargarTablero(){
        imb00 = findViewById(R.id.boton00);
        imb01 = findViewById(R.id.boton01);
        imb02 = findViewById(R.id.boton02);
        imb03 = findViewById(R.id.boton03);
        imb04 = findViewById(R.id.boton04);
        imb05 = findViewById(R.id.boton05);
        imb06 = findViewById(R.id.boton06);
        imb07 = findViewById(R.id.boton07);
        imb08 = findViewById(R.id.boton08);
        imb09 = findViewById(R.id.boton09);
        imb10 = findViewById(R.id.boton10);
        imb11 = findViewById(R.id.boton11);
        imb12 = findViewById(R.id.boton12);
        imb13 = findViewById(R.id.boton13);
        imb14 = findViewById(R.id.boton14);
        imb15 = findViewById(R.id.boton15);
        imb16 = findViewById(R.id.boton16);
        imb17 = findViewById(R.id.boton17);
        imb18 = findViewById(R.id.boton18);
        imb19 = findViewById(R.id.boton19);
        imb20 = findViewById(R.id.boton20);
        imb21 = findViewById(R.id.boton21);
        imb22 = findViewById(R.id.boton22);
        imb23 = findViewById(R.id.boton23);
        imb24 = findViewById(R.id.boton24);
        imb25 = findViewById(R.id.boton25);
        imb26 = findViewById(R.id.boton26);
        imb27 = findViewById(R.id.boton27);
        imb28 = findViewById(R.id.boton28);
        imb29 = findViewById(R.id.boton29);
        imb30 = findViewById(R.id.boton30);
        imb31 = findViewById(R.id.boton31);
        imb32 = findViewById(R.id.boton32);
        imb33 = findViewById(R.id.boton33);
        imb34 = findViewById(R.id.boton34);
        imb35 = findViewById(R.id.boton35);


        tablero[0] = imb00;
        tablero[1] = imb01;
        tablero[2] = imb02;
        tablero[3] = imb03;
        tablero[4] = imb04;
        tablero[5] = imb05;
        tablero[6] = imb06;
        tablero[7] = imb07;
        tablero[8] = imb08;
        tablero[9] = imb09;
        tablero[10] = imb10;
        tablero[11] = imb11;
        tablero[12] = imb12;
        tablero[13] = imb13;
        tablero[14] = imb14;
        tablero[15] = imb15;
        tablero[16] = imb16;
        tablero[17] = imb17;
        tablero[18] = imb18;
        tablero[19] = imb19;
        tablero[20] = imb20;
        tablero[21] = imb21;
        tablero[22] = imb22;
        tablero[23] = imb23;
        tablero[24] = imb24;
        tablero[25] = imb25;
        tablero[26] = imb26;
        tablero[27] = imb27;
        tablero[28] = imb28;
        tablero[29] = imb29;
        tablero[30] = imb30;
        tablero[31] = imb31;
        tablero[32] = imb32;
        tablero[33] = imb33;
        tablero[34] = imb34;
        tablero[35] = imb35;

    }

    private void cargarBotones(){
        botonReiniciar = findViewById(R.id.botonJuegoReiniciar);
        botonSalir = findViewById(R.id.botonJuegoSalir);
        botonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void cargarTexto(){
        textoPuntuacion = findViewById(R.id.texto_puntuacion);
        puntuacion = 0;
        aciertos = 0;
        textoPuntuacion.setText("Puntuacion: " + puntuacion);
    }


    private void cargarImagenes(){

        int i;
        ArrayList<Bitmap> authors = new ArrayList<Bitmap>();
        authors=anafonksiyon();
        imagenes3=authors.toArray(new Bitmap[44]);

        //imagenesa 8 deger ata,imagenes3 teki degerleri atiycaksın imagenesa
        //18 kart olacak
        //4 tane 0-11 arası
        //4 tane 12-22
        //5 tane 23-33
        //5 tane 34-44
        Random random = new Random();
        int randomNumber1= random.nextInt(11-0)+0;
        int randomNumber2= random.nextInt(11-0)+0;
        int randomNumber3= random.nextInt(11-0)+0;
        int randomNumber4= random.nextInt(11-0)+0;

        int randomNumber5= random.nextInt(22-12)+12;
        int randomNumber6= random.nextInt(22-12)+12;
        int randomNumber7= random.nextInt(22-12)+12;
        int randomNumber8= random.nextInt(22-12)+12;

        int randomNumber9= random.nextInt(33-23)+23;
        int randomNumber10= random.nextInt(33-23)+23;
        int randomNumber11= random.nextInt(33-23)+23;
        int randomNumber12 = random.nextInt(33-23)+23;
        int randomNumber13= random.nextInt(33-23)+23;
        int randomNumber14= random.nextInt(44-34)+34;
        int randomNumber15= random.nextInt(44-34)+34;
        int randomNumber16 = random.nextInt(44-34)+34;
        int randomNumber17= random.nextInt(44-34)+34;
        int randomNumber18= random.nextInt(44-34)+34;



        imagenes[0]=imagenes3[randomNumber1];
        imagenes[1]=imagenes3[randomNumber2];
        imagenes[2]=imagenes3[randomNumber3];
        imagenes[3]=imagenes3[randomNumber4];
        imagenes[4]=imagenes3[randomNumber5];
        imagenes[5]=imagenes3[randomNumber6];
        imagenes[6]=imagenes3[randomNumber7];
        imagenes[7]=imagenes3[randomNumber8];
        imagenes[8]=imagenes3[randomNumber1];
        imagenes[9]=imagenes3[randomNumber2];
        imagenes[10]=imagenes3[randomNumber11];
        imagenes[11]=imagenes3[randomNumber12];
        imagenes[12]=imagenes3[randomNumber13];
        imagenes[13]=imagenes3[randomNumber14];
        imagenes[14]=imagenes3[randomNumber15];
        imagenes[15]=imagenes3[randomNumber16];
        imagenes[16]=imagenes3[randomNumber17];
        imagenes[17]=imagenes3[randomNumber18];




        fondo = R.drawable.a;








        fondo = R.drawable.a;








    }

















    private ArrayList<Integer> barajar(int longitud){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<longitud*2; i++){
            result.add(i % longitud);
        }
        Collections.shuffle(result);
        // System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

    private void comprobar(int i, final ImageButton imgb){
        if(primero == null){
            primero = imgb;
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageBitmap(imagenes[arrayDesordenado.get(i)]);
            primero.setEnabled(false);
            numeroPrimero = arrayDesordenado.get(i);
        } else {
            bloqueo = true;
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageBitmap(imagenes[arrayDesordenado.get(i)]);
            imgb.setEnabled(false);
            numeroSegundo = arrayDesordenado.get(i);
            if(numeroPrimero == numeroSegundo){
                primero = null;
                bloqueo = false;
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);
                if(aciertos == imagenes.length){
                    Toast toast = Toast.makeText(getApplicationContext(), "Has ganado!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            } else {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(fondo);
                        primero.setEnabled(true);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(fondo);
                        imgb.setEnabled(true);
                        bloqueo = false;
                        primero = null;
                        puntuacion--;
                        textoPuntuacion.setText("Puntuación: " + puntuacion);
                    }
                }, 1000);
            }
        }
    }

    private void init(){
        cargarTablero();
        cargarBotones();
        cargarTexto();
        cargarImagenes();
        arrayDesordenado = barajar(imagenes.length);
        for(int i=0; i<tablero.length; i++){
            tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablero[i].setImageBitmap(imagenes[arrayDesordenado.get(i)]);
            //tablero[i].setImageResource(fondo);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<tablero.length; i++){
                    tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    //tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)]);
                    tablero[i].setImageResource(fondo);
                }
            }
        }, 500);
        for(int i=0; i<tablero.length; i++) {
            final int j = i;
            tablero[i].setEnabled(true);
            tablero[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, tablero[j]);
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
                    String puan = (String)(data.get("point"));
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
}