package com.example.memail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FormatActivity extends AppCompatActivity {
    ArrayList<String> formatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format);
        getSupportActionBar().setTitle("Email Templates");

        formatList = new ArrayList<>(Arrays.asList("Format 1,Format 2,Format 3".split(",")));
        ListView listView = (ListView) findViewById(R.id.format_list);
        listView.setAdapter(new MyCustomAdapter(formatList, this));
    }
}