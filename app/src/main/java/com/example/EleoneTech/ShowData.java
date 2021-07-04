package com.example.EleoneTech;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowData extends AppCompatActivity {

    TextView id, date, matricule, of, prf, poste,
            h1pass, h1faild, h1total, h1defaux, h1cadence,
            h2pass, h2faild, h2total, h2defaux, h2cadence,
            h3pass, h3faild, h3total, h3defaux, h3cadence,
            h4pass, h4faild, h4total, h4defaux, h4cadence,
            h5pass, h5faild, h5total, h5defaux, h5cadence,
            h6pass, h6faild, h6total, h6defaux, h6cadence,
            h7pass, h7faild, h7total, h7defaux, h7cadence,
            h8pass, h8faild, h8total, h8defaux, h8cadence,
            defaux, cadence, cadencethe, actualH;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        getSupportActionBar().setTitle("Suivie de Production");


        id = (TextView) findViewById(R.id.id);
        date = (TextView) findViewById(R.id.date);
        of = (TextView) findViewById(R.id.of);
        prf = (TextView) findViewById(R.id.prf);
        matricule = (TextView) findViewById(R.id.mat);
        poste = (TextView) findViewById(R.id.poste);
        defaux = (TextView) findViewById(R.id.defaux);
        cadence = (TextView) findViewById(R.id.cadence);
        cadencethe = (TextView) findViewById(R.id.cadencethe);

        h1pass = (TextView) findViewById(R.id.h1pass);
        h1faild = (TextView) findViewById(R.id.h1fail);
        h1total = (TextView) findViewById(R.id.h1total);
        h1defaux = (TextView) findViewById(R.id.h1defaux);
        h1cadence = (TextView) findViewById(R.id.h1cadence);

        h2pass = (TextView) findViewById(R.id.h2pass);
        h2faild = (TextView) findViewById(R.id.h2fail);
        h2total = (TextView) findViewById(R.id.h2total);
        h2defaux = (TextView) findViewById(R.id.h2defaux);
        h2cadence = (TextView) findViewById(R.id.h2cadence);

        h3pass = (TextView) findViewById(R.id.h3pass);
        h3faild = (TextView) findViewById(R.id.h3fail);
        h3total = (TextView) findViewById(R.id.h3total);
        h3defaux = (TextView) findViewById(R.id.h3defaux);
        h3cadence = (TextView) findViewById(R.id.h3cadence);

        h4pass = (TextView) findViewById(R.id.h4pass);
        h4faild = (TextView) findViewById(R.id.h4fail);
        h4total = (TextView) findViewById(R.id.h4total);
        h4defaux = (TextView) findViewById(R.id.h4defaux);
        h4cadence = (TextView) findViewById(R.id.h4cadence);

        h5pass = (TextView) findViewById(R.id.h5pass);
        h5faild = (TextView) findViewById(R.id.h5fail);
        h5total = (TextView) findViewById(R.id.h5total);
        h5defaux = (TextView) findViewById(R.id.h5defaux);
        h5cadence = (TextView) findViewById(R.id.h5cadence);

        h6pass = (TextView) findViewById(R.id.h6pass);
        h6faild = (TextView) findViewById(R.id.h6fail);
        h6total = (TextView) findViewById(R.id.h6total);
        h6defaux = (TextView) findViewById(R.id.h6defaux);
        h6cadence = (TextView) findViewById(R.id.h6cadence);

        h7pass = (TextView) findViewById(R.id.h7pass);
        h7faild = (TextView) findViewById(R.id.h7fail);
        h7total = (TextView) findViewById(R.id.h7total);
        h7defaux = (TextView) findViewById(R.id.h7defaux);
        h7cadence = (TextView) findViewById(R.id.h7cadence);

        h8pass = (TextView) findViewById(R.id.h8pass);
        h8faild = (TextView) findViewById(R.id.h8fail);
        h8total = (TextView) findViewById(R.id.h8total);
        h8defaux = (TextView) findViewById(R.id.h8defaux);
        h8cadence = (TextView) findViewById(R.id.h8cadence);
        actualH = (TextView) findViewById(R.id.actualH);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        id.setText(MainActivity.modelArrayList.get(position).getId());
        date.setText(MainActivity.modelArrayList.get(position).getDate());
        of.setText(MainActivity.modelArrayList.get(position).getOf());
        prf.setText(MainActivity.modelArrayList.get(position).getPrf());
        matricule.setText(MainActivity.modelArrayList.get(position).getMatricule());
        poste.setText(MainActivity.modelArrayList.get(position).getPoste());

        h1pass.setText(MainActivity.modelArrayList.get(position).getH1pass());
        h1faild.setText(MainActivity.modelArrayList.get(position).getH1fail());
        h1total.setText(MainActivity.modelArrayList.get(position).getH1total());
        h1defaux.setText(MainActivity.modelArrayList.get(position).getH1defaux());
        h1cadence.setText(MainActivity.modelArrayList.get(position).getH1cadence());

        h2pass.setText(MainActivity.modelArrayList.get(position).getH2pass());
        h2faild.setText(MainActivity.modelArrayList.get(position).getH2fail());
        h2total.setText(MainActivity.modelArrayList.get(position).getH2total());
        h2defaux.setText(MainActivity.modelArrayList.get(position).getH2defaux());
        h2cadence.setText(MainActivity.modelArrayList.get(position).getH2cadence());

        h3pass.setText(MainActivity.modelArrayList.get(position).getH3pass());
        h3faild.setText(MainActivity.modelArrayList.get(position).getH3fail());
        h3total.setText(MainActivity.modelArrayList.get(position).getH3total());
        h3defaux.setText(MainActivity.modelArrayList.get(position).getH3defaux());
        h3cadence.setText(MainActivity.modelArrayList.get(position).getH3cadence());

        h4pass.setText(MainActivity.modelArrayList.get(position).getH4pass());
        h4faild.setText(MainActivity.modelArrayList.get(position).getH4fail());
        h4total.setText(MainActivity.modelArrayList.get(position).getH4total());
        h4defaux.setText(MainActivity.modelArrayList.get(position).getH4defaux());
        h4cadence.setText(MainActivity.modelArrayList.get(position).getH4cadence());

        h5pass.setText(MainActivity.modelArrayList.get(position).getH5pass());
        h5faild.setText(MainActivity.modelArrayList.get(position).getH5fail());
        h5total.setText(MainActivity.modelArrayList.get(position).getH5total());
        h5defaux.setText(MainActivity.modelArrayList.get(position).getH5defaux());
        h5cadence.setText(MainActivity.modelArrayList.get(position).getH5cadence());

        h6pass.setText(MainActivity.modelArrayList.get(position).getH6pass());
        h6faild.setText(MainActivity.modelArrayList.get(position).getH6fail());
        h6total.setText(MainActivity.modelArrayList.get(position).getH6total());
        h6defaux.setText(MainActivity.modelArrayList.get(position).getH6defaux());
        h6cadence.setText(MainActivity.modelArrayList.get(position).getH6cadence());

        h7pass.setText(MainActivity.modelArrayList.get(position).getH7pass());
        h7faild.setText(MainActivity.modelArrayList.get(position).getH7fail());
        h7total.setText(MainActivity.modelArrayList.get(position).getH7total());
        h7defaux.setText(MainActivity.modelArrayList.get(position).getH7defaux());
        h7cadence.setText(MainActivity.modelArrayList.get(position).getH7cadence());

        h8pass.setText(MainActivity.modelArrayList.get(position).getH8pass());
        h8faild.setText(MainActivity.modelArrayList.get(position).getH8fail());
        h8total.setText(MainActivity.modelArrayList.get(position).getH8total());
        h8defaux.setText(MainActivity.modelArrayList.get(position).getH8defaux());
        h8cadence.setText(MainActivity.modelArrayList.get(position).getH8cadence());

        defaux.setText(MainActivity.modelArrayList.get(position).getDefaux());
        cadence.setText(MainActivity.modelArrayList.get(position).getCadence());
        cadencethe.setText(MainActivity.modelArrayList.get(position).getCadencethe());
        actualH.setText(MainActivity.modelArrayList.get(position).getActualH());

    }
}
