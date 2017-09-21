package com.example.optlptp153.customlogin;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*if (getLoggedIn()){
           redirectToDashboard();
     }*/

        final EditText username = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.pwd);


        final String ePattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+[a-z]";

        final String pPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(username.getText().toString().trim().length()==0){
                    username.setError("Username is not entered");
                    username.requestFocus();
                }
                else
                {
                    Pattern p = Pattern.compile(ePattern);
                    Matcher m = p.matcher(username.getText().toString().trim());

                    if(!m.matches()){
                        username.setError("E-mail must contain only letters, numbers, '@' and '.'");
                        username.requestFocus();
                    }

                }



                if(password.getText().toString().trim().length()==0){
                    password.setError("Password is not entered");
                    password.requestFocus();
                }
                else
                {
                    Pattern p1 = Pattern.compile(pPattern);
                    Matcher m1 = p1.matcher(password.getText().toString().trim());
                    if(!m1.matches()){
                        password.setError("Password must be minimum of 8 characters and must contain atleast one capital letter, one number and one special character");
                        password.requestFocus();
                    }
                     else{

                    Toast.makeText(MainActivity.this,"Welcome Admin",Toast.LENGTH_SHORT).show();

                }
                }


            }
        });
    }

    }



   /* public void login(View view) {
        EditText username = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.pwd);
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")){

            Toast.makeText(MainActivity.this,"Welcome Admin",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"Email or password invalid",Toast.LENGTH_SHORT).show();
        }
    }*/




