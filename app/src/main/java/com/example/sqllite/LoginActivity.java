package com.example.sqllite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    TextView et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        e1=findViewById(R.id.emai);
        e2=findViewById(R.id.editText2);
        b1=findViewById(R.id.button);

        et=findViewById(R.id.texregister);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String email=e1.getText().toString();
                //String password=e2.getText().toString();
               // Boolean chkemailpass =db.emailpassword(email,password);
               // if (chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "successful login", Toast.LENGTH_SHORT).show();
                //}
                //else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                //}

                //try new code
                b1_onClick();


            }
        });


    }

    private void b1_onClick() {
        String email=e1.getText().toString();
        String password=e2.getText().toString();
        Boolean chkemail=db.chkemail(email);
        if (chkemail==true){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            Toast.makeText(getApplicationContext(),"Sucessfull login",Toast.LENGTH_SHORT).show();

        } else {
        Toast.makeText(getApplicationContext(),"faild",Toast.LENGTH_SHORT).show();

    }

    }
}
