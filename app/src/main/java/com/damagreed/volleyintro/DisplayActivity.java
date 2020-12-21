package com.damagreed.volleyintro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    Button back_btn;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    public String json_url = "http://korioutoro.com/api/barang.php";

    ArrayList<ListBarang> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        back_btn = findViewById(R.id.back_btn);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray dataBarang = response.getJSONArray("data");

                    int count = 0;
                    while (count < dataBarang.length()) {
                        JSONObject jsonObject = dataBarang.getJSONObject(count);
                        //Toast.makeText(context,   jsonObject.toString(), Toast.LENGTH_LONG).show();
                        ListBarang listBarang = new ListBarang(jsonObject.getString("nama"), jsonObject.getString("harga"), jsonObject.getString("qty"));
                        arrayList.add(listBarang);
                        count++;
                    }
                } catch (JSONException E) {
                    E.printStackTrace();
                }
                adapter = new RecyclerAdapter(arrayList);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DisplayActivity.this, "Somethings went wrong...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        JsonQueueSingleton.getInstance(DisplayActivity.this).AddToRequestQueue(jsonObjectRequest);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}