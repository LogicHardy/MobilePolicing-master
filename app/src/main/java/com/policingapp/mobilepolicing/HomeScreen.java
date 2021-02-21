package com.policingapp.mobilepolicing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String name="Hello, "+user.getDisplayName();
        TextView textElement = (TextView) findViewById(R.id.dashTitleTextView);
        textElement.setText(name); //leave this line to assign a string resource
    }

    public void goToComplaintRegistration(View view) {
        Intent intent = new Intent(getApplicationContext(), ComplaintRegistration.class);
        startActivity(intent);
    }

    public void goToDocumentVerification(View view) {
        Intent intent = new Intent(getApplicationContext(), DocumentVerification.class);
        startActivity(intent);
    }

    public void goToSoSButton(View view) {
        Intent intent = new Intent(getApplicationContext(), SoSButton.class);
        startActivity(intent);
    }

    public void goToTravelGuidebook(View view) {
        Intent intent = new Intent(getApplicationContext(), ComplaintRegistration.class);
        startActivity(intent);
    }
}