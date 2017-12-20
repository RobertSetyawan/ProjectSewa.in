package com.example.robert.projectsewamobil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText inputname;
    private EditText inputpass;
    private TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login);
        inputname = (EditText)findViewById(R.id.namelogin);
        inputpass = (EditText)findViewById(R.id.passlogin);
        signup = (TextView)findViewById(R.id.signup);

        //minta akses firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tabel_user = database.getReference("User");

        //tombol login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //pesan harap tunggu
                final ProgressDialog mdialog = new ProgressDialog(MainActivity.this);
                mdialog.setMessage("Harap Tunggu....");
                mdialog.show();

                tabel_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //cek apakah user ada atau tidak pada DB
                        if (dataSnapshot.child(inputname.getText().toString()).exists()) {
                            mdialog.dismiss();
                            //Login dengan menggunakan nama
                            UserSetter user = dataSnapshot.child(inputname.getText().toString()).getValue(UserSetter.class);
                            if (user.getPassword().equals(inputpass.getText().toString())) {
                                Toast.makeText(MainActivity.this, "SignIn Success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Menu.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "SignIn Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else {
                            mdialog.dismiss();
                            Toast.makeText(MainActivity.this, "User Tidak Terdaftar...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }

}
