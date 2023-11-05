//package com.example.hackathon1;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TendersActivity extends AppCompatActivity {
//    String token = LoginActivity.staticToken;
//    RecyclerView rv_tenders;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tenders);
//        rv_tenders = findViewById(R.id.rv_tenders);
//        List<Item> items = new ArrayList<Item>();
//
//
//        RequestQueue queue = Volley.newRequestQueue(TendersActivity.this);
//        String url = "http://makarovv25.pythonanywhere.com/api/tenders/";
//
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray results = response.getJSONArray("results"); // Получаем первый элемент массива
//
//                    for (int i = 0; i < results.length() - 1; i++) {
//                        JSONObject jsonObject = results.getJSONObject(i);
//
//                        Item tender = new Item();
//                        tender.setId(jsonObject.getInt("id"));
//                        tender.setTenderNum(jsonObject.getLong("tenderNum"));
//                        tender.setTenderName(jsonObject.getString("tenderName"));
//                        tender.setTenderFormat(jsonObject.getString("tenderFormat"));
//                        tender.setTenderSumm(jsonObject.getInt("tenderSumm"));
//                        tender.setSrok(jsonObject.getInt("srok"));
//                        tender.setOrganizationName(jsonObject.getString("organizationName"));
//                        tender.setOrganizationPhone(jsonObject.getString("organizationPhone"));
//                        tender.setOrganizationAddress(jsonObject.getString("organizationAddress"));
//                        tender.setDateTimeStart(jsonObject.getString("dateTimeStart"));
//                        tender.setDateTimeEnd(jsonObject.getString("dateTimeEnd"));
//                        tender.setLetterFile(jsonObject.getString("letterFile"));
//                        tender.setLetterName(jsonObject.getString("letterName"));
//                        tender.setLotsInfo(jsonObject.getString("lotsInfo"));
//                        tender.setMoreInfo(jsonObject.getString("moreInfo"));
//                        tender.setLikes(jsonObject.getInt("likes"));
//                        tender.setDislikes(jsonObject.getInt("dislikes"));
//                        tender.setCompany_info(jsonObject.get("company_info"));
//
//                        items.add(tender);
//                        rv_tenders.setLayoutManager(new LinearLayoutManager(TendersActivity.this));
//                        rv_tenders.setAdapter(new MyAdapter(getApplicationContext(),items));
//                    }
//                    JSONObject firstCompanyId = results.getJSONObject(0); // Получаем "id" первой компании
//                    int id = firstCompanyId.getInt("id");
//                    String stringId = id + "";
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(TendersActivity.this, "ошибка", Toast.LENGTH_SHORT).show();
//            }
//        }
//        );
//        queue.add(request);
//    }
//}

package com.example.hackathon1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TendersActivity extends AppCompatActivity {
    String token = LoginActivity.staticToken;
    RecyclerView rv_tenders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenders);
        rv_tenders = findViewById(R.id.rv_tenders);
        List<Item> items = new ArrayList<Item>();

        RequestQueue queue = Volley.newRequestQueue(TendersActivity.this);
        String url = "http://makarovv25.pythonanywhere.com/api/tenders/";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Zдесь разберите JSON-ответ и заполните список items данными из JSON
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Item tender = new Item();

                        tender.setId(jsonObject.getInt("id"));
                        tender.setTenderNum(jsonObject.getLong("tenderNum"));
                        tender.setTenderName(jsonObject.getString("tenderName"));
                        tender.setTenderFormat(jsonObject.getString("tenderFormat"));
                        tender.setTenderSumm(jsonObject.getInt("tenderSumm"));
                        tender.setSrok(jsonObject.getInt("srok"));
                        tender.setOrganizationName(jsonObject.getString("organizationName"));
                        tender.setOrganizationPhone(jsonObject.getString("organizationPhone"));
                        tender.setOrganizationAddress(jsonObject.getString("organizationAddress"));
                        tender.setDateTimeStart(jsonObject.getString("dateTimeStart"));
                        tender.setDateTimeEnd(jsonObject.getString("dateTimeEnd"));
                        tender.setLetterFile(jsonObject.getString("letterFile"));
                        tender.setLetterName(jsonObject.getString("letterName"));
                        tender.setLotsInfo(jsonObject.getString("lotsInfo"));
                        tender.setMoreInfo(jsonObject.getString("moreInfo"));
                        tender.setLikes(jsonObject.getInt("likes"));
                        tender.setDislikes(jsonObject.getInt("dislikes"));
                        tender.setCompany_info(jsonObject.get("company_info"));

                        items.add(tender);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                rv_tenders.setLayoutManager(new LinearLayoutManager(TendersActivity.this));
                rv_tenders.setAdapter(new MyAdapter((getApplicationContext()), items));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Обработка ошибки, например, вывод сообщения об ошибке
            }
        });

        queue.add(request);
    }
}
