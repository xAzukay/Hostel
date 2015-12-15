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
public class Gender {
    private int _genderID;
    private String _description;

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
     * @return the _description
     */
    public String getDescription() {
        return _description;
    }

    /**
     * @param _description the _description to set
     */
    public void setDescription(String _description) {
        this._description = _description;
    }
}
