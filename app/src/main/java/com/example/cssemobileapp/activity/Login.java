package com.example.cssemobileapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cssemobileapp.R;

public class Login extends AppCompatActivity {
    Button materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        materialButton = (Button) findViewById(R.id.button_signin) ;
        materialButton.setBackgroundColor( ContextCompat.getColor(Login.this, R.color.colorSuccess));
    }

    public void SignUpButtonClickFunction(View view) {


    }

    public void FogotPWbuttonClickFunction(View view) {

    }

    public void SignInButtonClickFunction(View view) {

        Intent intent = new Intent(Login.this, HomeAppActivity.class);
        startActivity(intent);

        Toast toast_success = Toast.makeText(getApplicationContext(),
                "Successfully Logged in.",
                Toast.LENGTH_SHORT);
        toast_success.show();
    }
}