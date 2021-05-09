package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculationActivity extends AppCompatActivity {
    private Button mDoneButton;
    private Button mNextCourseButton;
    private Button mPreviousButton;
    private EditText mCourseGrade;
    private EditText mCourseChoice;

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
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculationActivityIntent = new Intent(CalculationActivity.this, ResultActivity.class);
                startActivity(calculationActivityIntent);
            }
        });

        //when the user clicks on the previous button
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCourseGrade.clearComposingText();
                mCourseGrade.clearComposingText();
            }
        });


    }
}