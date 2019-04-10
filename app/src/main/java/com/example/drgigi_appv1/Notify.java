package com.example.drgigi_appv1;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Notify extends AppCompatActivity {

    String[] TITLE = {"Sample Acara 01", "Sample Acara 02", "Sample Acara 03", "Sample Acara 04", "Sample Acara 05", "Sample Acara 06", "Sample Acara 07", "Sample Acara 08", "Sample Acara 09", "Sample Acara 10"};
    String[] TIME = {"Minggu, 14 Januari 2019", "Jumat, 11 Oktober 2019", "Selasa, 21 Juni 2019", "Senin, 29 Juli 2019", "Minggu, 14 Juli 2019", "Sabtu, 11 Agustus 2019", "Sabtu, 10 Septermber 2019", "Minggu, 22 Desember 2019", "Rabu, 12 Februari 2019", "Senin, 21 Maret 2019"};
    String[] SPEAKER = {"Drg. Gita Sujiwo", "Drg. Kamal Sula", "Drg. Bagus Raya", "Drg. Citra Santani", "Drg. Hanung Bima", "Drg. Andra Bakhti", "Drg. Masayu Katrine", "Drg. Andi Guntoro", "Drg. Vina Yulia", "Drg. Herdiansyah"};
    String[] COST = {"500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000"};
    String[] PERSON = {"100", "150", "100", "250", "150", "200", "100", "100", "150", "200"};
    String[] KEC = {"Labuhan Ratu", "Kedaton", "Buay Pemaca", "Rebang Tangkas", "Banjit", "Lenkong", "Kasui", "Tanjun karang pusat", "Tanjung Karang Barat", "kota bumi"};
    String[] KAB = {"Bandar Lampung", "Bandar Lampung", "Oku Selatan", "Way Kanan", "Way Kanan", "Bandung", "Way Kanan", "Bandar Lampung", "Bandar Lampung", "Lampung Utara"};

    ListView listView;
    LinearLayout one, two;
    Animation uptodown, downtoup;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        coordinatorLayout = findViewById(R.id.MyNotify);
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        one.setAnimation(uptodown);
        two.setAnimation(downtoup);

        listView = (ListView)findViewById(R.id.listNotify);
        listAdapter adapter = new listAdapter(Notify.this, TITLE, TIME, SPEAKER, COST, PERSON,KEC,KAB);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Notify.this, ""+TITLE[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}