//package com.example.hackathon1;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MainActivity extends AppCompatActivity {
//    private Button btn_registrate;
//    private EditText et_name, et_password, et_password2;
//    private TextView tv_result;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btn_registrate = findViewById(R.id.btn_registrate);
//        et_name = findViewById(R.id.et_name);
//        et_password = findViewById(R.id.et_password);
//        et_password2 = findViewById(R.id.et_password2);
//        tv_result = findViewById(R.id.tv_result);
//
//
//        btn_registrate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (et_name.getText().toString().isEmpty() || et_password.getText().toString().isEmpty()) {
//                    Toast.makeText(MainActivity.this, "заполните оба поля!", Toast.LENGTH_SHORT).show();
//                }
//                if (!(et_password.getText().toString().equals(et_password2.getText().toString()))) {
//                    Toast.makeText(MainActivity.this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
//                }
//                postDataToWebSite(et_name.getText().toString(), et_password.getText().toString(), et_password2.getText().toString());
//            }
//        });
//    }
//
//            private void postDataToWebSite(String name, String password, String password2) {
//                String url = "http://makarovv25.pythonanywhere.com/api/register/";
//
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//
//                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        et_name.setText("");
//                        et_password.setText("");
//                        et_password2.setText("");
//
//                        Toast.makeText(MainActivity.this, "Вы зарегистрировались на сайте", Toast.LENGTH_SHORT).show();
//
//                        try {
//                            JSONObject respObj = new JSONObject(response);
//
//                            String name = respObj.getString("username");
//                            String password = respObj.getString("password");
//                            String password2 = respObj.getString("password2");
//
//
//                            tv_result.setText("Имя: " + name);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Не получилось зарегистрироваться. Попробуйте еще раз позже.", Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//                    @Override
//                    protected Map<String, String> getParams() {
//                        Map<String, String> params = new HashMap<String, String>();
//
//                        params.put("username", name);
//                        params.put("password", password);
//                        params.put("password2", password2);
//                        return params;
//
//                    }
//                };
//
//        queue.add(request);
//    }
//}

package com.example.hackathon1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;
    private RequestQueue requestQueue;
    private String url = "http://makarovv25.pythonanywhere.com/api/register/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.et_name);
        passwordEditText = findViewById(R.id.et_password);
        confirmPasswordEditText = findViewById(R.id.et_password2);
        registerButton = findViewById(R.id.btn_registrate);
        requestQueue = Volley.newRequestQueue(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        final String username = usernameEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        final String confirmPassword = confirmPasswordEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Создаем JSON-объект с данными для отправки
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("username", username);
            jsonBody.put("password", password);
            jsonBody.put("password2", confirmPassword);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Создаем запрос на сервер
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Обработка успешного ответа от сервера
                        Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        // Здесь можно добавить дополнительные действия после успешной регистрации
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Обработка ошибки
                        Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        Log.e("RegistrationActivity", "Registration Error: " + error.getMessage());
                    }
                });

        // Добавляем запрос в очередь
        requestQueue.add(jsonObjectRequest);
    }
}




