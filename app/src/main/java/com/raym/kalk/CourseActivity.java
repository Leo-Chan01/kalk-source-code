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

/***Created by Leo*/

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
    static String EMPTY = "";

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
            //get the course code and credit unit from the user and convert them to a string and
            //and int respectively assign them to their respective variables and clear their fields
            /*for course code*/
            mCourseCode = mCourseCodeEditText.getText().toString();
            String courseCode = mCourseCode.toUpperCase();
            mCourseCodeEditText.setText(EMPTY);
            /*for credit unit*/
            mCreditUnit = Integer.parseInt(mCreditUnitEditText.getText().toString());
            int cu = mCreditUnit;
            mCreditUnitEditText.setText(EMPTY);

            //pass it to the single object of the Course class
            mSingleCourse = new Course(courseCode, cu);

            //set those variables into our course class
            mSingleCourse.setCourseCode(courseCode);
            mSingleCourse.setCreditUnit(cu);

            //finally add that single set course in our arraylist of courses
            mCoursesArrayList.add(mSingleCourse);

            //pass that list to our data manager
            KalkDataManager.getInstance().setCourseArrayList(mCoursesArrayList);

            //when done display a success toast
            Toast.makeText(CourseActivity.this, "ADDED", Toast.LENGTH_LONG).show();
        });
    }
}