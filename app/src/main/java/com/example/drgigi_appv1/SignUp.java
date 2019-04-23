package com.example.drgigi_appv1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drgigi_appv1.api.RetrofitClient;
import com.example.drgigi_appv1.models.DefaultResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ScrollView coordinatorLayout;
    private EditText username,password,ktp,ttl,fullName,email,phoneNumber,
            alamat_rumah,alamat_korespondensi, profesi,no_kta,no_str,no_npm;

    LinearLayout one, two;
    Animation uptodown, downtoup;
    Button up, in;
    ProgressDialog progressDialog;
    RadioGroup rg;
    Bitmap bitmap;
    ImageView imageView,str,kta,ktm;
    Button selectImg,fotostr,fotokta,fotoktm;
   TextView imgTitle,jdlstr,jdlkta,jdlkm;
    private static final int IMAGE = 100;
    String[] jenis  = {"",  "Dokter","Dokter Spesialis","Dokter Gigi","Dokter Gigi Spesialis","Mahasiswa Kedokteran","Mahasiswa Kedokteran Gigi"};
    String tempJenis;
    Spinner spinner;

    String[] organisasi  = {"", "PDGI","IDI","MAHASISWA"};
    String temporgan;
    Spinner spinner1;

    String[] cabang  = {"", "Aceh","Sumatra Utara","Sumatra Barat","Riau","Kepulaan Riau",
            "Jambi","Sumtra Selatan","Bangka Belitung","Bengkulu",
            "Lampung","Dki Jakarta","Jawa Barat","Banten","Jawa Tengah","DI Yogyakarta",
            "Jawa Timur","Bali","NTB","NTT","Kalimantan Selatan","Kalimantan Tengah",
            "Kalimantan Timur","Kalimantan Utara","Kalimantan Barat","Sulawesi Utara",
            "Sulawesi barat","Sulawesi Tengah","Sulawesi Tenggara","Sulawesi Selatan",
            "Gorontalo","Sulawesi Tengah","Sulawesi Tenggara","Sulawesi Selatan","Gorontalo",
            "Maluku","Maluku Utara","Papua Barat","Papua"};
    String tempcabang;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);


//        imageView = (ImageView) findViewById(R.id.imageView);
//        selectImg = (Button) findViewById(R.id.pilihfoto);
//        imgTitle = (TextView) findViewById(R.id.imgTitle);
//
//        str= (ImageView) findViewById(R.id.imageSTR);
//        fotostr = (Button) findViewById(R.id.pilihfotostr);
//        jdlstr = (TextView) findViewById(R.id.imgSTR);
//
//        kta = (ImageView) findViewById(R.id.imagekta);
//        fotokta = (Button) findViewById(R.id.pilihfotostr);
//        jdlkta = (TextView) findViewById(R.id.imgkta);
//
//        ktm = (ImageView) findViewById(R.id.imagektm);
//        fotoktm = (Button) findViewById(R.id.pilihfotoktm);
//        jdlkm = (TextView) findViewById(R.id.imgktm);



        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        ktp= findViewById(R.id.idktp);
        ttl = findViewById(R.id.ttl);

        phoneNumber= findViewById(R.id.phonewa);
        fullName = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        alamat_rumah = findViewById(R.id.alamat);
        alamat_korespondensi=findViewById(R.id.korespondensi);
        no_kta=findViewById(R.id.nokta);
        no_str=findViewById(R.id.str);
        no_npm=findViewById(R.id.npm);
        coordinatorLayout = findViewById(R.id.MySignUp);
        in = (Button) findViewById(R.id.signin);
        up = (Button) findViewById(R.id.signup);
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        one.setAnimation(uptodown);
        two.setAnimation(downtoup);

         spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> Ajenis= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,jenis);
        Ajenis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Ajenis);

 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position,
    long id) {
   // TODO Auto-generated method stub
   tempJenis = jenis[position];

      if (position==6) {
          no_npm.setVisibility(View.VISIBLE);
          no_kta.setVisibility(View.GONE);
         no_str.setVisibility(View.GONE);
      } else if (position==5) {
//          no_str.setVisibility(View.VISIBLE);
//          //no_kta.setVisibility(View.VISIBLE);
          no_npm.setVisibility(View.VISIBLE);
          no_kta.setVisibility(View.GONE);
          no_str.setVisibility(View.GONE);

      }else {
           no_npm.setVisibility(View.GONE);
           no_kta.setVisibility(View.VISIBLE);
           no_str.setVisibility(View.VISIBLE);


      }

  }

  @Override
  public void onNothingSelected(AdapterView<?> arg0) {
   // TODO Auto-generated method stub

  }

 });
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        ArrayAdapter<String> jenis= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,organisasi);
        Ajenis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(jenis);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,
                                       long id) {
                // TODO Auto-generated method stub
                temporgan = organisasi[position];




        }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });



        spinner2 = (Spinner) findViewById(R.id.spinner2);


        ArrayAdapter<String> cbg= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cabang);
        Ajenis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(cbg);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,
                                       long id) {
                // TODO Auto-generated method stub
                tempcabang = cabang [position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });



////        if(tempcabang.isChecked=()){
//            no_str.setVisibility(View.VISIBLE);
//       //}
//       // else if(rb2.isChecked()){
//            no_kta.setVisibility(View.INVISIBLE);
//       // }















        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progressDialog = ProgressDialog.show(SignUp.this,"Loading.....",null,true,true);
                if (fullName.getText().toString().equals("") || email.getText().toString().equals("") || phoneNumber.getText().toString().equals("")
                        || password.getText().toString().equals("") || alamat_rumah.getText().toString().equals("")
                        || alamat_korespondensi.getText().toString().equals("")
                        || ttl.getText().toString().equals("")|| ttl.getText().toString().equals("")
                        || ktp.getText().toString().equals("") )  {
                    fullName.setFocusable(false);
                    email.setFocusable(false);
                    phoneNumber.setFocusable(false);
                    password.setFocusable(false);
                    ttl.setFocusable(false);
                    alamat_korespondensi.setFocusable(false);
                    alamat_rumah.setFocusable(false);
//                    no_npm.setFocusable(false);
//                    no_str.setFocusable(false);
//                    no_kta.setFocusable(false);
                    username.setFocusable(false);
                    ktp.setFocusable(false);

                    showSnackbar();
                } else {
                    register();
                }
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backSignin();
            }
        });


////
//        selectImg.setOnClickListener(new View.OnClickListener()
////
//        {
//            @Override
//            public void onClick (View v){
//
//                selectImage();
//
//            }
//        });
//
//
//        fotoktm.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick (View v){
//
//                selectKtm();
//
//            }
//        });
//        fotokta.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick (View v){
//
//                selectImage();
//
//            }
//        });
//        fotostr.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick (View v){
//
//                selectImage();
//
//            }
//        });
//
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        String itemm = parent.getItemAtPosition(position).toString();
        String itemmm = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//        Toast.makeText(parent.getContext(), "Selected: " + itemm, Toast.LENGTH_LONG).show();
//        Toast.makeText(parent.getContext(), "Selected: " + itemmm, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void showSnackbar() {
        // progressDialog.dismiss();
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Lengkapi data terlebih dahulu", Snackbar.LENGTH_INDEFINITE)
                .setAction("Ulangi", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Silahkan ulangi", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                        fullName.setFocusableInTouchMode(true);
                        email.setFocusableInTouchMode(true);
                        phoneNumber.setFocusableInTouchMode(true);
                        password.setFocusableInTouchMode(true);
                        alamat_korespondensi.setFocusableInTouchMode(true);
                        alamat_rumah.setFocusableInTouchMode(true);
                        ttl.setFocusableInTouchMode(true);
                        username.setFocusableInTouchMode(true);
//                        no_npm.setFocusableInTouchMode(true);
//                        no_kta.setFocusableInTouchMode(true);
//                        no_str.setFocusableInTouchMode(true);
                        ktp.setFocusableInTouchMode(true);


                    }
                });
        snackbar.show();
    }
    public void register() {
//progressDialog = ProgressDialog.show(SignUp.this,"Loading.....",null,true,true);
        String d_name = String.valueOf(fullName.getText());
        String d_mail = String.valueOf(email.getText());
        String d_phone = String.valueOf(phoneNumber.getText());
        String d_pass = String.valueOf(password.getText());
        final String d_username = String.valueOf(username.getText());
        final String d_addresshome = String.valueOf(alamat_rumah.getText());
        final String d_addresswork = String.valueOf(alamat_korespondensi.getText());
        String d_ktp = String.valueOf(ktp.getText());
        String d_str = String.valueOf(no_str.getText());
        String d_npm = String.valueOf(no_npm.getText());
        String d_ttl = String.valueOf(ttl.getText());
        String d_kta = String.valueOf(no_kta.getText());

        if (d_name.equals("")) {
            showSnackbar();
        } else if (d_mail.equals("")) {
            showSnackbar();
        } else if (d_phone.equals("")) {
            showSnackbar();
        } else if (d_pass.equals("")) {
            showSnackbar();
        } else if (d_username.equals("")) {
            showSnackbar();
        } else if (d_addresshome.equals("")) {
            showSnackbar();
        } else if (d_addresswork.equals("")) {
            showSnackbar();
//        } else if (d_kta.equals("")) {
//            showSnackbar();
//        } else if (d_npm.equals("")) {
//            showSnackbar();
//        } else if (d_str.equals("")) {
//            showSnackbar();
        } else if (d_ktp.equals("")) {
            showSnackbar();
        } else if (d_ttl.equals("")) {
            showSnackbar();
        } else if (tempJenis.equals("")) {
            showSnackbar();
        } else if (temporgan.equals("")) {
            showSnackbar();
        } else if (tempcabang.equals("")) {
            showSnackbar();


        } else {

            // Toast.makeText(SignUp.this,"Tombol sign up di tekan",Toast.LENGTH_LONG).show();
            retrofit2.Call<DefaultResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .createUser(d_username,d_pass,d_ktp,d_name,d_ttl,d_mail,d_phone,d_addresshome,d_addresswork,d_kta,d_str,d_npm,tempJenis,temporgan,tempcabang);

            call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                    DefaultResponse df = response.body();
                    //Toast.makeText(SignUp.this,df.getMsg(),Toast.LENGTH_LONG).show();
                    Toast.makeText(SignUp.this, "Register Berhasil", Toast.LENGTH_LONG).show();
                   // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    Toast.makeText(SignUp.this,t.toString(),Toast.LENGTH_LONG).show();
                   // Toast.makeText(SignUp.this, "Registrasi Gagal Ulangi Kembali", Toast.LENGTH_LONG).show();
                   // Toast.makeText(SignUp.this, "Register Berhasil" +tempcabang+temporgan+tempJenis+d_username+d_addresshome+d_addresswork, Toast.LENGTH_LONG).show();
                }
            });


            Intent sign = new Intent(this, SignIn.class);
            startActivity(sign);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    public void backSignin() {
        Intent sign = new Intent(this, SignIn.class);
        startActivity(sign);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

//    private void selectImage() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, IMAGE);
//    }
//
//    private String convertToString()
//    {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        byte[] imgByte = byteArrayOutputStream.toByteArray();
//        return Base64.encodeToString(imgByte,Base64.DEFAULT);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode== IMAGE && resultCode==RESULT_OK && data!=null)
//        {
//            Uri path = data.getData();
//
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//


}