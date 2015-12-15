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
public class Role {
    private int _roleID;
    private String _name;
    private String _description;

    /**
     * @return the _roleID
     */
    public int getRoleID() {
        return _roleID;
    }

    /**
     * @param _roleID the _roleID to set
     */
    public void setRoleID(int _roleID) {
        this._roleID = _roleID;
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
