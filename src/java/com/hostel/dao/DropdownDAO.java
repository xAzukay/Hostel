/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.dao;


import java.sql.*;
import java.util.*;
import com.hostel.model.Gender;
import com.hostel.model.Role;
import com.hostel.model.Faculty;
import com.hostel.model.Courses;
import com.hostel.model.College;
import com.hostel.model.Status;
import com.hostel.model.Room;
import com.hostel.util.DBUtil;
import java.io.Serializable;
/**
 *
 * @author shukor.saharuni
 */
public class DropdownDAO  implements Serializable{
    private Connection connection;
 
    public DropdownDAO() {
        connection = DBUtil.getConnection();
    }
    
    public List<Gender> getAllGender() {
        List<Gender> listGender = new ArrayList<Gender>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM gender");
            while (rs.next()) {
                Gender gender = new Gender();
                gender.setGenderID(rs.getInt("ID_Gender"));
                gender.setDescription(rs.getString("Gender_Desc"));
                listGender.add(gender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listGender;
    }
    
    public List<Role> getAllRole() {
        List<Role> listRole = new ArrayList<Role>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM role");
            while (rs.next()) {
                Role role = new Role();
                role.setRoleID(rs.getInt("ID_Role"));
                role.setName(rs.getString("Role_Name"));
                role.setDescription(rs.getString("Role_Desc"));
                listRole.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listRole;
    }
    
    public List<Faculty> getAllFaculty() {
        List<Faculty> listFaculty = new ArrayList<Faculty>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM faculty");
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setFacultyID(rs.getInt("ID_Faculty"));
                faculty.setFacultyName(rs.getString("Faculty_Name"));
                listFaculty.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listFaculty;
    }
    
    public List<Courses> getAllCourses(int id) {
        List<Courses> listCourses= new ArrayList<Courses>();
        try {
            //Statement statement = connection.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT * FROM courses WHERE ID_Faculty=?");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM courses WHERE ID_Faculty=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Courses courses = new Courses();
                courses.setCoursesID(rs.getInt("ID_Courses"));
                courses.setCoursesName(rs.getString("Courses_Name"));
                listCourses.add(courses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listCourses;
    }
    
    public List<College> getAllCollege(int id) {
        List<College> listCollege= new ArrayList<College>();
        try {
            //Statement statement = connection.createStatement();
            //ResultSet rs = statement.executeQuery("SELECT * FROM building WHERE Building_Status=1");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM building WHERE Building_Status=1 AND Building_Type=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                College college = new College();
                college.setCollegeID(rs.getInt("ID_Building"));
                college.setCollegeName(rs.getString("Building_Name"));
                listCollege.add(college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listCollege;
    }
    
    public List<Status> getAllStatus(String id) {
        List<Status> listStatus = new ArrayList<Status>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM statuses WHERE Status_For=? AND ID_Status !=1");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Status stats = new Status();
                stats.setStatusID(rs.getInt("ID_Status"));
                stats.setStatusName(rs.getString("Status_Name"));
                listStatus.add(stats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listStatus;
    }
    
    public List<Room> getAllRoom(int id,String level) {
        List<Room> listRoom = new ArrayList<Room>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE ID_Building=? AND Room_Status=1 AND Room_Level=?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, level);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Room faculty = new Room();
                faculty.setRoomID(rs.getInt("ID_Room"));
                faculty.setRoomName(rs.getString("Room_Name"));
                listRoom.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listRoom;
    }
}
