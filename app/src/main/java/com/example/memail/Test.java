package com.example.memail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Test extends AppCompatActivity {
    FirebaseFirestore db;
    ListView topicsLV;
    CollectionReference templates;
    ArrayList<DocumentSnapshot> documentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        db = FirebaseFirestore.getInstance();
        templates = db.collection("Templates");
        documentList = new ArrayList<>();
        topicsLV = findViewById(R.id.TopicsListView);

    }

    private void loadDataInListView() {
        templates.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()) {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot d: list) {
                        documentList.add(d);
                    }

                    
                }
            }
        });
    }
}