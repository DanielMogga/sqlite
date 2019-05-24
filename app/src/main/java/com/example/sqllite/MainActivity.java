package com.example.sqllite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //calling the database
    DatabaseHelper db;

    EditText e1,e2,e3;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call database to the projectv initialize
        db=new DatabaseHelper(this);

        e1=findViewById(R.id.email);
        e2=findViewById(R.id.password);
        e3=findViewById(R.id.cpass);
        b1=findViewById(R.id.register);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();

                //database phase 3
                if (s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }else {
                    if (s2.equals(s3)){
                        Boolean chkemail=db.chkemail(s1);
                        if (chkemail==true){
                            //startActivity(new Intent(MainActivity.this,HomeActivity.class));
                            Toast.makeText(getApplicationContext(),"Resgistration Sucessfull",Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Email Already Exist",Toast.LENGTH_SHORT).show();

                    }
                }
                Toast.makeText(getApplicationContext(),"Password do not mach",Toast.LENGTH_SHORT).show();
            }
        });
    }
}