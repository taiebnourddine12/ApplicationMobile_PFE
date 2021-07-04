package com.example.EleoneTech;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SiteWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_web);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contacter");
    }


    public void map(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.1986745,9.956113?z=15")));
    }

    public void fb(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/OneTech-1024376197601824")));
    }

    public void wats(View view) {
        Intent phone = new Intent(Intent.ACTION_DIAL);
        phone.setData(Uri.parse("tel:72451045"));
        if (phone.resolveActivity(getPackageManager()) != null) {
            startActivity(phone);
        }
    }
}
