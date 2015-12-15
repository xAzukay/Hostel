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
public class College {
    private int _collegeID;
    private String _collegeName;
    private int _status;
    private int _roomID;
    private int _type;

    /**
     * @return the _id
     */
    public int getCollegeID() {
        return _collegeID;
    }

    /**
     * @param _collegeID the _id to set
     */
    public void setCollegeID(int _collegeID) {
        this._collegeID = _collegeID;
    }

    /**
     * @return the _name
     */
    public String getCollegeName() {
        return _collegeName;
    }

    /**
     * @param _name the _name to set
     */
    public void setCollegeName(String _collegeName) {
        this._collegeName = _collegeName;
    }

    /**
     * @return the _status
     */
    public int getStatus() {
        return _status;
    }

    /**
     * @param _status the _status to set
     */
    public void setStatus(int _status) {
        this._status = _status;
    }

    /**
     * @return the _roomID
     */
    public int getRoomID() {
        return _roomID;
    }

    /**
     * @param _roomID the _roomID to set
     */
    public void setRoomID(int _roomID) {
        this._roomID = _roomID;
    }

    /**
     * @return the _type
     */
    public int getType() {
        return _type;
    }

    /**
     * @param _type the _type to set
     */
    public void setType(int _type) {
        this._type = _type;
    }
}
