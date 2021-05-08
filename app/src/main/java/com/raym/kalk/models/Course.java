package com.raym.kalk.models;

import android.os.Parcel;
import android.os.Parcelable;

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
    private String courseCode;
    private int creditUnit;
    private Course singleCourse;

    public Course(String courseCode, int creditUnit) {
        this.courseCode = courseCode;
        this.creditUnit = creditUnit;
    }

    protected Course(Parcel in) {
        courseCode = in.readString();
        creditUnit = in.readInt();
        singleCourse = in.readParcelable(Course.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(courseCode);
        parcel.writeInt(creditUnit);
        parcel.writeParcelable(singleCourse, i);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }

    public Course getSingleCourse() {
        return singleCourse;
    }

    public void setSingleCourse(Course singleCourse) {
        this.singleCourse = singleCourse;
    }

}
