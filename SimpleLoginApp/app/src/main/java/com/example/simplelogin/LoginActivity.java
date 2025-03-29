package com.example.simplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etUsername = findViewById(R.id.etUsername);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        ImageView imgEye = findViewById(R.id.imgEye);

        // Load shake animation
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        // Login Button Click
        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.equals("admin") && password.equals("1234")) {
                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish();
            } else {
                etPassword.startAnimation(shake);
                Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        });

        // Toggle Password Visibility
        imgEye.setOnClickListener(v -> {
            if (isPasswordVisible) {
                etPassword.setInputType(129);
                imgEye.setImageResource(R.drawable.ic_eye_closed);
            } else {
                etPassword.setInputType(145);
                imgEye.setImageResource(R.drawable.ic_eye_open);
            }
            etPassword.setSelection(etPassword.length()); // Keep cursor at end
            isPasswordVisible = !isPasswordVisible;
        });
    }
}
