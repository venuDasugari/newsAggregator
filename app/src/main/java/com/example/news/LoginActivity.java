package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    Button bLogin,register;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bLogin = (Button) findViewById(R.id.bl);
        user = (EditText) findViewById(R.id.usr);
        password = (EditText) findViewById(R.id.psw);
        register = findViewById(R.id.rh);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }

            private void checkCrededentials() {
                String useremail1 = user.getText().toString();
                String userpws1 = password.getText().toString();
                String s = Registeration.sp.getString("mail", "");
                String p = Registeration.sp.getString("password", "");
                if ((useremail1.equals(s)) && (userpws1.equals(p)))
                    if (useremail1.isEmpty() || useremail1.length() < 7) {
                        showError(user, "your user email is not valid");
                    } else if (userpws1.isEmpty() || userpws1.length() < 7) {
                        showError(password, "invalid password");
                    } else if ((useremail1.equals(s)) && (userpws1.equals(p))) {
                        Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();

                    }

            }
        });
    }


    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }

    public void register(View view) {
        Intent intent=new Intent(this,Registeration.class);
        startActivity(intent);
    }
}



