package com.example.memail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SavedActivity extends AppCompatActivity {

    ArrayList<String> list;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        db = FirebaseFirestore.getInstance();
        getSupportActionBar().setTitle("Saved Drafts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.Saved_list);
        MyCustomAdapter adapter = new MyCustomAdapter(list, this,"FormatActivity",);
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
                                    list.add(c.getTitle());
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
    }
}