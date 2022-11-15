package com.example.memail;

import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Email Topics");

        list = new ArrayList<>(Arrays.asList("Absence,Assignment Question,Exam Rescheduling,Extension Request,Introduction,Recommendation Letter,Research Interest".split(",")));
        ListView listView = (ListView) findViewById(R.id.listview);
        TextView searchTopic= (TextView) findViewById(R.id.plain_text_input);
        System.out.println("This is print: "+ searchTopic.getText());
        listView.setAdapter(new MyCustomAdapter(list, this));
    }
}