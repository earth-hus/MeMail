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
    ImageButton saveButton;
    FirebaseFirestore db;
    CollectionReference saved;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft);

        saveButton = findViewById(R.id.saveButton);
        db = FirebaseFirestore.getInstance();
        saved = db.collection("Saved");
        mAuth = FirebaseAuth.getInstance();

        saveButton.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Map<String, Object> data = new HashMap<>();
        EditText draft = findViewById(R.id.draft);
        EditText title = findViewById(R.id.draftTitle);
        data.put("Draft", draft.getText().toString());
        data.put("Title", title.getText().toString());
        data.put("UID", mAuth.getUid());
        saved.document().set(data);
    }


}