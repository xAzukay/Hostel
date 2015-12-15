/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.model;

import java.util.Date;

/**
 *
 * @author shukor.saharuni
 */
public class Student {
    private int _studentID;
    private String _name;
    private String _matric; 
    private String _ic; 
    private String _address;
    private int _genderID; 
    private String _email; 
    private String _mobile;
    private String _sessionYear;
    private int coursesID;
    private Date _created;
    private int statusID; 
    private int buildingID; 
    private int roomID; 
    private String _remark; 
    private int userID;
    
    //join table
    private String _statusName;
    private String _genderName;
    private String _buildingName;
    private String _coursesName;
    private String _facultyName;

    /**
     * @return the _studentID
     */
    public int getStudentID() {
        return _studentID;
    }

    /**
     * @param _studentID the _studentID to set
     */
    public void setStudentID(int _studentID) {
        this._studentID = _studentID;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void setName(String _name) {
        this._name = _name;
    }

    /**
     * @return the _matric
     */
    public String getMatric() {
        return _matric;
    }

    /**
     * @param _matric the _matric to set
     */
    public void setMatric(String _matric) {
        this._matric = _matric;
    }

    /**
     * @return the _ic
     */
    public String getIc() {
        return _ic;
    }

    /**
     * @param _ic the _ic to set
     */
    public void setIc(String _ic) {
        this._ic = _ic;
    }

    /**
     * @return the _address
     */
    public String getAddress() {
        return _address;
    }

    /**
     * @param _address the _address to set
     */
    public void setAddress(String _address) {
        this._address = _address;
    }

    /**
     * @return the _genderID
     */
    public int getGenderID() {
        return _genderID;
    }

    /**
     * @param _genderID the _genderID to set
     */
    public void setGenderID(int _genderID) {
        this._genderID = _genderID;
    }

    /**
     * @return the _email
     */
    public String getEmail() {
        return _email;
    }

    /**
     * @param _email the _email to set
     */
    public void setEmail(String _email) {
        this._email = _email;
    }

    /**
     * @return the _mobile
     */
    public String getMobile() {
        return _mobile;
    }

    /**
     * @param _mobile the _mobile to set
     */
    public void setMobile(String _mobile) {
        this._mobile = _mobile;
    }

    /**
     * @return the _sessionYear
     */
    public String getSessionYear() {
        return _sessionYear;
    }

    /**
     * @param _sessionYear the _sessionYear to set
     */
    public void setSessionYear(String _sessionYear) {
        this._sessionYear = _sessionYear;
    }

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
     * @return the _created
     */
    public Date getCreated() {
        return _created;
    }

    /**
     * @param _created the _created to set
     */
    public void setCreated(Date _created) {
        this._created = _created;
    }

    /**
     * @return the ststusID
     */
    public int getStatusID() {
        return statusID;
    }

    /**
     * @param ststusID the ststusID to set
     */
    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    /**
     * @return the buildingID
     */
    public int getBuildingID() {
        return buildingID;
    }

    /**
     * @param buildingID the buildingID to set
     */
    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    /**
     * @return the roomID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @param roomID the roomID to set
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @return the _remark
     */
    public String getRemark() {
        return _remark;
    }

    /**
     * @param _remark the _remark to set
     */
    public void setRemark(String _remark) {
        this._remark = _remark;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the _statusName
     */
    public String getStatusName() {
        return _statusName;
    }

    /**
     * @param _statusName the _statusName to set
     */
    public void setStatusName(String _statusName) {
        this._statusName = _statusName;
    }

    /**
     * @return the _genderName
     */
    public String getGenderName() {
        return _genderName;
    }

    /**
     * @param _genderName the _genderName to set
     */
    public void setGenderName(String _genderName) {
        this._genderName = _genderName;
    }

    /**
     * @return the _buildingName
     */
    public String getBuildingName() {
        return _buildingName;
    }

    /**
     * @param _buildingName the _buildingName to set
     */
    public void setBuildingName(String _buildingName) {
        this._buildingName = _buildingName;
    }

    /**
     * @return the _coursesName
     */
    public String getCoursesName() {
        return _coursesName;
    }

    /**
     * @param _coursesName the _coursesName to set
     */
    public void setCoursesName(String _coursesName) {
        this._coursesName = _coursesName;
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
