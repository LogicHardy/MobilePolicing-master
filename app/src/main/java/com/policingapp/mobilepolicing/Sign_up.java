package com.policingapp.mobilepolicing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
/*import com.google.firebase.quickstart.auth.R;
import com.google.firebase.quickstart.auth;
import com.google.firebase.quickstart.auth.databinding.ActivityEmailpasswordBinding;*/

public class Sign_up extends AppCompatActivity {
    /*
        private FirebaseAuth mAuth;
    // ...
    // Initialize Firebase Auth
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mAuth = FirebaseAuth.getInstance();
            setContentView(R.layout.activity_signup);
            Button next = (Button) findViewById(R.id.goToLoginBtn);
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
            });
        }
        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
            }*/
    public EditText emailId, passwd;
    Button btnSignUp;
    Button signIn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailEditText);
        passwd = findViewById(R.id.passEditText);
        btnSignUp = findViewById(R.id.signUpBtn);
        signIn = findViewById(R.id.goToLoginBtn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Sign_up.this, Login.class);
                startActivity(I);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailID = emailId.getText().toString();
                String paswd = passwd.getText().toString();
                if (emailID.isEmpty()) {
                    emailId.setError("Provide your Email first!");
                    emailId.requestFocus();
                } else if (paswd.isEmpty()) {
                    passwd.setError("Set your password");
                    passwd.requestFocus();
                } else if (emailID.isEmpty() && paswd.isEmpty()) {
                    Toast.makeText(Sign_up.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(Sign_up.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Sign_up.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Sign_up.this, HomeScreen.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Sign_up.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
