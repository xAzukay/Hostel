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
public class Room {
    private int _roomID;
    private String _roomName;

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
     * @return the _roomName
     */
    public String getRoomName() {
        return _roomName;
    }

    /**
     * @param _roomName the _roomName to set
     */
    public void setRoomName(String _roomName) {
        this._roomName = _roomName;
    }
}
