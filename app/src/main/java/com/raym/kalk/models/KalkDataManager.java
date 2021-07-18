package com.raym.kalk.models;

import java.util.ArrayList;
import java.util.List;

/***Created by Leo*/

//this is the class that Holds and Accesses all the information about a course. takes care of the list
// of courses, and does the Honours of managing this data, Courses can be added, deleted and edited
//through this class.

public class KalkDataManager {
    private static KalkDataManager ourInstance = null;
    private Course mCourse;
    private List<Course> mCourseArrayList = new ArrayList<>();

    public KalkDataManager() {

    }

    //singleton construction
    public static KalkDataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new KalkDataManager();
        }
        return ourInstance;
    }

    public int getLastCoursePosition(List<Course> courses) {
        return courses.size() - 1;
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
