package com.raym.kalk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/***Created by Leo*/

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView noticeGradeResult = findViewById(R.id.notice_grade_result);
        TextView gradeResult = findViewById(R.id.grade_result);

        Intent calculationActivityIntent = getIntent();
        String finalResult = calculationActivityIntent.getStringExtra(Intent.EXTRA_TEXT);
        gradeResult.setText(finalResult);
    }
}