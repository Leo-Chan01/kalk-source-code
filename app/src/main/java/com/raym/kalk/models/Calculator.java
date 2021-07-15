package com.raym.kalk.models;

/***Created by Leo*/

public class Calculator {
    int mCreditUnit = 0;
    int mGradeValue = 0;
    float mResult = 0;
    int mCreditLoad = 0;
    int mTotalCreditUnits = 0;
    int mTotalCreditLoad = 0;

    public int calculateTotalCreditUnits(int creditUnit) {
        mTotalCreditUnits += creditUnit;
        return mTotalCreditUnits;
    }

    public int calculateCreditLoad(int creditUnit, int gradeValue) {
        mCreditLoad = creditUnit * gradeValue;
        return mCreditLoad;
    }

    public int calculateTotalCreditLoad(int creditLoad) {
        mTotalCreditLoad += creditLoad;
        return mTotalCreditLoad;
    }

    public float calculateGP(int totalCreditLoad, int totalCreditUnits) {
        mResult = (float) totalCreditLoad / totalCreditUnits;
        return mResult;
    }
}
