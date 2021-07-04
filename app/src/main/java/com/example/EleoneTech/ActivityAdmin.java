package com.example.EleoneTech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ActivityAdmin extends AppCompatActivity implements View.OnClickListener {
    private CardView manager;
    private CardView consultation;
    private CardView searchTester;
    private CardView searchProduct;
    private CardView webSite;
    private CardView logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Les Activités des Administrateurs");

        manager = findViewById(R.id.manager);
        consultation = findViewById(R.id.consult);
        searchTester = findViewById(R.id.tester);
        searchProduct = findViewById(R.id.qr);
        webSite = findViewById(R.id.webSite);
        logout = findViewById(R.id.logout);
        manager.setOnClickListener(this);
        consultation.setOnClickListener(this);
        searchTester.setOnClickListener(this);
        searchProduct.setOnClickListener(this);
        webSite.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.manager:
                Toast.makeText(this, "Account Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ActivityAdmin.this, ListAccountActivity.class));
                break;

            case R.id.consult:
                Toast.makeText(this, "ConsultProduct Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ActivityAdmin.this, MainActivity.class));
                break;

            case R.id.qr:
                Toast.makeText(this, "SearchProduct Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, BarCodeActivity.class));
                break;

            case R.id.tester:
                Toast.makeText(this, "SearchTester Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SearchTester.class));
                break;

            case R.id.webSite:
                Toast.makeText(this, "WebSites Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SiteWeb.class));
                break;

            case R.id.logout:
                Toast.makeText(this, "logout Manager", Toast.LENGTH_SHORT).show();
                ActivityAdmin.this.finish();
                System.exit(1);
                break;
        }

    }

}
