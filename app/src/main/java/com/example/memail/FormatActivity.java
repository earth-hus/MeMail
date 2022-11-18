package com.example.memail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatActivity extends AppCompatActivity {
    // List of formats
    ArrayList<String> templateList;

    // Database
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_format);
        getSupportActionBar().setTitle("Email Templates");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the topic of intended email
        Bundle extras = getIntent().getExtras();
        String topic = extras.getString("Topic");
        String category = extras.getString("Category");

        // Get instance of firebase firestore
        db = FirebaseFirestore.getInstance();
        templateList = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.format_list);

        MyCustomAdapter adapter = new MyCustomAdapter(templateList, this,"FormatActivity");
        listView.setAdapter(adapter);

        db.collection("Templates").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Templates c = d.toObject(Templates.class);

                                // Check to make sure topic matches
                                if (topic.equals(c.getTopic()) && category.equals(c.getCategory())) {
                                    templateList.add(c.getTitle());
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        } else {
                            Toast.makeText(FormatActivity.this, "No templates found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FormatActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }
        });

        System.out.println("test");


    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), TopicActivity.class);
        startActivity(myIntent);
        return true;
    }
}