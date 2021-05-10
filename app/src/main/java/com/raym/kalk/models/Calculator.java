package com.raym.kalk.models;

public class Calculator {
    int mCreditUnit;
    int mGradeValue;
    float mResult;
    int mCreditLoad;
    int mTotalCreditUnits;
    int mTotalCreditLoad;

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
