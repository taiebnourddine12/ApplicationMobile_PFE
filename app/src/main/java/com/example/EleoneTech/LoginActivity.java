package com.example.EleoneTech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText ed_user, ed_pass;
    String str_user, str_pass;
    RadioButton login, admin;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        ed_user = findViewById(R.id.user);
        ed_pass = findViewById(R.id.pass);
        login = (RadioButton) findViewById(R.id.login);
        admin = (RadioButton) findViewById(R.id.admin);
    }

    public void GetMatchDataUser() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                if (response.equals("logged in successfully")) {

                    startActivity(new Intent(LoginActivity.this, Activity.class));
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Username", str_user);
                params.put("Password", str_pass);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(request);
    }
    public void GetMatchDataAdmin() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                if (response.equals("logged in successfully")) {

                    startActivity(new Intent(LoginActivity.this, ActivityAdmin.class));
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Username", str_user);
                params.put("Password", str_pass);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(request);
    }


    public void Login(View view) {
        str_user = ed_user.getText().toString().trim();
        str_pass = ed_pass.getText().toString().trim();
        if (str_user.equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        } else if (str_pass.equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        } else {
            if(login.isChecked()){
                url=config.LOCALHOST_Account + "login.php";
                GetMatchDataUser();
            }
            if(admin.isChecked()){
                url=config.LOCALHOST_Account + "admin.php";
                GetMatchDataAdmin();
            }
        }
        ed_user.setText("");
        ed_pass.setText("");
    }


}


