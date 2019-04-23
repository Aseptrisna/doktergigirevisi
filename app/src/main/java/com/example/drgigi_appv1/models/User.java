package com.example.drgigi_appv1.models;

public class User {

    private String username,password,email,nama_lengkap,no_telp,alamat_rumah,alamat_koresponden,profesi,no_kta,
            no_npm,tempatlahir,no_ktp,no_str,organisasi,cabang_organisasi;

    public User(String username, String password, String email, String nama_lengkap, String no_telp, String alamat_rumah,
                String alamat_koresponden, String profesi, String no_kta,
                String no_npm, String tempatlahir, String no_ktp, String no_str, String organisasi) {

        this.email = email;
        this.nama_lengkap = nama_lengkap;
        this.no_telp=no_telp;
        this.alamat_rumah=alamat_rumah;
        this.profesi=profesi;
        this.password =password;
        this.alamat_koresponden = alamat_koresponden;
        this.no_npm=no_npm;
        this.no_kta=no_kta;
        this.no_str = no_str;
        this.tempatlahir= tempatlahir;
        this.no_ktp=no_ktp;
        this.organisasi=organisasi;
        this.username = username;
        this.cabang_organisasi = cabang_organisasi;

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

    public String getAlamat_rumah() {
        return alamat_rumah;
    }

    public String getProfesi() {
        return profesi;
    }

    public String getNo_kta() {
        return no_kta;
    }

    public String getAlamat_koresponden() {
        return alamat_koresponden;
    }

    public String getUsername() {
        return username;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public String getOrganisasi() {
        return organisasi;
    }


    public String getNo_ktp() {
        return no_ktp;
    }

    public String getCabang_organisasi() {
        return cabang_organisasi;
    }

    public String getNo_npm() {
        return no_npm;
    }

    public String getPassword() {
        return password;
    }

    public String getNo_str() {
        return no_str;
    }


}
