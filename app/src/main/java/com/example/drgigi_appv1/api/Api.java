package com.example.drgigi_appv1.api;


import com.example.drgigi_appv1.models.DefaultResponse;

import com.example.drgigi_appv1.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("users/register")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("nama_lengkap") String nama_lengkap,
            @Field("no_telp") String no_telp,
            @Field("alamat") String alamat,
            @Field("spesialis") String spesialis
    );
    @FormUrlEncoded
    @POST("users/api_login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

}
