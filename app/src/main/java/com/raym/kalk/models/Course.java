package com.raym.kalk.models;

public class Course {

    private String courseCode;
    private int creditUnit;

    public Course(String courseCode, int creditUnit) {
        this.courseCode = courseCode;
        this.creditUnit = creditUnit;
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

}
