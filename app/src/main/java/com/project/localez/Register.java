package com.project.localez;

import static com.project.localez.Login.mGoogleSignInClient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private static final int RC_SIGN_IN = 0;
    private FirebaseAuth mAuth;
    private EditText etEmail, etPassword, etCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.sign_in_button).setOnClickListener(view -> googleSignIn());

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etCPassword = findViewById(R.id.et_c_password);

        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(view -> {
            Intent goLogin = new Intent(Register.this, Login.class);
            startActivity(goLogin);
            finish();
        });

        FloatingActionButton fabRegister = findViewById(R.id.fab_register);
        fabRegister.setOnClickListener(view -> {

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String cPassword = etCPassword.getText().toString();

            if(email.equals("") || password.equals("") || cPassword.equals("")){
                Toast.makeText(Register.this, "Please fill all the field!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(password.length() < 8){
                Toast.makeText(Register.this, "Password must be longer than 8 characters!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(!password.equals(cPassword)){
                Toast.makeText(Register.this, "Confirm Password must be the same with password!", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Register.this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();

                        Toast.makeText(Register.this, "Authentication success.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(Register.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        });
    }

    @Override
    public void onBackPressed() {
        Intent goLogin = new Intent(Register.this, Login.class);
        startActivity(goLogin);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            goToMain();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(Register.this, e.getStatusCode(), Toast.LENGTH_SHORT).show();
        }
    }

    private void googleSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void goToMain() {
        FirebaseUser user = mAuth.getCurrentUser();
        Intent goMain = new Intent(Register.this, MainActivity.class);
        startActivity(goMain);
        finish();
        Toast.makeText(Register.this, "Authentication success.", Toast.LENGTH_SHORT).show();
    }

}