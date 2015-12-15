/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.model;

/**
 *
 * @author shukor.saharuni
 */
public class Courses {
    private int coursesID;
    private String coursesName;
    private int _facultyID;

    /**
     * @return the coursesID
     */
    public int getCoursesID() {
        return coursesID;
    }

    /**
     * @param coursesID the coursesID to set
     */
    public void setCoursesID(int coursesID) {
        this.coursesID = coursesID;
    }

    /**
     * @return the coursesName
     */
    public String getCoursesName() {
        return coursesName;
    }

    /**
     * @param coursesName the coursesName to set
     */
    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    /**
     * @return the _facultyID
     */
    public int getFacultyID() {
        return _facultyID;
    }

    /**
     * @param _facultyID the _facultyID to set
     */
    public void setFacultyID(int _facultyID) {
        this._facultyID = _facultyID;
    }
}
