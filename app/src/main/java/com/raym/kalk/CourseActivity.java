package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.raym.kalk.models.Course;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {

    private final ArrayList<Course> mCourseArrayList = new ArrayList<>();
    private EditText mCourseCodeEditText;
    private EditText mCreditUnitEditText;
    private Button mCalculateGpButton;
    private Button mAddCourseButton;
    private Course mSingleCourse;
    private String mCourseCode;
    private int mCreditUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_course);

        mCourseCodeEditText = findViewById(R.id.editTxt_course_code);
        mCreditUnitEditText = findViewById(R.id.editTxt_credit_unit);
        mCalculateGpButton = findViewById(R.id.calculate_gp);
        mAddCourseButton = findViewById(R.id.button_add_course);

        mCalculateGpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent courseActivityIntent = new Intent(CourseActivity.this, CalculationActivity.class);
                startActivity(courseActivityIntent);
            }
        });

        mAddCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCourseCode = mCourseCodeEditText.getText().toString();
                mCourseCodeEditText.clearComposingText();
                mCreditUnit = Integer.parseInt(mCreditUnitEditText.getText().toString());
                mCreditUnitEditText.clearComposingText();
                mSingleCourse = new Course(mCourseCode, mCreditUnit);
                if (mCourseCode == "") {
                    Toast.makeText(CourseActivity.this, "INVALID REQUEST", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(CourseActivity.this, "ADDED", Toast.LENGTH_LONG).show();
            }
        });
    }
}