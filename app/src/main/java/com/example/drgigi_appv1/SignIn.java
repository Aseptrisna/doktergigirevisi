package com.example.drgigi_appv1;

import android.app.ProgressDialog;
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
import com.example.drgigi_appv1.models.LoginResponse;
import com.example.drgigi_appv1.storage.SharedPrefManager;

import retrofit2.Callback;
import retrofit2.Response;
public class SignIn extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private EditText phone, passwd;
    LinearLayout one, two;
    Animation uptodown, downtoup;
    Button in, up;
    ProgressDialog progressDialog;

    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{
//            Toast.makeText(SignIn.this,"Dettacare-Event",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_in);

        coordinatorLayout = findViewById(R.id.MySignIn);
        phone = findViewById(R.id.mail);
        passwd = findViewById(R.id.password);

        in = (Button)findViewById(R.id.login);
        up = (Button)findViewById(R.id.signup);
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        one.setAnimation(uptodown);
        two.setAnimation(downtoup);

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.getText().toString().equals("") || passwd.getText().toString().equals("")) {
                    phone.setFocusable(false);
                    passwd.setFocusable(false);
                    showSnackbar();
                } else {
                    signIn();
                }
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void signIn(){
        progressDialog = ProgressDialog.show(SignIn.this,"Loading.....",null,true,true);
        String user = String.valueOf(phone.getText());
        String pas = String.valueOf(passwd.getText());
        if (user.equals("")) {
            showSnackbar();
        } else if (pas.equals("")) {
            showSnackbar();
        } else {
          // Intent sign = new Intent(this, MainActivity.class);
            //startActivity(sign);
            //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            //finish();
            retrofit2.Call<LoginResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .userLogin(user,pas);

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(retrofit2.Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();

                    if (!loginResponse.isError()){
                        //save user and open profile
                        SharedPrefManager.getInstance(SignIn.this)
                                .saveUser(loginResponse
                                        .getUser());

                        Intent intent = new Intent(SignIn.this,MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);


                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignIn.this, "Login Gagal", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<LoginResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(SignIn.this, "Login gagal", Toast.LENGTH_LONG).show();
                }
            });




        }
    }

    public void register(){
        Intent sign = new Intent(this, SignUp.class);
        startActivity(sign);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void showSnackbar() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Lengkapi data terlebih dahulu", Snackbar.LENGTH_INDEFINITE)
                .setAction("Ulangi", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Silahkan ulangi", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                        phone.setFocusableInTouchMode(true);
                        passwd.setFocusableInTouchMode(true);
                    }
                });
        snackbar.show();
    }
}
