package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.raym.kalk.models.Course;
import com.raym.kalk.models.KalkDataManager;

import java.util.List;

public class CalculationActivity extends AppCompatActivity {
    private Spinner mCourseListSpinner;
    private Button mDoneButton;
    private Button mNextCourseButton;
    private Button mPreviousButton;
    private EditText mCourseGrade;
    private EditText mCourseChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        mCourseListSpinner = findViewById(R.id.course_choice_spinner);
        mDoneButton = findViewById(R.id.done_button);
        mPreviousButton = findViewById(R.id.previous_course_button);
        mNextCourseButton = findViewById(R.id.next_course_button);

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

        //this is the activation action for the spinner to list the items in the list of Courses
        List<Course> courses = KalkDataManager.getInstance().getCourseArrayList();
        ArrayAdapter<Course> adapterCourses = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourseListSpinner.setAdapter(adapterCourses);
    }
}