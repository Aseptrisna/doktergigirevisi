package com.example.drgigi_appv1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SpashScreen extends AppCompatActivity {

    Animation uptodown, downtoup;
    ImageView up;
    TextView up1;

    private static int splashInterval = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spash_screen);

        up = (ImageView) findViewById(R.id.one);
        up1 = (TextView) findViewById(R.id.ss);

        uptodown = AnimationUtils.loadAnimation(this, R.anim.to_left);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.to_right);

        up.setAnimation(downtoup);
        up1.setAnimation(downtoup);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SpashScreen.this, SignIn.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
                this.finish();
            }

            private void finish() {

            }
        }, splashInterval);


    }

}