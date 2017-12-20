package com.example.robert.projectsewamobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ListMobil extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference listmobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mobil);

        database = FirebaseDatabase.getInstance();
        listmobil = database.getReference("Mobil");

        recyclerView = (RecyclerView)findViewById(R.id.recyclermobil);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //load data from firebase
        LoadMenu();

    }

    private void LoadMenu() {
        FirebaseRecyclerAdapter<MobilSetter,MobilHolder> adapter = new FirebaseRecyclerAdapter<MobilSetter, MobilHolder>(MobilSetter.class,R.layout.itemmobil,MobilHolder.class,listmobil) {
            @Override
            protected void populateViewHolder(MobilHolder viewHolder, MobilSetter model, int position) {
                viewHolder.namamobil.setText(model.getNama());
                Picasso.with(getBaseContext()).load(model.getGambar()).into(viewHolder.gambarmobil);
                final MobilSetter clickable = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View View, int posistion, boolean isLongClick) {
                        Toast.makeText(ListMobil.this, ""+clickable.getNama(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
