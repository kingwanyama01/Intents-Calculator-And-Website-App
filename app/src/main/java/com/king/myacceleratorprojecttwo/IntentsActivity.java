package com.king.myacceleratorprojecttwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentsActivity extends AppCompatActivity {
    Button mBtnSms, mBtnStk, mBtnEmail, mBtnShare, mBtnDial, mBtnCamera, mBtnCall;
    EditText mEdtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        mBtnSms = findViewById(R.id.btn_sms);
        mBtnStk = findViewById(R.id.btn_stk);
        mBtnEmail = findViewById(R.id.btn_email);
        mBtnShare = findViewById(R.id.btn_share);
        mBtnDial = findViewById(R.id.btn_dial);
        mBtnCamera = findViewById(R.id.btn_camera);
        mBtnCall = findViewById(R.id.btn_call);
        mEdtPhoneNumber = findViewById(R.id.edt_phone);

        //Set the onclick listeners for the buttons
        mBtnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0700000000");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Hello, Sir, I won't be able to make it to t......");
                startActivity(intent);
            }
        });

        mBtnStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if(simToolKitLaunchIntent != null) {
                    startActivity(simToolKitLaunchIntent);
                }
            }
        });

        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","king@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "KUOMBA KAZI");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hujambo mkurugenzi mpendwa, naandika ujumbe huu ilimradi kuomba kazi.....");
                startActivity(Intent.createChooser(emailIntent, "SENDING EMAIL"));
            }
        });

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hello there, please click on https://www.mywebsite.com/playstore to download my app");
                startActivity(shareIntent);
            }
        });

        mBtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+2557";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, 1);
            }
        });

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive a phone number from the Phone number field
                String phone = mEdtPhoneNumber.getText().toString();

                if (phone.isEmpty()){
                    mEdtPhoneNumber.setError("Please enter phone number");
                }else if (phone.length()<10){
                    mEdtPhoneNumber.setError("Please enter a valid number");
                }else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                    if (ContextCompat.checkSelfPermission(IntentsActivity.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(IntentsActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    }
                    else
                    {
                        startActivity(intent);
                    }
                }
            }
        });
    }
}