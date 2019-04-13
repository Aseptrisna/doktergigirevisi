package com.example.drgigi_appv1.network;

import com.example.drgigi_appv1.response.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    //@TIPEMETHOD("API_END_POINT")
    @GET("event/get_event_api")
    Call<ResponseBerita> request_show_all_berita();
    // <ModelData> nama_method()



}
