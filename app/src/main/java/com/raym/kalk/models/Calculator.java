package com.raym.kalk.models;

public class Calculator {
    int mCreditUnit;
    int mGradeValue;
    float mResult;
    int mCreditLoad;
    int mTotalCreditUnits;


    int calculateCreditLoad(int creditUnit, int gradeValue) {
        mCreditLoad = creditUnit * gradeValue;
        return mCreditLoad;
    }

    float calculateGP(int totalCreditLoad, int totalCreditUnits) {
        mResult = (float) totalCreditLoad / totalCreditUnits;
        return mResult;
    }
}
