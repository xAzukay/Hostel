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
public class User {
    private int _userID;
    private String _name;
    private Date _created;
    private int _gender;
    private int _role;
    private String _password;
    private String _username;

    //listing
    private String _genderDesc;
    private String _roleName;
    /**
     * @return the _userID
     */
    public int getUserID() {
        return _userID;
    }

    /**
     * @param _userID the _userID to set
     */
    public void setUserID(int _userID) {
        this._userID = _userID;
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
     * @return the _created
     */
    public Date getCreated() {
        return _created;
    }

    /**
     * @param _created the _registered to set
     */
    public void setCreated(Date _created) {
        this._created = _created;
    }

    /**
     * @return the _gender
     */
    public int getGender() {
        return _gender;
    }

    /**
     * @param _gender the _gender to set
     */
    public void setGender(int _gender) {
        this._gender = _gender;
    }

    /**
     * @return the _role
     */
    public int getRole() {
        return _role;
    }

    /**
     * @param _role the _role to set
     */
    public void setRole(int _role) {
        this._role = _role;
    }

    /**
     * @return the _genderDesc
     */
    public String getGenderDesc() {
        return _genderDesc;
    }

    /**
     * @param _genderDesc the _genderDesc to set
     */
    public void setGenderDesc(String _genderDesc) {
        this._genderDesc = _genderDesc;
    }

    /**
     * @return the _roleName
     */
    public String getRoleName() {
        return _roleName;
    }

    /**
     * @param _roleName the _roleName to set
     */
    public void setRoleName(String _roleName) {
        this._roleName = _roleName;
    }

    /**
     * @return the _password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * @param _password the _password to set
     */
    public void setPassword(String _password) {
        this._password = _password;
    }

    /**
     * @return the _username
     */
    public String getUsername() {
        return _username;
    }

    /**
     * @param _username the _username to set
     */
    public void setUsername(String _username) {
        this._username = _username;
    }
}
