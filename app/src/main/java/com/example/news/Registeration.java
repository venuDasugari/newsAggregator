package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeration extends AppCompatActivity  {
    Button bReg;
    EditText name,phone,pass,cnp,email;
    static SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        bReg=(Button)findViewById(R.id.br);
        name=(EditText)findViewById(R.id.usr1);
        email=(EditText)findViewById(R.id.md);
        phone=(EditText)findViewById(R.id.psw1);
        pass=(EditText)findViewById(R.id.pwd);
        cnp=(EditText)findViewById(R.id.p);
        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
                Intent reg=new Intent(getBaseContext(),MainActivity.class);
                startActivity(reg);
            }
        });

    }

    private void checkCrededentials() {
        String username=name.getText().toString();
        String useremail=email.getText().toString();
        String userpws=pass.getText().toString();
        String uphone=cnp.getText().toString();

        if (username.isEmpty() || username.length()<7){
            showError(name,"your user name is not valid");
        }
        else if (useremail.isEmpty()|| !useremail.contains("@")){
            showError(email,"Email is not valid");
        }
        else if (userpws.isEmpty() || userpws.length()<7 ){
            showError(pass,"invalid password");
        }
        else if (uphone.isEmpty() || uphone.contains("Number")){
            showError(cnp,"invalid mobile number");
        }
        else{
            editor=sp.edit();
            editor.putString("mail",useremail);
            editor.putString("password",userpws);
            editor.commit();
            Toast.makeText(this,"you'r registration is success",Toast.LENGTH_SHORT).show();
        }

    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }

    public void login(View view) {
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}



