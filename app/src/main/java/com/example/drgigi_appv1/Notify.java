package com.example.drgigi_appv1;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import org.w3c.dom.Text;
import java.util.logging.LogRecord;
public class Notify extends AppCompatActivity {
    RMQ rmq = new RMQ();

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



//        rmq.setupConnectionFactory();
//        subscribeNotification();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

//    private void subscribeNotification() {
//        final Handler incomingMessageHandler = new Handler() {
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//            @Override
//            public void handleMessage(Message msg) {
//                String title = "Seminar Baru";
//                String message = msg.getData().getString("msg");
//                Log.d("RMQMessage", message);
//
//                showNotification(title, message);
////                Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();
//            }
//        };
//
//        Thread subscribeThread = new Thread(); //ini gua coba iseng kak
//        rmq.subscribe(incomingMessageHandler,subscribeThread);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    public void showNotification(String title, String body) {
//        Context context = getApplicationContext();
//        Intent intent = getIntent();
//
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        int notificationId = 1;
//        String channelId = "channel-01";
//        String channelName = "Channel Name";
//        int importance = NotificationManager.IMPORTANCE_HIGH;
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel mChannel = new NotificationChannel(
//                    channelId, channelName, importance);
//            notificationManager.createNotificationChannel(mChannel);
//        }
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
//                .setSmallIcon(R.drawable.notify_ic)
//                .setContentTitle(title)
//                .setContentText(body);
//
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//        stackBuilder.addNextIntent(intent);
//        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
//                0,
//                PendingIntent.FLAG_UPDATE_CURRENT
//        );
//        mBuilder.setContentIntent(resultPendingIntent);
//
//        notificationManager.notify(notificationId, mBuilder.build());
//    }
}
