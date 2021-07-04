package com.example.EleoneTech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HostAdapter extends ArrayAdapter<TesterHost> {
    Context context;
    List<TesterHost> testerHost;

    public HostAdapter(@NonNull Context context, List<TesterHost> testerHost) {
        super(context, R.layout.hostspin,testerHost);
        this.context=context;
        this.testerHost=testerHost;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostspin, null, true);
        TextView station = (TextView) view.findViewById(R.id.station);
        station.setText(testerHost.get(position).getStation());

        return view;
    }

    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostspin, null, true);
        TextView station = (TextView) view.findViewById(R.id.station);
        station.setText(testerHost.get(position).getStation());

        return view;
    }


}
