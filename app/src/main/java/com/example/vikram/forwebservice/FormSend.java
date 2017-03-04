package com.example.vikram.forwebservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FormSend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_send);

        findViewById(R.id.btnSend).setOnClickListener(this::setValidation);
    }

    private EditText getEdtName () {
        return (EditText) findViewById(R.id.editName);
    }
    private EditText getEdtCollege () {
        return (EditText) findViewById(R.id.editCollege);
    }
    private EditText getEdtContact () {
        return (EditText) findViewById(R.id.editPhone);
    }
    private EditText getEdtPassword () {
        return (EditText) findViewById(R.id.editPassword);
    }

    private void setValidation (View view) {

        if (getEdtName().getText().toString().isEmpty()) {
            getEdtName().setError("Enter Name");
        }
        if (getEdtCollege().getText().toString().isEmpty()) {
            getEdtCollege().setError("Enter College");
        }
        if (getEdtContact().getText().toString().isEmpty()) {
            getEdtContact().setError("Enter Contact Number");
        }
        if (getEdtPassword().getText().toString().isEmpty()) {
            getEdtPassword().setError("Enter Password");
        }
        setError();
    }

    private void setError () {

        if (!getEdtName().getText().toString().isEmpty()) {
            if (!getEdtCollege().getText().toString().isEmpty()) {
                if (!getEdtContact().getText().toString().isEmpty()) {
                    if (!getEdtPassword().getText().toString().isEmpty()) {
                        postData();
                        Toast.makeText(this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void postData () {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("name",getEdtName().getText().toString());
            jsonObject.put("college",getEdtCollege().getText().toString());
            jsonObject.put("phone_no",getEdtContact().getText().toString());
            jsonObject.put("password",getEdtPassword().getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("@modi", String.valueOf(jsonObject));

        Singletone.q(this).add(new JsonObjectRequest(Request.Method.POST,"http://192.168.2.35:8080/saveData",
                jsonObject,this::onResponce,this::onResponceError)
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<>();
                headers.put("Content-Type","application/json");
                headers.put("accept", "application/json");
                return headers;
            }

        });
    }

    private void onResponce(JSONObject jsonObject) {
        Log.i("@codekul", String.valueOf(jsonObject));
    }

    private void onResponceError(VolleyError volleyError) {
        Log.i("@codekul", String.valueOf(volleyError));
    }


}
