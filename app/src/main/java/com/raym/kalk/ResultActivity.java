package com.raym.kalk;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView mNoticeGradeResult;
    private TextView mGradeResult;
    private int mFinalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mNoticeGradeResult = findViewById(R.id.notice_grade_result);
        mGradeResult = findViewById(R.id.grade_result);

        mFinalResult = getResultFromCalculationActivity();
        displayResult();
    }

    private int getResultFromCalculationActivity() {
        return 0;
    }

    private void displayResult() {

    }
}