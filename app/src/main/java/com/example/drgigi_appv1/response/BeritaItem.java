package com.example.drgigi_appv1.response;

import com.google.gson.annotations.SerializedName;

public class BeritaItem{

    @SerializedName("tittle")
    private String penulis;

    @SerializedName("pamflet")
    private String foto;

    @SerializedName("id")
    private String id;

    @SerializedName("tgl_acara")
    private String judulBerita;

    @SerializedName("narasumber")
    private String tanggalPosting;

    @SerializedName("materi")
    private String isiBerita;

    public void setPenulis(String penulis){
        this.penulis = penulis;
    }

    public String getPenulis(){
        return penulis;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public String getFoto(){
        return foto;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setJudulBerita(String judulBerita){
        this.judulBerita = judulBerita;
    }

    public String getJudulBerita(){
        return judulBerita;
    }

    public void setTanggalPosting(String tanggalPosting){
        this.tanggalPosting = tanggalPosting;
    }

    public String getTanggalPosting(){
        return tanggalPosting;
    }

    public void setIsiBerita(String isiBerita){
        this.isiBerita = isiBerita;
    }

    public String getIsiBerita(){
        return isiBerita;
    }

    @Override
    public String toString(){
        return
                "BeritaItem{" +
                        "tittle = '" + penulis + '\'' +
                        ",pamflet= '" + foto + '\'' +
                        ",id = '" + id + '\'' +
                        ",tgl_acara = '" + judulBerita + '\'' +
                        ",narasumber = '" + tanggalPosting + '\'' +
                        ",materi = '" + isiBerita + '\'' +
                        "}";
    }
}