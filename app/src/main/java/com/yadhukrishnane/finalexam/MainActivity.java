package com.yadhukrishnane.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText edtUsername;
    private AppCompatEditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        edtUsername = findViewById(R.id.edt_login_username);
        edtPassword = findViewById(R.id.edt_login_password);
        AppCompatTextView btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });


    }

    private void checkLogin() {
        if (edtUsername.getText() == null || edtPassword.getText() == null) return;

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (validate()) {
            if (username.equals("user1") && password.equals("password1")) {
                goToSecondPage();
            } else {
                Toast.makeText(this, "Entered username and password are wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate() {
        if (edtUsername.getText() == null || edtPassword.getText() == null) return false;

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.length() == 0) {
            edtUsername.setError("Enter a username");
            return false;
        } else if (password.length() == 0) {
            edtPassword.setError("Enter a password");
            return false;
        }

        return true;
    }

    private void goToSecondPage() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        MainActivity.this.finish();
    }
}
