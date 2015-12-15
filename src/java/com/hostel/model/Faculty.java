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
public class Faculty {
    private int _facultyID;
    private String _facultyName;

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

    /**
     * @return the _facultyName
     */
    public String getFacultyName() {
        return _facultyName;
    }

    /**
     * @param _facultyName the _facultyName to set
     */
    public void setFacultyName(String _facultyName) {
        this._facultyName = _facultyName;
    }
}
