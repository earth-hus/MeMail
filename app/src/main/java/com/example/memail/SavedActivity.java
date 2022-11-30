package com.example.memail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity {

    ArrayList<String> arrlist;
    ArrayList<String> documents;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        db = FirebaseFirestore.getInstance();
        getSupportActionBar().setTitle("Saved Drafts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrlist = new ArrayList<>();
        documents = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.Saved_list);
        CustomAdapter adapter = new CustomAdapter(arrlist, this, "FormatActivity", documents);
        listView.setAdapter(adapter);

        db.collection("Saved").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Templates c = d.toObject(Templates.class);

                                // Check to make sure topic matches
                                arrlist.add(c.getTitle());
                                documents.add(d.getId());
                                adapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(SavedActivity.this, "No templates found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SavedActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }

                });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(myIntent);
        return true;
    }
}