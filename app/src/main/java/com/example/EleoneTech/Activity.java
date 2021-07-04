package com.example.EleoneTech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Activity extends AppCompatActivity implements View.OnClickListener {
    private CardView consultation;
    private CardView searchProduct;
    private CardView webSite;
    private CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Les Activités des Utilisateurs");

        consultation = findViewById(R.id.consult);
        searchProduct = findViewById(R.id.qr);
        webSite = findViewById(R.id.webSite);
        logout = findViewById(R.id.logout);
        consultation.setOnClickListener(this);
        searchProduct.setOnClickListener(this);
        webSite.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.consult:
                Toast.makeText(this, "ConsultProduct Manager", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Activity.this, MainActivity.class));
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
                Activity.this.finish();
                System.exit(1);
                break;
        }

    }

}
