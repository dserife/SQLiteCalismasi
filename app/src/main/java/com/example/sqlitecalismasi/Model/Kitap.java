package com.example.sqlitecalismasi.Model;

public class Kitap {

    int id;
    String kitapAdi;
    String yazarAdi;

    public Kitap() {
    }

    public Kitap(String kitapAdi, String yazarAdi) {

        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }
}
