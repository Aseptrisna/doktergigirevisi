package com.example.drgigi_appv1.api;


import android.widget.Toast;

import com.example.drgigi_appv1.models.DefaultResponse;

import com.example.drgigi_appv1.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface Api {

    @FormUrlEncoded
    @POST("users/register_api")
    Call<DefaultResponse> createUser(
            @Field("username") String d_username,
            @Field("password") String d_pass,
            @Field("ktp") String d_ktp,
            @Field("nama_lengkap") String d_name,
            @Field("alamat_rumah") String d_addresshome,
            @Field("alamat_kerja") String d_addresswork,
            @Field("tempatlahir") String d_ttl,
            @Field("email") String d_mail,
            @Field("telp") String d_phone,
            @Field("no_kta") String no_kta,
            @Field("no_npm") String d_npm,
            @Field("no_str") String d_str,
            @Field("profesi") String tempjenis,
            @Field("organisasi") String temporgan,
            @Field("cabang") String tempcabang

    );
    @FormUrlEncoded
    @POST("users/api_login")
    Call<LoginResponse> userLogin(
            @Field("username") String email,
            @Field("password") String password
    );

}
