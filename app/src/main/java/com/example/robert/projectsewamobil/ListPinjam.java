package com.example.robert.projectsewamobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ListPinjam extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference listpinjam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pinjam);

        database = FirebaseDatabase.getInstance();
        listpinjam = database.getReference("Pinjam");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerpinjam);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //load data from firebase
        LoadMenu();

    }

    private void LoadMenu() {
        FirebaseRecyclerAdapter<PinjamSetter,PinjamHolder> adapter = new FirebaseRecyclerAdapter<PinjamSetter, PinjamHolder>(PinjamSetter.class,R.layout.itempinjam,PinjamHolder.class,listpinjam) {
            @Override
            protected void populateViewHolder(PinjamHolder viewHolder, PinjamSetter model, int position) {
                viewHolder.namauserpinjam.setText(model.getNama());
                viewHolder.tanggal.setText(model.getTanggalpinjam());
                viewHolder.jenismobil.setText(model.getMobil());

            }
        };
        recyclerView.setAdapter(adapter);
    }
}
