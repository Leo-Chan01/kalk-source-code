package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.raym.kalk.models.Calculator;

public class CalculationActivity extends AppCompatActivity {
    private Button mDoneButton;
    private Button mNextCourseButton;
    private Button mPreviousButton;
    private EditText mCourseGrade;
    private EditText mCourseChoice;
    public Calculator mCalculator = new Calculator();
    private String mCourseCode;
    private int mCreditLoad;
    private int mTotalCreditUnit;
    private int mTotalCreditLoad;
    private int mGrade;
    private int mGradeEquivalent;
    private float mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        mDoneButton = findViewById(R.id.done_button);
        mPreviousButton = findViewById(R.id.previous_course_button);
        mNextCourseButton = findViewById(R.id.next_course_button);
        mCourseChoice = findViewById(R.id.edit_text_course_choice);
        mCourseGrade = findViewById(R.id.edit_text_grade);
        //when the user clicks on the done button
        mDoneButton.setOnClickListener(view -> {
            mTotalCreditUnit = mCalculator.calculateTotalCreditUnits(5);
            mCreditLoad = mCalculator.calculateCreditLoad(5, mGradeEquivalent);
            mTotalCreditLoad = mCalculator.calculateTotalCreditLoad(mCreditLoad);
            mResult = mCalculator.calculateGP(mTotalCreditLoad, mTotalCreditUnit);

            Intent calculationActivityIntent = new Intent(CalculationActivity.this, ResultActivity.class);
            calculationActivityIntent.putExtra(Intent.EXTRA_TEXT, mResult);
            startActivity(calculationActivityIntent);
        });
        //when the user clicks on the previous button
        mPreviousButton.setOnClickListener(view -> {

        });
        mNextCourseButton.setOnClickListener(view -> {
            mCourseCode = mCourseChoice.getText().toString();
            mGrade = Integer.parseInt(mCourseGrade.getText().toString());
            checkGradeEquivalent(mGrade);
        });

    }

    private int checkGradeEquivalent(int grade) {
        if (grade >= 75) {
            mGradeEquivalent = 5;
        }
        if (grade > 59 && grade < 69) {
            mGradeEquivalent = 4;
        }
        if (grade > 49 && grade < 59) {
            mGradeEquivalent = 3;
        }
        if (grade > 39 && grade <= 49) {
            mGradeEquivalent = 2;
        } else if (grade <= 39) {
            mGradeEquivalent = 0;
        }
        return mGradeEquivalent;
    }

}