package com.pelu.avengers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class verification extends AppCompatActivity {

    boolean val=false;
    int otp=0;
    TextView VerificationT,otpT,resendotpT;
    EditText otpET;
    Button backBT,verifyBT;



    private String verificationotp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        VerificationT = (TextView)findViewById(R.id.verificationT);
        otpT = (TextView)findViewById(R.id.otptext);

        otpET = (EditText)findViewById(R.id.otpEtext);

        resendotpT = (Button)findViewById(R.id.resendbt);
        backBT = (Button)findViewById(R.id.backbutton);
        verifyBT = (Button)findViewById(R.id.verifybutton);

        resendotpT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                val = true;
                Random r = new Random();
                otp = r.nextInt(899999)+100000;

                Toast.makeText(verification.this, "OTP: "+ String.valueOf(otp), Toast.LENGTH_LONG).show();


            }
        });

        verifyBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if  (((otpET.getText().toString().equals(getIntent().getStringExtra("OTP")))&&(val==false))
                        ||  (otpET.getText().toString().equals(String.valueOf(otp))))
                {
                    Toast.makeText(verification.this, "Verified!!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(verification.this, MainActivity.class);
                    startActivity(i);

                    finish();

                }

                else
                {
                    resendotpT.setVisibility(View.VISIBLE);
                    Toast.makeText(verification.this, "Invalid OTP!!", Toast.LENGTH_SHORT).show();

                }

            }


        });

        backBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k = new Intent(verification.this,login.class);
                startActivity(k);
                finish();
            }
        });

    }
}