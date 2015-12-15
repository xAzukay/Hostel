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
public class Status {
    private int _statusID;
    private String _statusFor;
    private String _StatusName;

    /**
     * @return the _statusID
     */
    public int getStatusID() {
        return _statusID;
    }

    /**
     * @param _statusID the _statusID to set
     */
    public void setStatusID(int _statusID) {
        this._statusID = _statusID;
    }

    /**
     * @return the _statusFor
     */
    public String getStatusFor() {
        return _statusFor;
    }

    /**
     * @param _statusFor the _statusFor to set
     */
    public void setStatusFor(String _statusFor) {
        this._statusFor = _statusFor;
    }

    /**
     * @return the _StatusName
     */
    public String getStatusName() {
        return _StatusName;
    }

    /**
     * @param _StatusName the _StatusName to set
     */
    public void setStatusName(String _StatusName) {
        this._StatusName = _StatusName;
    }
}
