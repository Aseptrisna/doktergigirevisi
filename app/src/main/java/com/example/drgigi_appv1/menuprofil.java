package com.example.drgigi_appv1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drgigi_appv1.models.User;
import com.example.drgigi_appv1.storage.SharedPrefManager;

public class menuprofil extends AppCompatActivity {


    TextView username, password,nama_lengkap,alamat_rumah,alamat_koresponden,no_kta,no_str,
            no_telp,no_ktp,email,tempattlahir,kouta,cabang_organisasi,organisasi,profesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprofil);



        username = (TextView) findViewById(R.id.nama_lengkap);
        nama_lengkap = (TextView) findViewById(R.id.nama_lengkap);
        alamat_koresponden=(TextView)findViewById(R.id.alamatwork);
        alamat_rumah=(TextView)findViewById(R.id.alamathome);
        cabang_organisasi=(TextView)findViewById(R.id.cab_organ);
        no_ktp=(TextView)findViewById(R.id.no_ktp);
        email=(TextView)findViewById(R.id.email);
        tempattlahir =(TextView)findViewById(R.id.ttll);
        no_telp=(TextView)findViewById(R.id.no_telp);

//        password=(TextView)findViewById(R.id.pembicara);
//        profesi=(TextView)findViewById(R.id.kouta);



        User user= SharedPrefManager.getInstance(this).getUser();
        Toast.makeText(menuprofil.this,user.getNama_lengkap(),Toast.LENGTH_LONG).show();
        email.setText(user.getEmail());

    }

}
