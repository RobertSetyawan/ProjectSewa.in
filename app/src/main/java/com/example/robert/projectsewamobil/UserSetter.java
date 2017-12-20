package com.example.robert.projectsewamobil;

/**
 * Created by Robert on 19/12/2017.
 */

public class UserSetter {
    private String nama;
    private String password;
    private String email;
    private String alamat;

    public UserSetter(){

    }

    public UserSetter(String name, String password,String email, String alamat) {
        this.nama = name;
        this.password = password;
        this.email = email;
        this.alamat = alamat;
    }

    public String getName() {
        return nama;
    }

    public void setName(String name) {
        this.nama = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

