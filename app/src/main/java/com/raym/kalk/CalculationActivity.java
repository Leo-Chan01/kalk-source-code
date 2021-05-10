package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.raym.kalk.models.Calculator;
import com.raym.kalk.models.KalkDataManager;

public class CalculationActivity extends AppCompatActivity {
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
    private int mCreditUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Button doneButton = findViewById(R.id.done_button);
        Button previousButton = findViewById(R.id.previous_course_button);
        Button nextCourseButton = findViewById(R.id.next_course_button);
        mCourseChoice = findViewById(R.id.edit_text_course_choice);
        mCourseGrade = findViewById(R.id.edit_text_grade);

        nextCourseButton.setOnClickListener(view -> {

            mCourseCode = mCourseChoice.getText().toString();
            mCourseChoice.clearFocus();
            mGrade = Integer.parseInt(mCourseGrade.getText().toString());
            mCourseChoice.clearFocus();
            mGradeEquivalent = checkGradeEquivalent(mGrade);
            //we need to get the credit unit from the list of courses in our KalkDataManager class
            KalkDataManager kalkDataManager = new KalkDataManager();
            mCreditUnit = kalkDataManager.getCourse().getCreditUnit();
            //TODO: Code to Check the inputed course with the data in the kalk dataManager here
            //TODO: Get the credit Unit if the typed course is in accordance with what is in the database
            mTotalCreditUnit = mCalculator.calculateTotalCreditUnits(mCreditUnit);

            mCreditLoad = mCalculator.calculateCreditLoad(mCreditUnit, mGradeEquivalent);
            mTotalCreditLoad = mCalculator.calculateTotalCreditLoad(mCreditLoad);
        });

        //when the user clicks on the previous button
        previousButton.setOnClickListener(view -> Toast.makeText(this, "Nothing to do yet", Toast.LENGTH_SHORT).show());

        //when the user clicks on the done button
        doneButton.setOnClickListener(view -> {
            mResult = mCalculator.calculateGP(mTotalCreditLoad, mTotalCreditUnit);

            Intent calculationActivityIntent = new Intent(CalculationActivity.this, ResultActivity.class);
            calculationActivityIntent.putExtra(Intent.EXTRA_TEXT, mResult);
            startActivity(calculationActivityIntent);
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