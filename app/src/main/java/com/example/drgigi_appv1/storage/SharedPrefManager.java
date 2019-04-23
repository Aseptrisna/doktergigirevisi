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
        editor.putString("no_telp" , user.getNo_telp());
        editor.putString("alamat_rumah" , user.getAlamat_rumah());
        editor.putString("profesi" , user.getProfesi());
        editor.putString("username" , user.getUsername());
        editor.putString("password" , user.getPassword());
        editor.putString("alamat_koresponden" , user.getAlamat_koresponden());
        editor.putString("no_npm" , user.getNo_npm());
        editor.putString("no_kta" , user.getNo_kta());
        editor.putString("no_ktp" , user.getNo_ktp());
        editor.putString("no_str" , user.getNo_str());
        editor.putString("organisasi" , user.getOrganisasi());
        editor.putString("cabang_organisasi" , user.getCabang_organisasi());
        editor.putString("tempatlahir" , user.getTempatlahir());


        editor.apply();

    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return sharedPreferences.getString("username", null) != null;

    }

    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(

                sharedPreferences.getString("email", null),
                sharedPreferences.getString("nama_lengkap",null),
                sharedPreferences.getString("alamat_koresponden", null),
                sharedPreferences.getString("profesi",null),
                sharedPreferences.getString("no_telp",null),
                sharedPreferences.getString("no_npm", null),
                sharedPreferences.getString("no_str",null),
                sharedPreferences.getString("username",null),
                sharedPreferences.getString("no_kta",null),
                sharedPreferences.getString("no_ktp", null),
                sharedPreferences.getString("tempatlahir", null),
                sharedPreferences.getString("organisasi",null),
                sharedPreferences.getString("cabang_organisasi",null),
                sharedPreferences.getString("password",null)
        );

    }

    public void clear(){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
