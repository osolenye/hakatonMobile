package com.example.hackathon1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class TendersActivity extends AppCompatActivity {
    String token = LoginActivity.staticToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenders);


        RequestQueue queue = Volley.newRequestQueue(TendersActivity.this);
        String url = "http://makarovv25.pythonanywhere.com/api/tenders/";


    }
}