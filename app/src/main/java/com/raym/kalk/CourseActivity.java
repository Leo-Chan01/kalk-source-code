package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.raym.kalk.models.Course;
import com.raym.kalk.models.KalkDataManager;

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
    private final ArrayList<Course> mCoursesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_course);

        mCourseCodeEditText = findViewById(R.id.editTxt_course_code);
        mCreditUnitEditText = findViewById(R.id.editTxt_credit_unit);
        mCalculateGpButton = findViewById(R.id.calculate_gp);
        mAddCourseButton = findViewById(R.id.button_add_course);

        mCalculateGpButton.setOnClickListener(view -> {
            Intent courseActivityIntent = new Intent(CourseActivity.this, CalculationActivity.class);
            startActivity(courseActivityIntent);
        });

        mAddCourseButton.setOnClickListener(view -> {
            if (mCourseCode.equals(null) || mCourseCode.equals("")) {
                Toast.makeText(CourseActivity.this, "NO DATA!!", Toast.LENGTH_SHORT).show();
            } else {
                mCourseCode = mCourseCodeEditText.getText().toString();
                String courseCode = mCourseCode.toUpperCase();
                mCourseCodeEditText.clearComposingText();
                mCourseCodeEditText.setText(null);
                mCreditUnit = Integer.parseInt(mCreditUnitEditText.getText().toString());
                mCreditUnitEditText.clearComposingText();
                mCreditUnitEditText.setText(null);

                mSingleCourse = new Course(courseCode, mCreditUnit);

                mCoursesArrayList.add(mSingleCourse);

                KalkDataManager.getInstance().setCourseArrayList(mCourseArrayList);

                Toast.makeText(CourseActivity.this, "ADDED", Toast.LENGTH_LONG).show();
            }
        });
    }
}