package com.raym.kalk.models;

import java.util.ArrayList;
import java.util.List;

/***Created by Leo*/

//this class just takes in the creditUnit and courseCode
public class KalkDataManager {

    private static KalkDataManager ourInstance = null;
    private Course mCourse;
    private List<Course> mCourseArrayList = new ArrayList<>();

    public KalkDataManager() {

    }

    public static KalkDataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new KalkDataManager();
        }
        return ourInstance;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public List<Course> getCourseArrayList() {
        return mCourseArrayList;
    }

    public void setCourseArrayList(List<Course> courseArrayList) {
        mCourseArrayList = courseArrayList;
    }
}
