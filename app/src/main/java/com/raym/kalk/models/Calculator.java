package com.raym.kalk.models;

public class Calculator {
    int mCreditUnit;
    int mGradeValue;
    float mResult;
    int mCreditLoad;
    int mTotalCreditUnits;
    private int mTotalCreditLoad;

    int calculateTotalCreditUnits(int creditUnit) {
        mTotalCreditUnits += creditUnit;
        return mTotalCreditUnits;
    }

    int calculateCreditLoad(int creditUnit, int gradeValue) {
        mCreditLoad = creditUnit * gradeValue;
        return mCreditLoad;
    }

    int calculateTotalCreditLoad(int creditLoad) {
        mTotalCreditLoad += creditLoad;
        return mTotalCreditLoad;
    }

    float calculateGP(int totalCreditLoad, int totalCreditUnits) {
        mResult = (float) totalCreditLoad / totalCreditUnits;
        return mResult;
    }
}
