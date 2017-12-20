package com.example.robert.projectsewamobil;

/**
 * Created by Robert on 20/12/2017.
 */

public class PinjamSetter {
    private String nama;
    private String tanggalpinjam;
    private String mobil;

    public PinjamSetter(){

    }

    public PinjamSetter(String nama, String tanggalpinjam, String mobil) {
        this.nama = nama;
        this.tanggalpinjam = tanggalpinjam;
        this.mobil = mobil;
    }

    public String getNama() {
        return nama;
    }

    public String getMobil() {
        return mobil;
    }

    public String getTanggalpinjam() {
        return tanggalpinjam;
    }
}
