package com.example.robert.projectsewamobil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.opengl.ETC1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {

    EditText namauser,alamat,password,notelp;
    Button join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        namauser = (EditText)findViewById(R.id.namauser);
        alamat = (EditText)findViewById(R.id.alamat);
        password = (EditText)findViewById(R.id.password);
        notelp = (EditText)findViewById(R.id.notelp);

        join = (Button)findViewById(R.id.join);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel_user = database.getReference("User");

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mdialog = new ProgressDialog(Signup.this);
                mdialog.setMessage("Harap Tunggu....");
                mdialog.show();

                tabel_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(notelp.getText().toString()).exists()){
                            mdialog.dismiss();
                            Toast.makeText(Signup.this, "Akun telah dipakai...", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mdialog.dismiss();
                            UserSetter user = new UserSetter(namauser.getText().toString(),
                                    password.getText().toString(),
                                    alamat.getText().toString(),
                                    notelp.getText().toString());
                            tabel_user.child(notelp.getText().toString()).setValue(user);
                            Toast.makeText(Signup.this, "Anda Sudah Terdaftar!!!", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent(Signup.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }

}
