package com.example.memail;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.*;

public class HomeActivity extends AppCompatActivity {
    Button b;
    Button b1;
    Button b2;

    Button signOutButton;
    FirebaseAuth mAuth;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b = findViewById(R.id.schoolButton);
        b1 = findViewById(R.id.professionButton);
        b2 = findViewById(R.id.organizationButton);

        b.setOnClickListener(this::onClick);
        b1.setOnClickListener(this::onClick);
        b2.setOnClickListener(this::onClick);

        mAuth = FirebaseAuth.getInstance();

        signOutButton = findViewById(R.id.SignOut);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(HomeActivity.this, LogInKT.class);
                startActivity(intent);
            }
        });

//    binding.btnGoogleSignOut.setOnClickListener {
//            firebaseAuth.signOut()
//            googleSignInClient.signOut()
//            onResume()
//
//            Log.d(TAG, "onActivityResult : Sign Out Successfully!")
//            Toast.makeText(this, "Sign Out Successfully!", Toast.LENGTH_SHORT).show()
//        }
    }
    public void onClick(View v) {
        String buttonText = b.getText().toString();
        Intent myIntent = new Intent(HomeActivity.this, TopicActivity.class);
        myIntent.putExtra("key", "value");
        HomeActivity.this.startActivity(myIntent);

    }

//        CollectionReference templates = db.collection("Templates");

//        Map<String, Object> data = new HashMap<>();
//        data.put("Category", "Organization");
//        data.put("Draft", "Test 2");
//        data.put("Title", "Draft");
//        data.put("Format", "Default Draft");
//        data.put("Topic", "Topic 2");
//        templates.document().set(data);


    //    signOut.setOnClickListener()
}