package com.example.memail;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

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
        String category = intent.getStringExtra("Category");
        System.out.println("Category:  "+category);
        if(category.equals("School")){
            list = new ArrayList<>(Arrays.asList("Absence,Assignment Question,Exam Rescheduling,Extension Request,Introduction,Recommendation Letter,Research Interest".split(",")));
        }
        else if(category.equals("Profession")){
            list = new ArrayList<>(Arrays.asList("Absence,Decline Offer,Accept Offer,Extension Request,Recommendation Letter,Letter of Resignation,Request PTO,Notify Date Time Off,Job Offer Negotiation".split(",")));
        }
        else if(category.equals("Organization")){
            list = new ArrayList<>(Arrays.asList("Speaker Invitation,Event Volunteering,Request Sponsorship".split(",")));

        }
//        else{
//            list = new ArrayList<>(Arrays.asList("Absence,Assignment Question,Exam Rescheduling,Extension Request,Introduction,Recommendation Letter,Research Interest".split(",")));
//
//        }

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new CustomAdapter(list, this,"TopicActivity", category));
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(myIntent);
        return true;
    }
}