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

public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    List<User> userList;
    TextView id,matricule,username,password;
    public UserAdapter(@NonNull Context context, List<User> userList) {
        super(context, R.layout.list_user,userList);
        this.context=context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, null, true);
        id = (TextView) view.findViewById(R.id.id);
        //matricule = (TextView) view.findViewById(R.id.date);
        username = (TextView) view.findViewById(R.id.username);
        //password = (TextView) view.findViewById(R.id.prf);

        id.setText(userList.get(position).getId());
        //matricule.setText(userList.get(position).getMatricule());
        username.setText(userList.get(position).getUsername());
        //password.setText(userList.get(position).getPassword());


        return view;
    }
}
