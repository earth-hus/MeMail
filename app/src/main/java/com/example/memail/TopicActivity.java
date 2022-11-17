package com.example.memail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;

public class TopicActivity extends AppCompatActivity {
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        getSupportActionBar().setTitle("Email Topics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String value = intent.getStringExtra("key");

        list = new ArrayList<>(Arrays.asList("Absence,Assignment Question,Exam Rescheduling,Extension Request,Introduction,Recommendation Letter,Research Interest".split(",")));
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyCustomAdapter(list, this,"TopicActivity"));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(myIntent);
        return true;
    }
}