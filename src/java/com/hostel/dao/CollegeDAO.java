/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.dao;

import com.hostel.model.College;
import com.hostel.util.DBUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shukor.saharuni
 */
public class CollegeDAO {
    private Connection connection;
 
    public CollegeDAO() {
        connection = DBUtil.getConnection();
    }
    
    public List<College> getAllCollege() {
        List<College> listCollege = new ArrayList<College>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM building");
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
}
