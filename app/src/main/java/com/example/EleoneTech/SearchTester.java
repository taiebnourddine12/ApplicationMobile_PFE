package com.example.EleoneTech;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
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
import java.util.Map;

public class SearchTester extends AppCompatActivity {
    String DD, DF, SID;
    static int pass_date, faild_date, count_date, pass_total, faild_total, count_total;
    EditText dateD, dateF;
    Button display;
    Spinner spinner;
    ArrayList<String> testerList = new ArrayList<>();
    ArrayAdapter<String> testerAdapter;
    private String url = config.LOCALHOST + "SelectTester.php";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tester);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Filtrage Par Testeurs");


        dateD = (EditText) findViewById(R.id.dateD);
        dateF = (EditText) findViewById(R.id.dateF);
        display = (Button) findViewById(R.id.display);
        spinner = (Spinner) findViewById(R.id.spinner);

        select();

        dateD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                                dateD.setText(simpleDateFormat.format(calendar.getTime()));
                            }
                        };

                        new TimePickerDialog(SearchTester.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
                    }
                };

                new DatePickerDialog(SearchTester.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dateF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                                dateF.setText(simpleDateFormat.format(calendar.getTime()));
                            }
                        };

                        new TimePickerDialog(SearchTester.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
                    }
                };

                new DatePickerDialog(SearchTester.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
    }

    public void select() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject o = jsonArray.getJSONObject(i);
                            String station = o.getString("Station_Name");
                            testerList.add(station);
                            testerAdapter = new ArrayAdapter<>(SearchTester.this, android.R.layout.simple_spinner_item, testerList);
                            testerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                            spinner.setAdapter(testerAdapter);

                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SearchTester.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(SearchTester.this);
        requestQueue.add(request);
    }

    public void GetMatchData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, config.LOCALHOST + "searchBetweenDate.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            showJSON(response);
                        } else {
                            showJSON(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchTester.this, "Faild", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Dating1", DD);
                map.put("Dating2", DF);
                map.put("Station_Name", SID);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(SearchTester.this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++) {
                JSONObject o = result.getJSONObject(i);
                //String Numéro_de_série = o.getString("SerialNumber");
                //String Station_Name = o.getString("Station_Name");
                //String station = o.getString("Station_ID");
                //String date = o.getString("Dating");
                String Résultat = o.getString("Status");

                if (Résultat.equals("1") || Résultat.equals("pass") || Résultat.equals("true"))
                    pass_date++;
                else
                    faild_date++;

                count_date++;
            }
            intent = new Intent(this, ChartActivity.class);
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void GetMatchData1() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, config.LOCALHOST + "totalPass.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            showJSON1(response);
                        } else {
                            showJSON1(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchTester.this, "Faild", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("Dating1", DD);
                map.put("Dating2", DF);
                map.put("Station_Name", SID);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(SearchTester.this);
        requestQueue.add(stringRequest);
    }

    public void showJSON1(String response) {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");

            for (int i = 0; i < result.length(); i++) {
                JSONObject o = result.getJSONObject(i);
                //String Numéro_de_série = o.getString("SerialNumber");
                //String Station_Name = o.getString("Station_Name");
                //String station = o.getString("Station_ID");
                //String date = o.getString("Dating");
                String Résultat = o.getString("Status");

                if (Résultat.equals("1") || Résultat.equals("pass") || Résultat.equals("true"))
                    pass_total++;
                else
                    faild_total++;

                count_total++;

            }
            intent = new Intent(this, ChartActivity.class);
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void display(View view) {
        SID = spinner.getSelectedItem().toString().trim();
        DD = dateD.getText().toString().trim();
        DF = dateF.getText().toString().trim();

        GetMatchData();
        GetMatchData1();

    }

    public void RAZ_dateF(View view) {
        dateF.setText("");
    }

    public void RAZ_dateD(View view) {
        dateD.setText("");
    }
}