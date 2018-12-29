package com.example.mac.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.mac.myapplication.modelo.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://192.168.0.8:8000/register/addUser";
    private static final String KEY_NAME = "name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_AGE = "age";
    private EditText nam_e , last_n_ame, a_ge;
    private RequestQueue http;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        http = Volley.newRequestQueue(getApplicationContext());
        http.getCache().clear();
        init();
    }

    private void init(){
        nam_e = (EditText)(findViewById(R.id.name));
        last_n_ame = (EditText)(findViewById(R.id.last_name));
        a_ge = (EditText)(findViewById(R.id.age));
    }

    public void add(View view){

        User user = new User(nam_e.getText().toString(),last_n_ame.getText().toString(),a_ge.getText().toString());
        apiRest(user.getName(),user.getLas_name(),user.getAge());
    }


    private void apiRest(String name, String last_name, String age){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(KEY_NAME, name);
            jsonObject.put(KEY_LAST_NAME,last_name);
            jsonObject.put(KEY_AGE,age);

            JsonObjectRequest json = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Toast.makeText(getApplicationContext(),"Datos Guardados", Toast.LENGTH_SHORT).show();

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(),"Error" + error, Toast.LENGTH_SHORT).show();

                        }
                    }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> pars = new HashMap<String, String>();
                    pars.put("Content-Type", "application/json");
                    return  pars;
                }
            };
            http.add(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }





}
