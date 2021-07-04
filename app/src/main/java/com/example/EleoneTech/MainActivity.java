package com.example.EleoneTech;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText date, matricule, of, prf;
    String str_date, str_mat, str_of, str_prf, str_poste, searchURL, selectURL;
    static String host;
    ListView listView, listViewProd;
    TableLayout table, tableProd;
    Spinner spinner, poste;
    ProgressDialog progressDialog;
    RadioButton dash, prod;

    TesterHost testerHost;
    Model model;

    MyAdapter adapter;
    MyAdapterProd adapterProd;
    HostAdapter hostAdapter;

    public static ArrayList<Model> modelArrayList = new ArrayList<>();
    public static ArrayList<TesterHost> list = new ArrayList<>();
    private String testerURL = config.LOCALHOST + "SelectTester.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Consultation Produits");

        date = (EditText) findViewById(R.id.date);
        matricule = (EditText) findViewById(R.id.matricule);
        of = (EditText) findViewById(R.id.of);
        prf = (EditText) findViewById(R.id.prf);
        poste = (Spinner) findViewById(R.id.poste);
        spinner = (Spinner) findViewById(R.id.spinner);
        table = (TableLayout) findViewById(R.id.table);
        tableProd = (TableLayout) findViewById(R.id.tableprod);
        dash = (RadioButton) findViewById(R.id.dash);
        prod = (RadioButton) findViewById(R.id.prod);
        progressDialog = new ProgressDialog(this);
        listView = (ListView) findViewById(R.id.myList);
        listViewProd = (ListView) findViewById(R.id.myListProd);
        adapter = new MyAdapter(this, modelArrayList);
        adapterProd = new MyAdapterProd(this, modelArrayList);
        hostAdapter = new HostAdapter(this, list);
        listView.setAdapter(adapter);
        listViewProd.setAdapter(adapterProd);
        spinner.setAdapter(hostAdapter);


        final String[] postes = new String[]{
                "-- Poste --", "Poste 1", "Poste 2", "Poste 3"
        };

        ArrayAdapter<String> adapterPoste = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, postes);
        adapterPoste.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        poste.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        poste.setAdapter(adapterPoste);

        poste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("-- Poste --"))
                    postes[0] = "";
                else
                    postes[0] = "-- Poste --";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        showHostIp();


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        date.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new DatePickerDialog(MainActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    public void showHostIp() {
        hostAdapter = new HostAdapter(getApplicationContext(), list);
        StringRequest request = new StringRequest(Request.Method.POST, testerURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                list.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject o = jsonArray.getJSONObject(i);
                            String station = o.getString("Station_Name");
                            String ip = o.getString("Station_IP");
                            testerHost = new TesterHost(station, ip);
                            list.add(testerHost);
                            Spinner(list);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    public void Spinner(final List<TesterHost> list) {
        if (list.size() > 0) {
            spinner.setAdapter(hostAdapter);
            hostAdapter.notifyDataSetChanged();
            hostAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    table.setVisibility(View.INVISIBLE);
                    tableProd.setVisibility(View.INVISIBLE);
                    TesterHost testerHost = list.get(position);
                    host = testerHost.getIP();
                    Toast.makeText(MainActivity.this, host, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void itemClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                startActivity(new Intent(getApplicationContext(), ShowData.class)
                        .putExtra("position", position));
            }
        });
        listViewProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                startActivity(new Intent(getApplicationContext(), ShowData.class)
                        .putExtra("position", position));
            }
        });
    }

    public void selectProd() {

        adapterProd = new MyAdapterProd(getApplicationContext(), modelArrayList);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, selectURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                modelArrayList.clear();
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
                            String Date = o.getString("Date");
                            String poste = o.getString("Poste");

                            String h1pass = o.getString("H1 Pass");
                            String h1fail = o.getString("H1 Fail");
                            String h1total = o.getString("H1 Total");
                            String h1defaux = o.getString("H1 Taux de Defaux");
                            String h1cadence = o.getString("H1 Cadence");

                            String h2pass = o.getString("H2 Pass");
                            String h2fail = o.getString("H2 Fail");
                            String h2total = o.getString("H2 Total");
                            String h2defaux = o.getString("H2 Taux de Defaux");
                            String h2cadence = o.getString("H2 Cadence");

                            String h3pass = o.getString("H3 Pass");
                            String h3fail = o.getString("H3 Fail");
                            String h3total = o.getString("H3 Total");
                            String h3defaux = o.getString("H3 Taux de Defaux");
                            String h3cadence = o.getString("H3 Cadence");

                            String h4pass = o.getString("H4 Pass");
                            String h4fail = o.getString("H4 Fail");
                            String h4total = o.getString("H4 Total");
                            String h4defaux = o.getString("H4 Taux de Defaux");
                            String h4cadence = o.getString("H4 Cadence");

                            String h5pass = o.getString("H5 Pass");
                            String h5fail = o.getString("H5 Fail");
                            String h5total = o.getString("H5 Total");
                            String h5defaux = o.getString("H5 Taux de Defaux");
                            String h5cadence = o.getString("H5 Cadence");

                            String h6pass = o.getString("H6 Pass");
                            String h6fail = o.getString("H6 Fail");
                            String h6total = o.getString("H6 Total");
                            String h6defaux = o.getString("H6 Taux de Defaux");
                            String h6cadence = o.getString("H6 Cadence");

                            String h7pass = o.getString("H7 Pass");
                            String h7fail = o.getString("H7 Fail");
                            String h7total = o.getString("H7 Total");
                            String h7defaux = o.getString("H7 Taux de Defaux");
                            String h7cadence = o.getString("H7 Cadence");

                            String h8pass = o.getString("H8 Pass");
                            String h8fail = o.getString("H8 Fail");
                            String h8total = o.getString("H8 Total");
                            String h8defaux = o.getString("H8 Taux de Defaux");
                            String h8cadence = o.getString("H8 Cadence");

                            String defaux = o.getString("Taux de Defaux Total");
                            String cadence = o.getString("Cadence Total");
                            String cadencethe = o.getString("Cadence Théorique");

                            String ActualH = o.getString("Actual H");

                            model = new Model(ID, Date, poste,
                                    h1pass, h1fail, h1total, h1defaux, h1cadence,
                                    h2pass, h2fail, h2total, h2defaux, h2cadence,
                                    h3pass, h3fail, h3total, h3defaux, h3cadence,
                                    h4pass, h4fail, h4total, h4defaux, h4cadence,
                                    h5pass, h5fail, h5total, h5defaux, h5cadence,
                                    h6pass, h6fail, h6total, h6defaux, h6cadence,
                                    h7pass, h7fail, h7total, h7defaux, h7cadence,
                                    h8pass, h8fail, h8total, h8defaux, h8cadence,
                                    defaux, cadence, cadencethe, ActualH);
                            modelArrayList.add(model);

                            adapterProd.notifyDataSetChanged();
                            listViewProd.setAdapter(adapterProd);

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
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void showJSONProd(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject o = result.getJSONObject(i);
                String ID = o.getString("ID");
                String Date = o.getString("Date");
                String poste = o.getString("Poste");

                String h1pass = o.getString("H1 Pass");
                String h1fail = o.getString("H1 Fail");
                String h1total = o.getString("H1 Total");
                String h1defaux = o.getString("H1 Taux de Defaux");
                String h1cadence = o.getString("H1 Cadence");

                String h2pass = o.getString("H2 Pass");
                String h2fail = o.getString("H2 Fail");
                String h2total = o.getString("H2 Total");
                String h2defaux = o.getString("H2 Taux de Defaux");
                String h2cadence = o.getString("H2 Cadence");

                String h3pass = o.getString("H3 Pass");
                String h3fail = o.getString("H3 Fail");
                String h3total = o.getString("H3 Total");
                String h3defaux = o.getString("H3 Taux de Defaux");
                String h3cadence = o.getString("H3 Cadence");

                String h4pass = o.getString("H4 Pass");
                String h4fail = o.getString("H4 Fail");
                String h4total = o.getString("H4 Total");
                String h4defaux = o.getString("H4 Taux de Defaux");
                String h4cadence = o.getString("H4 Cadence");

                String h5pass = o.getString("H5 Pass");
                String h5fail = o.getString("H5 Fail");
                String h5total = o.getString("H5 Total");
                String h5defaux = o.getString("H5 Taux de Defaux");
                String h5cadence = o.getString("H5 Cadence");

                String h6pass = o.getString("H6 Pass");
                String h6fail = o.getString("H6 Fail");
                String h6total = o.getString("H6 Total");
                String h6defaux = o.getString("H6 Taux de Defaux");
                String h6cadence = o.getString("H6 Cadence");

                String h7pass = o.getString("H7 Pass");
                String h7fail = o.getString("H7 Fail");
                String h7total = o.getString("H7 Total");
                String h7defaux = o.getString("H7 Taux de Defaux");
                String h7cadence = o.getString("H7 Cadence");

                String h8pass = o.getString("H8 Pass");
                String h8fail = o.getString("H8 Fail");
                String h8total = o.getString("H8 Total");
                String h8defaux = o.getString("H8 Taux de Defaux");
                String h8cadence = o.getString("H8 Cadence");

                String defaux = o.getString("Taux de Defaux Total");
                String cadence = o.getString("Cadence Total");
                String cadencethe = o.getString("Cadence Théorique");

                String ActualH = o.getString("Actual H");

                model = new Model(ID, Date, poste,
                        h1pass, h1fail, h1total, h1defaux, h1cadence,
                        h2pass, h2fail, h2total, h2defaux, h2cadence,
                        h3pass, h3fail, h3total, h3defaux, h3cadence,
                        h4pass, h4fail, h4total, h4defaux, h4cadence,
                        h5pass, h5fail, h5total, h5defaux, h5cadence,
                        h6pass, h6fail, h6total, h6defaux, h6cadence,
                        h7pass, h7fail, h7total, h7defaux, h7cadence,
                        h8pass, h8fail, h8total, h8defaux, h8cadence,
                        defaux, cadence, cadencethe, ActualH);
                modelArrayList.add(model);
                adapterProd.notifyDataSetChanged();
                listViewProd.setAdapter(adapterProd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void GetMatchDataProd() {
        str_date = date.getText().toString().trim();
        str_poste = (String) poste.getSelectedItem();
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, searchURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            showJSONProd(response);
                            progressDialog.dismiss();
                        } else {
                            showJSONProd(response);
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Faild", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Date", str_date);
                map.put("Poste", str_poste);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }

    public void select() {

        adapter = new MyAdapter(getApplicationContext(), modelArrayList);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, selectURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                modelArrayList.clear();
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
                            String Date = o.getString("Date");
                            String OF = o.getString("OF");
                            String PRF = o.getString("PRF");
                            String Matricule = o.getString("Matricule");
                            String poste = o.getString("Poste");

                            String h1pass = o.getString("H1 Pass");
                            String h1fail = o.getString("H1 Fail");
                            String h1total = o.getString("H1 Total");
                            String h1defaux = o.getString("H1 Taux de Defaux");
                            String h1cadence = o.getString("H1 Cadence");

                            String h2pass = o.getString("H2 Pass");
                            String h2fail = o.getString("H2 Fail");
                            String h2total = o.getString("H2 Total");
                            String h2defaux = o.getString("H2 Taux de Defaux");
                            String h2cadence = o.getString("H2 Cadence");

                            String h3pass = o.getString("H3 Pass");
                            String h3fail = o.getString("H3 Fail");
                            String h3total = o.getString("H3 Total");
                            String h3defaux = o.getString("H3 Taux de Defaux");
                            String h3cadence = o.getString("H3 Cadence");

                            String h4pass = o.getString("H4 Pass");
                            String h4fail = o.getString("H4 Fail");
                            String h4total = o.getString("H4 Total");
                            String h4defaux = o.getString("H4 Taux de Defaux");
                            String h4cadence = o.getString("H4 Cadence");

                            String h5pass = o.getString("H5 Pass");
                            String h5fail = o.getString("H5 Fail");
                            String h5total = o.getString("H5 Total");
                            String h5defaux = o.getString("H5 Taux de Defaux");
                            String h5cadence = o.getString("H5 Cadence");

                            String h6pass = o.getString("H6 Pass");
                            String h6fail = o.getString("H6 Fail");
                            String h6total = o.getString("H6 Total");
                            String h6defaux = o.getString("H6 Taux de Defaux");
                            String h6cadence = o.getString("H6 Cadence");

                            String h7pass = o.getString("H7 Pass");
                            String h7fail = o.getString("H7 Fail");
                            String h7total = o.getString("H7 Total");
                            String h7defaux = o.getString("H7 Taux de Defaux");
                            String h7cadence = o.getString("H7 Cadence");

                            String h8pass = o.getString("H8 Pass");
                            String h8fail = o.getString("H8 Fail");
                            String h8total = o.getString("H8 Total");
                            String h8defaux = o.getString("H8 Taux de Defaux");
                            String h8cadence = o.getString("H8 Cadence");

                            String defaux = o.getString("Taux de Defaux Total");
                            String cadence = o.getString("Cadence Total");
                            String cadencethe = o.getString("Cadence Théorique");

                            String ActualH = o.getString("Actual H");


                            model = new Model(ID, Date, OF, PRF, Matricule, poste,
                                    h1pass, h1fail, h1total, h1defaux, h1cadence,
                                    h2pass, h2fail, h2total, h2defaux, h2cadence,
                                    h3pass, h3fail, h3total, h3defaux, h3cadence,
                                    h4pass, h4fail, h4total, h4defaux, h4cadence,
                                    h5pass, h5fail, h5total, h5defaux, h5cadence,
                                    h6pass, h6fail, h6total, h6defaux, h6cadence,
                                    h7pass, h7fail, h7total, h7defaux, h7cadence,
                                    h8pass, h8fail, h8total, h8defaux, h8cadence,
                                    defaux, cadence, cadencethe, ActualH);
                            modelArrayList.add(model);

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
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject o = result.getJSONObject(i);
                String ID = o.getString("ID");
                String Date = o.getString("Date");
                String OF = o.getString("OF");
                String PRF = o.getString("PRF");
                String Matricule = o.getString("Matricule");
                String poste = o.getString("Poste");

                String h1pass = o.getString("H1 Pass");
                String h1fail = o.getString("H1 Fail");
                String h1total = o.getString("H1 Total");
                String h1defaux = o.getString("H1 Taux de Defaux");
                String h1cadence = o.getString("H1 Cadence");

                String h2pass = o.getString("H2 Pass");
                String h2fail = o.getString("H2 Fail");
                String h2total = o.getString("H2 Total");
                String h2defaux = o.getString("H2 Taux de Defaux");
                String h2cadence = o.getString("H2 Cadence");

                String h3pass = o.getString("H3 Pass");
                String h3fail = o.getString("H3 Fail");
                String h3total = o.getString("H3 Total");
                String h3defaux = o.getString("H3 Taux de Defaux");
                String h3cadence = o.getString("H3 Cadence");

                String h4pass = o.getString("H4 Pass");
                String h4fail = o.getString("H4 Fail");
                String h4total = o.getString("H4 Total");
                String h4defaux = o.getString("H4 Taux de Defaux");
                String h4cadence = o.getString("H4 Cadence");

                String h5pass = o.getString("H5 Pass");
                String h5fail = o.getString("H5 Fail");
                String h5total = o.getString("H5 Total");
                String h5defaux = o.getString("H5 Taux de Defaux");
                String h5cadence = o.getString("H5 Cadence");

                String h6pass = o.getString("H6 Pass");
                String h6fail = o.getString("H6 Fail");
                String h6total = o.getString("H6 Total");
                String h6defaux = o.getString("H6 Taux de Defaux");
                String h6cadence = o.getString("H6 Cadence");

                String h7pass = o.getString("H7 Pass");
                String h7fail = o.getString("H7 Fail");
                String h7total = o.getString("H7 Total");
                String h7defaux = o.getString("H7 Taux de Defaux");
                String h7cadence = o.getString("H7 Cadence");

                String h8pass = o.getString("H8 Pass");
                String h8fail = o.getString("H8 Fail");
                String h8total = o.getString("H8 Total");
                String h8defaux = o.getString("H8 Taux de Defaux");
                String h8cadence = o.getString("H8 Cadence");

                String defaux = o.getString("Taux de Defaux Total");
                String cadence = o.getString("Cadence Total");
                String cadencethe = o.getString("Cadence Théorique");

                String ActualH = o.getString("Actual H");


                model = new Model(ID, Date, OF, PRF, Matricule, poste,
                        h1pass, h1fail, h1total, h1defaux, h1cadence,
                        h2pass, h2fail, h2total, h2defaux, h2cadence,
                        h3pass, h3fail, h3total, h3defaux, h3cadence,
                        h4pass, h4fail, h4total, h4defaux, h4cadence,
                        h5pass, h5fail, h5total, h5defaux, h5cadence,
                        h6pass, h6fail, h6total, h6defaux, h6cadence,
                        h7pass, h7fail, h7total, h7defaux, h7cadence,
                        h8pass, h8fail, h8total, h8defaux, h8cadence,
                        defaux, cadence, cadencethe, ActualH);
                modelArrayList.add(model);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void GetMatchData() {
        str_date = date.getText().toString().trim();
        str_mat = matricule.getText().toString().trim();
        str_of = of.getText().toString().trim();
        str_prf = prf.getText().toString().trim();
        str_poste = (String) poste.getSelectedItem();

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, searchURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                        Toast.makeText(MainActivity.this, "Faild", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Date", str_date);
                map.put("Poste", str_poste);
                map.put("OF", str_of);
                map.put("PRF", str_prf);
                map.put("Matricule", str_mat);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }

    public void Ok(View view) {
        modelArrayList.clear();
        tableProd.setVisibility(View.INVISIBLE);
        table.setVisibility(View.VISIBLE);
        str_date = date.getText().toString().trim();
        str_mat = matricule.getText().toString().trim();
        str_of = of.getText().toString().trim();
        str_prf = prf.getText().toString().trim();
        str_poste = (String) poste.getSelectedItem();

        if (dash.isChecked()) {
            searchURL = "http://" + host + "/Tester/search.php";
            selectURL = "http://" + host + "/Tester/select.php";
            //searchURL = "http://b38ffe0252f4.ngrok.io/Tester/search.php";
            //selectURL = "http://b38ffe0252f4.ngrok.io/Tester/select.php";

            if (!str_date.equals("") && str_mat.equals("") && str_of.equals("") && str_prf.equals("")) {
                GetMatchData();
                itemClick();
            }

            if (!str_mat.equals("") && str_date.equals("") && str_of.equals("") && str_prf.equals("") && str_poste.equals("")) {
                GetMatchData();
                itemClick();
            }
            if (!str_of.equals("") && str_date.equals("") && str_mat.equals("") && str_prf.equals("") && str_poste.equals("")) {
                GetMatchData();
                itemClick();
            }
            if (!str_prf.equals("") && str_date.equals("") && str_of.equals("") && str_mat.equals("") && str_poste.equals("")) {
                GetMatchData();
                itemClick();
            }
            if (!str_poste.equals("") && str_prf.equals("") && str_date.equals("") && str_of.equals("") && str_mat.equals("")) {
                GetMatchData();
                itemClick();
            }
            if (str_mat.equals("") && str_date.equals("") && str_of.equals("") && str_prf.equals("") && str_poste.equals("")) {
                select();
                itemClick();
            }
        }

        if (prod.isChecked()) {
            table.setVisibility(View.INVISIBLE);
            tableProd.setVisibility(View.VISIBLE);
            searchURL = "http://" + host + "/Tester/searchPROD.php";
            selectURL = "http://" + host + "/Tester/selectPROD.php";
            //searchURL = "http://b38ffe0252f4.ngrok.io/Tester/searchPROD.php";
            //selectURL = "http://b38ffe0252f4.ngrok.io/Tester/selectPROD.php";

            if (!str_date.equals("") && str_mat.equals("") && str_of.equals("") && str_prf.equals("") && str_poste.equals("")) {
                GetMatchDataProd();
                itemClick();
            } else if (!str_poste.equals("") && str_date.equals("") && str_mat.equals("") && str_of.equals("") && str_prf.equals("")) {
                GetMatchDataProd();
                itemClick();
            } else {
                selectProd();
                itemClick();
            }
        }
    }

    public void dash(View view) {
        if (dash.isChecked()) {
            date.setEnabled(true);
            matricule.setEnabled(true);
            of.setEnabled(true);
            prf.setEnabled(true);
        }
    }

    public void prod(View view) {
        if (prod.isChecked()) {
            date.setEnabled(true);
            matricule.setEnabled(false);
            of.setEnabled(false);
            prf.setEnabled(false);
        }
    }


    public void RAZ_date(View view) {
        date.setText("");
    }

    public void RAZ_matricule(View view) {
        matricule.setText("");
    }

    public void RAZ_of(View view) {
        of.setText("");
    }

    public void RAZ_prf(View view) {
        prf.setText("");
    }
}