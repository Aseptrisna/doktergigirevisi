package com.example.drgigi_appv1.models;

public class User {

    private String email,nama_lengkap,no_telp,alamat,spesialis;

    public User(String email, String nama_lengkap,String no_telp,String alamat,String spesialis) {
        this.email = email;
        this.nama_lengkap = nama_lengkap;
        this.no_telp=no_telp;
        this.alamat=alamat;
        this.spesialis=spesialis;
    }


    public String getEmail() {
        return email;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getSpesialis() {
        return spesialis;
    }
}
