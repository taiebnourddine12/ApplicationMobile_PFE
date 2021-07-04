package com.example.EleoneTech;

import android.app.ProgressDialog;
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

public class CreateAccount extends AppCompatActivity {
    EditText ed_mat, ed_user, ed_pass;
    String str_mat, str_user, str_pass;
    RadioButton login, admin;
    ProgressDialog progressDialog;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getSupportActionBar().setTitle("Créer un Compte");

        ed_mat = findViewById(R.id.mat);
        ed_user = findViewById(R.id.user);
        ed_pass = findViewById(R.id.pass);
        login = (RadioButton) findViewById(R.id.login);
        admin = (RadioButton) findViewById(R.id.admin);
        progressDialog = new ProgressDialog(this);
    }

    public void Create(){
        progressDialog.show();
        final ProgressDialog finalProgressDialog = progressDialog;
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                finalProgressDialog.dismiss();
                Toast.makeText(CreateAccount.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(CreateAccount.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Matricule", str_mat);
                params.put("Username", str_user);
                params.put("Password", str_pass);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(CreateAccount.this);
        requestQueue.add(request);
    }

    public void Register(View view) {
        str_mat = ed_mat.getText().toString().trim();
        str_user = ed_user.getText().toString().trim();
        str_pass = ed_pass.getText().toString().trim();
        if (str_user.equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        } else if (str_pass.equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }else if (str_mat.equals("") || str_mat.length()<4) {
            Toast.makeText(this, "Enter Matricule", Toast.LENGTH_SHORT).show();
        } else {
            if(login.isChecked()){
                url=config.LOCALHOST_Account + "registerUser.php";
                Create();
            }
            if(admin.isChecked()){
                url=config.LOCALHOST_Account + "registerAdmin.php";
                Create();
            }
        }
        ed_mat.setText("");
        ed_user.setText("");
        ed_pass.setText("");
    }
}
