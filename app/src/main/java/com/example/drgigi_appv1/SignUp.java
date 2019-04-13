package com.example.drgigi_appv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.drgigi_appv1.api.RetrofitClient;
import com.example.drgigi_appv1.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private EditText fullName, email, phoneNumber, addrs, special, passwd;
    LinearLayout one, two;
    Animation uptodown, downtoup;
    Button up, in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_up);

        fullName = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        phoneNumber = findViewById(R.id.phone);
        addrs = findViewById(R.id.alamat);
        special = findViewById(R.id.spesialis);
        passwd = findViewById(R.id.password);

        coordinatorLayout = findViewById(R.id.MySignUp);
        in = (Button)findViewById(R.id.signin);
        up = (Button)findViewById(R.id.signup);
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        one.setAnimation(uptodown);
        two.setAnimation(downtoup);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fullName.getText().toString().equals("") || email.getText().toString().equals("") || phoneNumber.getText().toString().equals("") || passwd.getText().toString().equals("") || special.getText().toString().equals("") || addrs.getText().toString().equals("")) {
                    fullName.setFocusable(false);
                    email.setFocusable(false);
                    phoneNumber.setFocusable(false);
                    passwd.setFocusable(false);
                    special.setFocusable(false);
                    addrs.setFocusable(false);
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
    }

    public void showSnackbar() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Lengkapi data terlebih dahulu", Snackbar.LENGTH_INDEFINITE)
                .setAction("Ulangi", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Silahkan ulangi", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                        fullName.setFocusableInTouchMode(true);
                       email.setFocusableInTouchMode(true);
                        phoneNumber.setFocusableInTouchMode(true);
                        passwd.setFocusableInTouchMode(true);
                        special.setFocusableInTouchMode(true);
                        addrs.setFocusableInTouchMode(true);
                    }
                });
        snackbar.show();
    }

    public void register(){
        String d_name = String.valueOf(fullName.getText());
        String d_mail = String.valueOf(email.getText());
        String d_phone = String.valueOf(phoneNumber.getText());
        String d_pass = String.valueOf(passwd.getText());
        String d_spesialis = String.valueOf(special.getText());
        String d_address = String.valueOf(addrs.getText());

        if (d_name.equals("")) {
            showSnackbar();
        } else if (d_mail.equals("")) {
            showSnackbar();
        } else if (d_phone.equals("")) {
            showSnackbar();
        } else if (d_pass.equals("")) {
            showSnackbar();
        } else if (d_spesialis.equals("")) {
            showSnackbar();
        } else if (d_address.equals("")) {
            showSnackbar();
        } else {

        // Toast.makeText(SignUp.this,"Tombol sign up di tekan",Toast.LENGTH_LONG).show();
            retrofit2.Call<DefaultResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .createUser(d_mail,d_pass,d_name,d_phone,d_address,d_spesialis);

            call.enqueue(new Callback<DefaultResponse>() {
                @Override
                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                   DefaultResponse df = response.body();
                    Toast.makeText(SignUp.this,df.getMsg(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    Toast.makeText(SignUp.this,t.toString(),Toast.LENGTH_LONG).show();
                }
            });
            Intent sign = new Intent(this, SignIn.class);
            startActivity(sign);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    public void backSignin(){
        Intent sign = new Intent(this, SignIn.class);
        startActivity(sign);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }





}
