package com.example.test81;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //variable component
    EditText username;
    EditText password;

    Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);

        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login_button);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();
                if (enteredUsername.equals("Dylan") && enteredPassword.equals("mars")) {
                    Intent intent = new Intent(MainActivity.this, aritmatik_calculator.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "password atau username salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}