package com.example.drgigi_appv1;

import android.text.util.Linkify;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
public class detailacara extends AppCompatActivity {

    // Deklarasi
    ImageView ivGambarBerita;
    TextView tvTglTerbit, tvPenulis,speaker,alamat,kecamatan,kab,cost,person,cp,email,materi,kouta;
    WebView wvKontenBerita;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailacara);

       back=(ImageButton)findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toback();
            }
        });
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //       setSupportActionBar(toolbar);

//        TextView fab = (TextView) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Inisialisasi
        ivGambarBerita = (ImageView) findViewById(R.id.pamlet);
        tvTglTerbit = (TextView) findViewById(R.id.tanggalacara);
        tvPenulis = (TextView) findViewById(R.id.judul);
        kecamatan=(TextView)findViewById(R.id.kecamatan);
        kab=(TextView)findViewById(R.id.kabupaten);
        cost=(TextView)findViewById(R.id.biaya);
        person=(TextView)findViewById(R.id.kouta);
        cp=(TextView)findViewById(R.id.kontakperson);
        email=(TextView)findViewById(R.id.mailacara);
        materi =(TextView)findViewById(R.id.isimateri);
        speaker=(TextView)findViewById(R.id.pembicara);
        alamat=(TextView)findViewById(R.id.alamatacara);


        //wvKontenBerita = (WebView) findViewById(R.id.);

        // Jalankan method tampil detail berita
        showDetailBerita();

    }


    public void toback(){
        Intent sign = new Intent(this, MainActivity.class);
        startActivity(sign);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    private void showDetailBerita() {
        // Tangkap data dari intent
        String judul_seminar = getIntent().getStringExtra("JDL_SMR");
        String kota = getIntent().getStringExtra("KOTA_SMR");
        String tanggal = getIntent().getStringExtra("TGL_SMR");
        String kec = getIntent().getStringExtra("KEC_SMR");
        String narasumber = getIntent().getStringExtra("NARASUMBER");
        String foto = getIntent().getStringExtra("FOTO");
        String materii = getIntent().getStringExtra("MATERI");
        String koutaa = getIntent().getStringExtra("KOUTA");
        String biayaa= getIntent().getStringExtra("BIAYA");
        String cpp = getIntent().getStringExtra("CP");
        String emaill = getIntent().getStringExtra("EMAIL");
        String Almt = getIntent().getStringExtra("LOKASI");



        // Set judul actionbar / toolbar
//        getSupportActionBar().setTitle(judul_berita);

        // Set ke widget
        tvPenulis.setText(judul_seminar);
        tvTglTerbit.setText( tanggal);
        kecamatan.setText( kec);
        kab.setText( kota);
        materi.setText( materii);
        person.setText(koutaa);
        cost.setText(biayaa);
        cp.setText( cpp);
        Linkify.addLinks(cp,Linkify.ALL);
        email.setText( emaill);
        speaker.setText(narasumber);
        alamat.setText( Almt);

        //tvTglTerbit.setText(tanggal_berita);
        // Untuk gambar berita
        Picasso.with(this).load(foto).into(ivGambarBerita);
//        // Set isi berita sebagai html ke WebView
//        wvKontenBerita.getSettings().setJavaScriptEnabled(true);
//        wvKontenBerita.loadData(isi_berita, "text/html; charset=utf-8", "UTF-8");
    }
}