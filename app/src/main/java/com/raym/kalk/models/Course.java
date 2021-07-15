package com.raym.kalk.models;

import android.os.Parcel;
import android.os.Parcelable;

/***Created by Leo*/

public class Course implements Parcelable {

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };
    private String mCourseCode;
    private int mCreditUnit;

    public Course(String courseCode, int creditUnit) {
        this.mCourseCode = courseCode;
        this.mCreditUnit = creditUnit;
    }

    protected Course(Parcel in) {
        mCourseCode = in.readString();
        mCreditUnit = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mCourseCode);
        parcel.writeInt(mCreditUnit);
    }

    public String getCourseCode() {
        return mCourseCode;
    }

    public void setCourseCode(String courseCode) {
        this.mCourseCode = courseCode;
    }

    public int getCreditUnit() {
        return mCreditUnit;
    }

    public void setCreditUnit(int creditUnit) {
        this.mCreditUnit = creditUnit;
    }
}
