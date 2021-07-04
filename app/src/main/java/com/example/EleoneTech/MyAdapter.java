package com.example.EleoneTech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Model> {
    Context context;
    List<Model> modelArrayList;
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

    public MyAdapter(@NonNull Context context, ArrayList<Model> modelArrayList) {
        super(context, R.layout.serlist, modelArrayList);
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.serlist, null, true);
        id = (TextView) view.findViewById(R.id.id);
        date = (TextView) view.findViewById(R.id.date);
        of = (TextView) view.findViewById(R.id.of);
        prf = (TextView) view.findViewById(R.id.prf);
        matricule = (TextView) view.findViewById(R.id.matricule);

        poste = (TextView) view.findViewById(R.id.poste);
        defaux = (TextView) view.findViewById(R.id.defaux);
        cadence = (TextView) view.findViewById(R.id.cadence);
        cadencethe = (TextView) view.findViewById(R.id.cadencethe);

        h1pass = (TextView) view.findViewById(R.id.h1pass);
        h1faild = (TextView) view.findViewById(R.id.h1fail);
        h1total = (TextView) view.findViewById(R.id.h1total);
        h1defaux = (TextView) view.findViewById(R.id.h1defaux);
        h1cadence = (TextView) view.findViewById(R.id.h1cadence);

        h2pass = (TextView) view.findViewById(R.id.h2pass);
        h2faild = (TextView) view.findViewById(R.id.h2fail);
        h2total = (TextView) view.findViewById(R.id.h2total);
        h2defaux = (TextView) view.findViewById(R.id.h2defaux);
        h2cadence = (TextView) view.findViewById(R.id.h2cadence);

        h3pass = (TextView) view.findViewById(R.id.h3pass);
        h3faild = (TextView) view.findViewById(R.id.h3fail);
        h3total = (TextView) view.findViewById(R.id.h3total);
        h3defaux = (TextView) view.findViewById(R.id.h3defaux);
        h3cadence = (TextView) view.findViewById(R.id.h3cadence);

        h4pass = (TextView) view.findViewById(R.id.h4pass);
        h4faild = (TextView) view.findViewById(R.id.h4fail);
        h4total = (TextView) view.findViewById(R.id.h4total);
        h4defaux = (TextView) view.findViewById(R.id.h4defaux);
        h4cadence = (TextView) view.findViewById(R.id.h4cadence);

        h5pass = (TextView) view.findViewById(R.id.h5pass);
        h5faild = (TextView) view.findViewById(R.id.h5fail);
        h5total = (TextView) view.findViewById(R.id.h5total);
        h5defaux = (TextView) view.findViewById(R.id.h5defaux);
        h5cadence = (TextView) view.findViewById(R.id.h5cadence);

        h6pass = (TextView) view.findViewById(R.id.h6pass);
        h6faild = (TextView) view.findViewById(R.id.h6fail);
        h6total = (TextView) view.findViewById(R.id.h6total);
        h6defaux = (TextView) view.findViewById(R.id.h6defaux);
        h6cadence = (TextView) view.findViewById(R.id.h6cadence);

        h7pass = (TextView) view.findViewById(R.id.h7pass);
        h7faild = (TextView) view.findViewById(R.id.h7fail);
        h7total = (TextView) view.findViewById(R.id.h7total);
        h7defaux = (TextView) view.findViewById(R.id.h7defaux);
        h7cadence = (TextView) view.findViewById(R.id.h7cadence);

        h8pass = (TextView) view.findViewById(R.id.h8pass);
        h8faild = (TextView) view.findViewById(R.id.h8fail);
        h8total = (TextView) view.findViewById(R.id.h8total);
        h8defaux = (TextView) view.findViewById(R.id.h8defaux);
        h8cadence = (TextView) view.findViewById(R.id.h8cadence);

        actualH = (TextView) view.findViewById(R.id.actualH);

        id.setText(modelArrayList.get(position).getId());
        date.setText(modelArrayList.get(position).getDate());
        of.setText(modelArrayList.get(position).getOf());
        prf.setText(modelArrayList.get(position).getPrf());
        matricule.setText(modelArrayList.get(position).getMatricule());
        poste.setText(modelArrayList.get(position).getPoste());

        h1pass.setText(modelArrayList.get(position).getH1pass());
        h1faild.setText(modelArrayList.get(position).getH1fail());
        h1total.setText(modelArrayList.get(position).getH1total());
        h1defaux.setText(modelArrayList.get(position).getH1defaux());
        h1cadence.setText(modelArrayList.get(position).getH1cadence());

        h2pass.setText(modelArrayList.get(position).getH2pass());
        h2faild.setText(modelArrayList.get(position).getH2fail());
        h2total.setText(modelArrayList.get(position).getH2total());
        h2defaux.setText(modelArrayList.get(position).getH2defaux());
        h2cadence.setText(modelArrayList.get(position).getH2cadence());

        h3pass.setText(modelArrayList.get(position).getH3pass());
        h3faild.setText(modelArrayList.get(position).getH3fail());
        h3total.setText(modelArrayList.get(position).getH3total());
        h3defaux.setText(modelArrayList.get(position).getH3defaux());
        h3cadence.setText(modelArrayList.get(position).getH3cadence());

        h4pass.setText(modelArrayList.get(position).getH4pass());
        h4faild.setText(modelArrayList.get(position).getH4fail());
        h4total.setText(modelArrayList.get(position).getH4total());
        h4defaux.setText(modelArrayList.get(position).getH4defaux());
        h4cadence.setText(modelArrayList.get(position).getH4cadence());

        h5pass.setText(modelArrayList.get(position).getH5pass());
        h5faild.setText(modelArrayList.get(position).getH5fail());
        h5total.setText(modelArrayList.get(position).getH5total());
        h5defaux.setText(modelArrayList.get(position).getH5defaux());
        h5cadence.setText(modelArrayList.get(position).getH5cadence());

        h6pass.setText(modelArrayList.get(position).getH6pass());
        h6faild.setText(modelArrayList.get(position).getH6fail());
        h6total.setText(modelArrayList.get(position).getH6total());
        h6defaux.setText(modelArrayList.get(position).getH6defaux());
        h6cadence.setText(modelArrayList.get(position).getH6cadence());

        h7pass.setText(modelArrayList.get(position).getH7pass());
        h7faild.setText(modelArrayList.get(position).getH7fail());
        h7total.setText(modelArrayList.get(position).getH7total());
        h7defaux.setText(modelArrayList.get(position).getH7defaux());
        h7cadence.setText(modelArrayList.get(position).getH7cadence());

        h8pass.setText(modelArrayList.get(position).getH8pass());
        h8faild.setText(modelArrayList.get(position).getH8fail());
        h8total.setText(modelArrayList.get(position).getH8total());
        h8defaux.setText(modelArrayList.get(position).getH8defaux());
        h8cadence.setText(modelArrayList.get(position).getH8cadence());

        defaux.setText(modelArrayList.get(position).getDefaux());
        cadence.setText(modelArrayList.get(position).getCadence());
        cadencethe.setText(modelArrayList.get(position).getCadencethe());
        actualH.setText(modelArrayList.get(position).getActualH());

        return view;
    }


}
