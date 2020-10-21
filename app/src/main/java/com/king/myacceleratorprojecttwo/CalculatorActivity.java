package com.king.myacceleratorprojecttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    TextView mTvAnswer;
    EditText mEdtFnum, mEdtSnum;
    Button mBtnAdd, mBtnSubtract, mBtnDivide, mBtnMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mTvAnswer = findViewById(R.id.tv_answer);
        mEdtFnum = findViewById(R.id.edt_first_number);
        mEdtSnum = findViewById(R.id.edt_second_number);
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnSubtract = findViewById(R.id.btn_subtract);
        mBtnDivide = findViewById(R.id.btn_divide);
        mBtnMultiply = findViewById(R.id.btn_multiply);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive the numbers provided by the user
                String first_number = mEdtFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting empty fields
                if (first_number.isEmpty()){
                    mEdtFnum.setError("Please enter first number");
                }else if (second_number.isEmpty()){
                    mEdtSnum.setError("Please enter second number");
                }else {
                    //Do the calculation and give the answer
                    Double answer = Double.parseDouble(first_number) + Double.parseDouble(second_number);

                    //Display the answer to out textview
                    mTvAnswer.setText(String.valueOf(answer));

                }
            }
        });

        mBtnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive the numbers provided by the user
                String first_number = mEdtFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting empty fields
                if (first_number.isEmpty()){
                    mEdtFnum.setError("Please enter first number");
                }else if (second_number.isEmpty()){
                    mEdtSnum.setError("Please enter second number");
                }else {
                    //Do the calculation and give the answer
                    Double answer = Double.parseDouble(first_number) - Double.parseDouble(second_number);

                    //Display the answer to out textview
                    mTvAnswer.setText(String.valueOf(answer));

                }
            }
        });

        mBtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive the numbers provided by the user
                String first_number = mEdtFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting empty fields
                if (first_number.isEmpty()){
                    mEdtFnum.setError("Please enter first number");
                }else if (second_number.isEmpty()){
                    mEdtSnum.setError("Please enter second number");
                }else {
                    //Do the calculation and give the answer
                    Double answer = Double.parseDouble(first_number) / Double.parseDouble(second_number);

                    //Display the answer to out textview
                    mTvAnswer.setText(String.valueOf(answer));

                }
            }
        });

        mBtnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive the numbers provided by the user
                String first_number = mEdtFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting empty fields
                if (first_number.isEmpty()){
                    mEdtFnum.setError("Please enter first number");
                }else if (second_number.isEmpty()){
                    mEdtSnum.setError("Please enter second number");
                }else {
                    //Do the calculation and give the answer
                    Double answer = Double.parseDouble(first_number) * Double.parseDouble(second_number);

                    //Display the answer to out textview
                    mTvAnswer.setText(String.valueOf(answer));

                }
            }
        });
    }
}