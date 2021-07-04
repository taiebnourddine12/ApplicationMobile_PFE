package com.example.EleoneTech;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListAccountActivity extends AppCompatActivity {

    ListView listView;
    UserAdapter adapter;
    User user;
    String url, urlDel;
    ProgressDialog progressDialog;
    RadioButton users, admin;
    public static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Liste des Comptes");

        listView = (ListView) findViewById(R.id.userList);
        users = (RadioButton) findViewById(R.id.login);
        admin = (RadioButton) findViewById(R.id.admin);
        adapter = new UserAdapter(this, userList);
        listView.setAdapter(adapter);
        progressDialog = new ProgressDialog(this);

        itemClick();
    }


    public void itemClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                CharSequence[] dialogItem = {"View Account", "Delete Account"};
                builder.setTitle(userList.get(position).getUsername());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {
                            case 0:
                                startActivity(new Intent(getApplicationContext(), showAccount.class)
                                        .putExtra("position", position));
                                break;

                            case 1:
                                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListAccountActivity.this);
                                alertDialog.setTitle("Delete Account");
                                alertDialog.setMessage("Do you want delete this Account !?");
                                alertDialog.setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Write your code here to execute after dialog
                                                if (users.isChecked()) {
                                                    urlDel = config.LOCALHOST_Account + "deleteUser.php";
                                                    deleteData(userList.get(position).getId());
                                                }
                                                if (admin.isChecked()) {
                                                    urlDel = config.LOCALHOST_Account + "deleteAdmin.php";
                                                    deleteData(userList.get(position).getId());
                                                }
                                            }
                                        });
                                alertDialog.setNegativeButton("No",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                alertDialog.show();

                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, urlDel,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.hide();
                        progressDialog.dismiss();
                        Toast.makeText(ListAccountActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListAccountActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("ID", id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void select() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                userList.clear();
                progressDialog.dismiss();
                try {
                    progressDialog.hide();
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject o = jsonArray.getJSONObject(i);
                            String ID = o.getString("ID");
                            String Matricule = o.getString("Matricule");
                            String Username = o.getString("Username");
                            String Password = o.getString("Password");

                            user = new User(ID, Matricule, Username, Password);
                            userList.add(user);

                            adapter.notifyDataSetChanged();
                            listView.setAdapter(adapter);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(ListAccountActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(ListAccountActivity.this);
        requestQueue.add(request);

    }

    public void add(View view) {

        startActivity(new Intent(ListAccountActivity.this, CreateAccount.class));
    }


    public void show(View view) {
        userList.clear();
        listView.setVisibility(View.INVISIBLE);
        if (admin.isChecked()) {
            listView.setVisibility(View.INVISIBLE);
            url = config.LOCALHOST_Account + "selectAdmin.php";
            select();
            listView.setVisibility(View.VISIBLE);
        }
        if (users.isChecked()) {
            listView.setVisibility(View.INVISIBLE);
            url = config.LOCALHOST_Account + "selectUser.php";
            select();
            listView.setVisibility(View.VISIBLE);
        }
    }
}
