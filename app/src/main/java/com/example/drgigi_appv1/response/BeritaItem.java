package com.example.drgigi_appv1.response;

import com.google.gson.annotations.SerializedName;

public class BeritaItem {

    @SerializedName("tittle")
    private String title;

    @SerializedName("pamflet")
    private String pamlet;

    @SerializedName("id")
    private String id;

    @SerializedName("tgl_acara")
    private String tgl_acara;

    @SerializedName("narasumber")
    private String narasumber;

    @SerializedName("value")
    private String value;

    @SerializedName("materi")
    private String materi;


    @SerializedName("kouta")
    private String kouta;

    @SerializedName("kecamatan")
    private String kecamatan;

    @SerializedName("kota")
    private String kota;

    @SerializedName("biaya")
    private String biaya;


    @SerializedName("lokasi")
    private String lokasi;

    @SerializedName("cp")
    private String cp;


    @SerializedName("email")
    private String email;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPamlet(String pamlet) {
        this.pamlet = pamlet;
    }

    public String getPamlet() {
        return pamlet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTgl_acara(String tgl_acara) {
        this.tgl_acara = tgl_acara;
    }

    public String getTgl_acara() {
        return tgl_acara;

    }

    public void setNarasumber(String narasumber) {
        this.narasumber = narasumber;
    }

    public String getNarasumber() {
        return narasumber;
    }

    public void setMateri(String materi) {
        this.materi = materi;

    }

    public String getMateri() {
        return materi;
    }


    public void setKouta(String kouta) {
        this.kouta = kouta;

    }

    public String getKouta() {
        return kouta;
    }


    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKota(String kota) {
        this.kota = kota;

    }

    public String getKota() {
        return kota;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;

    }

    public String getBiaya() {
        return biaya;
    }


    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;

    }

    public String getLokasi() {
        return lokasi;
    }




    public void setCp(String cp) {
        this.cp = cp;

    }

    public String getCp() {
        return cp;
    }



    public void setEmail(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }



    public void setValue(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return
                "BeritaItem{" +
                        "tittle = '" + title + '\'' +
                        ",pamflet= '" + pamlet + '\'' +
                        ",id = '" + id + '\'' +
                        ",tgl_acara = '" + tgl_acara + '\'' +
//                        ",narasumber = '" + narasumber + '\'' +
                        ",materi = '" + materi + '\'' +
                        ",kouta = '" + kouta + '\'' +
                        ",kecamatan = '" + kecamatan + '\'' +
                        ",kota = '" + kota + '\'' +
                        ",biaya = '" + biaya + '\'' +
                        ",lokasi = '" + lokasi+ '\'' +
                        ",cp = '" + cp+ '\'' +
                        ",email = '" + email+ '\'' +
                        ",value = '" + value+ '\'' +
                        "}";
    }
}