package com.pelu.avengers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class login extends AppCompatActivity {

    TextView loginT,mobileT,nameT;
    EditText mobileET,nameET;
    Button otpBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginT = (TextView)findViewById(R.id.logintext);
        nameT = (TextView)findViewById(R.id.nametext);
        mobileT = (TextView)findViewById(R.id.mobiletext);

        mobileET = (EditText)findViewById(R.id.mobileEtext);
        nameET = (EditText)findViewById(R.id.nameEtext);

        otpBT = (Button)findViewById(R.id.otpbutton);

        otpBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mobileET.getText().toString().length()==10 && nameET.getText().toString().length()!=0) {
                    Random r = new Random();

                    int otp = r.nextInt(899999) + 100000;



                    Intent i = new Intent(login.this, verification.class)
                            .putExtra("OTP",String.valueOf(otp));

                    Intent j = new Intent(login.this,bill.class)
                            .putExtra("name",nameET.getText().toString())
                            .putExtra("mobile",mobileET.getText().toString());

                    Toast.makeText(login.this, "OTP: " + otp, Toast.LENGTH_LONG).show();

                    startActivity(i);

                    finish();
                }

                else {
                    if (mobileET.getText().toString().length() != 10) {
                        Toast.makeText(login.this, "Invalid Number!!!", Toast.LENGTH_LONG).show();

                    }

                    else {
                        Toast.makeText(login.this, "Invalid Name!!!", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

}
