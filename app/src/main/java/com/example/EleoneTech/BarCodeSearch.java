package com.example.EleoneTech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.Toast;

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

public class BarCodeSearch extends AppCompatActivity {
    ListView listView;
    EditText find;
    TableLayout table;
    ProgressDialog progressDialog;
    String data;
    String url = config.LOCALHOST + "searchQR.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Filtrage Par Produits");

        progressDialog = new ProgressDialog(this);
        find = (EditText) findViewById(R.id.search);
        table = (TableLayout) findViewById(R.id.table);
        listView = (ListView) findViewById(R.id.myList);
        Intent intent = getIntent();
        find.setText(intent.getStringExtra("str"));
    }

    public void find(View view) {
        table.setVisibility(View.VISIBLE);
        data = find.getText().toString().trim();
        GetMatchData();
    }

    public void GetMatchData() {
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(BarCodeSearch.this, "connect", Toast.LENGTH_LONG).show();
                        if (response.trim().equals("success")) {
                            showJSON(response);
                            progressDialog.dismiss();
                        } else {
                            showJSON(response);
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(BarCodeSearch.this, "Faild", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();

                map.put("SerialNumber", data);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(BarCodeSearch.this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++) {
                JSONObject o = result.getJSONObject(i);
                String counter = o.getString("Counter");
                String Numéro_de_série = o.getString("SerialNumber");
                String numéro_OF = o.getString("Work_Order");
                String Produit = o.getString("Part_Number");
                String station = o.getString("Station_ID");
                String ligne = o.getString("Line_ID");
                String process = o.getString("Process_Layer");
                String Date_de_production = o.getString("Dating");
                String numéro_de_série_flan = o.getString("Master_SN");
                String position_SN = o.getString("SerialNumber_Position");
                String Résultat = o.getString("Status");
                String Iot_PCB = o.getString("Setup_Name");
                String Matricule = o.getString("UserName");


                final HashMap<String, String> employees = new HashMap<>();
                employees.put("Counter", counter);
                employees.put("SerialNumber", Numéro_de_série);
                employees.put("Work_Order", numéro_OF);
                employees.put("Part_Number", Produit);
                employees.put("Station_ID", station);
                employees.put("Line_ID", ligne);
                employees.put("Process_Layer", process);
                employees.put("Dating", Date_de_production);
                employees.put("Master_SN", numéro_de_série_flan);
                employees.put("SerialNumber_Position", position_SN);
                employees.put("Status", Résultat);
                employees.put("Setup_Name", Iot_PCB);
                employees.put("UserName", Matricule);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                BarCodeSearch.this, list, R.layout.bar_items,
                new String[]{"SerialNumber", "Work_Order", "Part_Number", "Station_ID", "Dating", "Master_SN", "SerialNumber_Position", "Status", "Setup_Name", "UserName"},
                new int[]{R.id.n_serie, R.id.of, R.id.p, R.id.station, R.id.date_p, R.id.n_serie_flan, R.id.pos_SN, R.id.result, R.id.iot, R.id.matricule});
        listView.setAdapter(adapter);

    }

    public void scan(View view) {
        startActivity(new Intent(BarCodeSearch.this, BarCodeActivity.class));
    }


}
