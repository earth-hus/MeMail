package com.example.memail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DraftActivity extends AppCompatActivity {
    ImageButton saveButton = findViewById(R.id.saveButton);
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference saved =db.collection("Saved");
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft);


        saveButton.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Map<String, Object> data = new HashMap<>();
        EditText draft = findViewById(R.id.draft);
        EditText title = findViewById(R.id.draftTitle);
        data.put("Draft", draft.toString());
        data.put("Title", title.toString());
        data.put("UID", mAuth.getUid());
    }


}