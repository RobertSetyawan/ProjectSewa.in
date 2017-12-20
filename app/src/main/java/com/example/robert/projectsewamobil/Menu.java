package com.example.robert.projectsewamobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void lihat(View view) {
        Intent intent = new Intent(Menu.this, ListMobil.class);
        startActivity(intent);
    }

    public void lihatriwayat(View view) {
        Intent intent = new Intent(Menu.this,ListPinjam.class);
        startActivity(intent);
    }
}
