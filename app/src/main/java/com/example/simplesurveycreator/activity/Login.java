package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.simplesurveycreator.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
//    Toast toast_success = Toast.makeText(getApplicationContext(),
//            "Successfully registered.",
//            Toast.LENGTH_SHORT);

    public void SignInbuttonClickFunction(View view) {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void FogotPWbuttonClickFunction(View view) {
        Intent intent = new Intent(this, Fogotpw.class);
        startActivity(intent);
    }

    public void SignUpButtonClickFunction(View view) {
        Intent intent = new Intent(this, Signup.class);
       // toast_success.show();
        startActivity(intent);
    }
}