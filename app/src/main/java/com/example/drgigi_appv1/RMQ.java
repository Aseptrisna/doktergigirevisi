package com.example.drgigi_appv1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Log;

import com.rabbitmq.client.*;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class RMQ {

    // Load Global Configuration
    Settings settings = new Settings();

    // Setup RMQ Configuration (Ganti dengan setting akun RMQ nya)
    String user = "dettacare_event";
    String pass = "dettacare_event";
    String host = "167.205.7.226";
    String vhost = "/dettacare_event";
    String exchanges_name = "amq.topic";
    String queue_name_publish = "dettacare_event";
    String queue_name_subscribe = "dettacare_event";
    String routingKey = "dettacare_event";

    // Define new Connection Factory
    ConnectionFactory factory = new ConnectionFactory();

    /**
     * Setup Connection Factory
     * Load Setting Connection RMQ Sebagai Parameter Koneksi
     */
    public void setupConnectionFactory() {
        try {
            factory.setAutomaticRecoveryEnabled(false);
            factory.setUri("amqp://"+user+":"+pass+"@"+host);
            factory.setVirtualHost(vhost);
        } catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Publish data lewat RMQ
     * @param message
     */
    public void publish(String message) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String messageOn = message ;
            channel.basicPublish("", queue_name_publish,null,messageOn.getBytes());

        } catch (IOException e) {
            Log.d("Publish Error", e.getMessage());
        } catch (TimeoutException e) {
            Log.d("Publish Error", e.getMessage());
        } catch (Exception e) {
            Log.d("Publish Error", e.getMessage());
        }

    }

    /**
     * Optional, Send Speed for threading speed
     * @throws InterruptedException
     */
    public void SendSpeed() throws InterruptedException {
        Thread.sleep(500); //0.5 sec
    }

    /**
     * Fungsi untuk subscribe data RMQ
     * @param handler
     * @param subscribeThread
     */
    public void subscribe(final Handler handler, Thread subscribeThread)
    {
        subscribeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Connection connection = factory.newConnection();
                        Channel channel = connection.createChannel();
                        channel.basicQos(0);
                        channel.queueBind(queue_name_subscribe, exchanges_name, routingKey);
                        QueueingConsumer consumer = new QueueingConsumer(channel);
                        channel.basicConsume(queue_name_subscribe, true, consumer);
                        QueueingConsumer.Delivery delivery = consumer.nextDelivery();

                        if (delivery != null){

                            try{

                                String message = null;
                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                                    message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                                }
                                Log.d("ConsumeDataRMQ", "MessageConsumed" + message);

                                Message msg = handler.obtainMessage();
                                Bundle bundle = new Bundle();

                                bundle.putString("msg", message);
                                msg.setData(bundle);
                                handler.sendMessage(msg);

                                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

                            }catch (Exception e){
                                channel.basicReject(delivery.getEnvelope().getDeliveryTag(),true);
                            }
                        }
                    } catch (InterruptedException e) {
                        break;
                    } catch (Exception e1) {
                        Log.d("", "Connection broken: " + e1.getClass().getName());
                        try {
                            Thread.sleep(4000); //sleep and then try again
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        });
        subscribeThread.start();
    }
}