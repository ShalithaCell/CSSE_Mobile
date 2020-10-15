package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simplesurveycreator.R;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

//    Toast toast_success = Toast.makeText(getApplicationContext(),
//            "Successfully Logged In.",
//            Toast.LENGTH_SHORT);

    public void buttonClickFunction(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void signUpClickFunction(View view) {
        Intent intent = new Intent(this, Dashboard.class);
       // toast_success.show();
        startActivity(intent);
    }
}