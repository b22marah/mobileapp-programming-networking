package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    private RecyclerView recyclerView;
    private ArrayList<Mountain> listOfMountains;
    private MyAdapter adapter;

    @SuppressWarnings("SameParameterValue")
    private String readFile(String fileName) {
        try {
            //noinspection CharsetObjectCanBeUsed
            return new Scanner(getApplicationContext().getAssets().open(fileName), Charset.forName("UTF-8").name()).useDelimiter("\\A").next();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonTask( this).execute(JSON_URL);
    }


    @Override
    public void onPostExecute(String json) {
        if (json != null){
            Log.d("MainActivity", json);

            Gson gson = new Gson();
            listOfMountains = gson.fromJson(json, new TypeToken<ArrayList<Mountain>>(){}.getType());
            adapter = new MyAdapter(listOfMountains);
            adapter.notifyDataSetChanged();

            RecyclerView view = findViewById(R.id.recyclerview);
            listOfMountains = new ArrayList<Mountain>();
            view.setLayoutManager(new LinearLayoutManager(this));
            view.setAdapter(adapter);

            adapter.notifyDataSetChanged();
        }
        else {
            Log.d("MainActivity", "JSON response: Null.");
        }
        String s = readFile("mountains.json");
        Log.d("MainActivity","The following text was found in textfile:\n\n"+s);
    }
}