package com.example.drgigi_appv1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.example.drgigi_appv1.network.ApiService;
import com.example.drgigi_appv1.network.InitRetrofit;
import com.example.drgigi_appv1.response.BeritaItem;
import com.example.drgigi_appv1.response.ResponseBerita;

import com.example.drgigi_appv1.models.User;
import com.example.drgigi_appv1.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//
//    int[] IMAGES = {R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb, R.drawable.thumb};
//    String[] TITLE = {"Sample Acara 01", "Sample Acara 02", "Sample Acara 03", "Sample Acara 04", "Sample Acara 05", "Sample Acara 06", "Sample Acara 07", "Sample Acara 08", "Sample Acara 09", "Sample Acara 10"};
//    String[] TIME = {"Minggu, 14 Januari 2019", "Jumat, 11 Oktober 2019", "Selasa, 21 Juni 2019", "Senin, 29 Juli 2019", "Minggu, 14 Juli 2019", "Sabtu, 11 Agustus 2019", "Sabtu, 10 Septermber 2019", "Minggu, 22 Desember 2019", "Rabu, 12 Februari 2019", "Senin, 21 Maret 2019"};
//    String[] SPEAKER = {"Drg. Gita Sujiwo", "Drg. Kamal Sula", "Drg. Bagus Raya", "Drg. Citra Santani", "Drg. Hanung Bima", "Drg. Andra Bakhti", "Drg. Masayu Katrine", "Drg. Andi Guntoro", "Drg. Vina Yulia", "Drg. Herdiansyah"};
//    String[] COST = {"500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000", "500,000"};
//    String[] PERSON = {"100", "150", "100", "250", "150", "200", "100", "100", "150", "200"};
//    String[] KEC = {"Labuhan Ratu", "Kedaton", "Buay Pemaca", "Rebang Tangkas", "Banjit", "Lenkong", "Kasui", "Tanjun karang pusat", "Tanjung Karang Barat", "kota bumi"};
//    String[] KAB = {"Bandar Lampung", "Bandar Lampung", "Oku Selatan", "Way Kanan", "Way Kanan", "Bandung", "Way Kanan", "Bandar Lampung", "Bandar Lampung", "Lampung Utara"};
//
// Deklarasi Widget
private RecyclerView recyclerView;

    LinearLayout one, two;
    Animation uptodown, downtoup;
    private CoordinatorLayout coordinatorLayout;
    ListView gridView;
    ImageButton notif,logout;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User user= SharedPrefManager.getInstance(this).getUser();
        Toast.makeText(MainActivity.this,user.getEmail(),Toast.LENGTH_LONG).show();

        coordinatorLayout = findViewById(R.id.MyMain);
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        one.setAnimation(uptodown);
        two.setAnimation(downtoup);



        // Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.rvListBerita);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method
        tampilBerita();

//        gridView = (ListView)findViewById(R.id.listAcara);
//        gridAdapter adapter = new gridAdapter(MainActivity.this, IMAGES, TITLE, TIME, SPEAKER, COST, PERSON,KEC,KAB);
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Menampilkan Detail "+TITLE[position], Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, Details.class);
//                startActivity(intent);
//            }
//        });

        notif = findViewById(R.id.notifyBtn);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toNotif();
            }
        });


        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keluar();
            }
        });

    }
    private void keluar(){
        SharedPrefManager.getInstance(MainActivity.this).clear();
        Intent intent = new Intent(MainActivity.this,SignIn.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void toNotif(){
        Intent sign = new Intent(this, Notify.class);
        startActivity(sign);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
                System.exit(0);
            }
        },2000);
    };

    private void tampilBerita() {
        ApiService api = InitRetrofit.getInstance();
        // Siapkan request
        Call<ResponseBerita> beritaCall = api.request_show_all_berita();
        // Kirim request
        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<BeritaItem> data_berita = response.body().getBerita();
                    boolean status = response.body().isStatus();
                    // Kalau response status nya = true
//                    if (status){
//                        // Buat Adapter untuk recycler view
                        AdapterBerita adapter = new AdapterBerita(MainActivity.this, data_berita);
                        recyclerView.setAdapter(adapter);
//                    } else {
                        // kalau tidak true
//                        Toast.makeText(MainActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
//                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                // print ke log jika Error
                t.printStackTrace();
            }
        });
    }











}
