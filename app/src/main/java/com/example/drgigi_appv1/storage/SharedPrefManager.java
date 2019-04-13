package com.example.drgigi_appv1.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.drgigi_appv1.models.User;
public class SharedPrefManager {

    public static final String SHARED_PREF_NAME = "my_shared_pref";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx){
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx){
        if (mInstance == null){
            mInstance = new SharedPrefManager(mCtx);
        }

        return mInstance;
    }

    public void saveUser(User user){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email" , user.getEmail());
        editor.putString("nama_lengkap" , user.getNama_lengkap());
        editor.putString("no-telp" , user.getNo_telp());
        editor.putString("alamat" , user.getAlamat());
        editor.putString("spesialis" , user.getSpesialis());

        editor.apply();

    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString("email", null) != null;

    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(

                sharedPreferences.getString("email", null),
                sharedPreferences.getString("nama_lengkap", null),
                sharedPreferences.getString("no_telp",null),
                sharedPreferences.getString("alamat",null),
                sharedPreferences.getString("spesialis",null)
        );
    }

    public void clear(){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
