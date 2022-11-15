package com.example.memail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;

public class HomeActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CollectionReference templates = db.collection("Templates");

//        Map<String, Object> data = new HashMap<>();
//        data.put("Category", "Organization");
//        data.put("Draft", "Test 2");
//        data.put("Title", "Draft");
//        data.put("Format", "Default Draft");
//        data.put("Topic", "Topic 2");
//        templates.document().set(data);
    }
}