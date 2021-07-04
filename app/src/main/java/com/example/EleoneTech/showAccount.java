package com.example.EleoneTech;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.EleoneTech.ListAccountActivity.userList;

public class showAccount extends AppCompatActivity {

    int position;
    TextView id,matricule,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_account);
        getSupportActionBar().setTitle("Profil de Compte");

        id = (TextView) findViewById(R.id.id);
        matricule = (TextView) findViewById(R.id.mat);
        username = (TextView) findViewById(R.id.user);
        password = (TextView) findViewById(R.id.pass);


        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");

        id.setText(userList.get(position).getId());
        matricule.setText(userList.get(position).getMatricule());
        username.setText(userList.get(position).getUsername());
        password.setText(userList.get(position).getPassword());


        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });


    }
}
