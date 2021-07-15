package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_username, et_password, et_email;
    private Button btn_register;
    private String url = "http://10.0.2.2:8080/api/register";

    public void register(String userName, String password, String email, String salt) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response : " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error ! " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", userName);
                params.put("password", password);
                params.put("email", email);
                params.put("salt", salt);
                return params;
            }
        };

        stringRequest.setShouldCache(false);
        AppHelper.requestQueue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_email = findViewById(R.id.et_email);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String userName = et_username.getText().toString();
                String password = et_password.getText().toString();
                String email = et_email.getText().toString();

                SecureRandom random = null;
                try {
                    random = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                byte[] bytes = new byte[16];
                random.nextBytes(bytes);
                String salt = new String(Base64.getEncoder().encode(bytes));
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                md.update(salt.getBytes());
                md.update(password.getBytes());
                password = String.format("%064x", new BigInteger(1, md.digest()));

                register(userName, password, email, salt);
            }
        });

        if (AppHelper.requestQueue == null) {
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }
}