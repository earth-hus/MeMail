package com.example.memail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.memail.databinding.ActivityLogInBinding;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LogInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private GoogleSignInClient gsc;
    private GoogleSignInOptions gso;

    private static final int REQ_ONE_TAP = 123;  // Can be any integer unique to the Activity.
    private boolean showOneTapUI = true;

    private int RC_SIGN_IN = 123;

    /** Add this */
    private ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** Add this */
        binding = ActivityLogInBinding.inflate(getLayoutInflater());

        /** Change this */
        setContentView(binding.getRoot());

//        /** Without findViewById */
//        binding.textView.setText("Bye bye findViewById");

        setContentView(R.layout.activity_log_in);

        // log in, else sign up
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
//        else {
//            Intent intent = new Intent(this, LogInActivity.class);
//            startActivity(intent);
//        }

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                .requestIdToken(getString((R.string.default_web_client_id)))
                .requestEmail()
                .build();

        gsc = GoogleSignIn.getClient(this, gso);

        Button googleSignIn = findViewById(R.id.GoogleSignIn);
        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });


//        BeginSignInRequest signInRequest = BeginSignInRequest.builder()
//                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                        .setSupported(true)
//                        // Your server's client ID, not your Android client ID.
//                        // 927326515197-hnan1sc2mmslv2or01muqan1m3r6uikb.apps.googleusercontent.com
//                        .setServerClientId(getString(R.string.default_web_client_id))
//                        // Only show accounts previously used to sign in.
//                        .setFilterByAuthorizedAccounts(true)
//                        .build())
//                .build();

    }


    private void SignIn() {
        Intent signInIntent = gsc.getSignInIntent();
//        signInIntent.putExtra("code", RC_SIGN_IN);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_ONE_TAP:
//                SignInCredential googleCredential = SignInClient.getSignInCredentialFromIntent(data);
//                String idToken = googleCredential.getGoogleIdToken();
//                if (idToken !=  null) {
//                    // Got an ID token from Google. Use it to authenticate
//                    // with Firebase.
//                    AuthCredential firebaseCredential = GoogleAuthProvider.getCredential(idToken, null);
//                    mAuth.signInWithCredential(firebaseCredential)
//                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success, update UI with the signed-in user's information
//                                        Log.d("Sign in", "signInWithCredential:success");
//                                        FirebaseUser user = mAuth.getCurrentUser();
//                                        new HomeActivity();
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        Log.w("sign in failed", "signInWithCredential:failure", task.getException());
////                                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT, Toast.LENGTH_SHORT).show();
////                                        updateUI(null);
//                                    }
//                                }
//                            });
//                }
//
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    task.getResult(ApiException.class);
                    HomeActivity();
//                    SignInCredential credential = gsc.getSignInCredentialFromIntent(data);
//                    String idToken = credential.getGoogleIdToken();
//                    if (idToken !=  null) {
//                        // Got an ID token from Google. Use it to authenticate
//                        // with Firebase.
//                        Log.d("ID Token", "Got ID token.");
////                    }
                } catch (ApiException e) {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void HomeActivity() {
        finish();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
