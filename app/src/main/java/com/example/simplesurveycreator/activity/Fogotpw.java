package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.activity.Login;
import com.example.simplesurveycreator.activity.Signup;

public class Fogotpw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogotpw);
    }

    public void SignUpButtonClickFunction(View view) {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void CancelButtonClickFunction(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void ResetButtonClickFunction(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}