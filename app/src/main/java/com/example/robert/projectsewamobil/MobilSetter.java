package com.example.robert.projectsewamobil;

/**
 * Created by Robert on 20/12/2017.
 */

public class MobilSetter {
    private String nama;
    private String gambar;

    public MobilSetter(){

    }

    public MobilSetter(String nama, String gambar) {
        this.nama = nama;

        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
