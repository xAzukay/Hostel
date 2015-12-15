/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.dao;

import com.hostel.model.Student;
import com.hostel.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shukor.saharuni
 */
public class StudentDAO {
    
    private Connection connection;
 
    public StudentDAO() {
        connection = DBUtil.getConnection();
    }
    
    public void addStudent(Student student) {
        try {
            String query = "INSERT INTO student(Name,N_Matric,NRIC,Address, "
                    + "ID_Gender, Email,N_Mobile, Session_Year, ID_Courses, D_Apply, ID_Status, "
                    + "ID_Building,  Cancel_Remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            // Parameters start with 1
            ps.setString(1, student.getName());
            ps.setString(2, student.getMatric());
            ps.setString(3, student.getIc());  
            ps.setString(4, student.getAddress());
            ps.setInt(5, student.getGenderID()); 
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getMobile());
            ps.setString(8, student.getSessionYear());
            ps.setInt(9, student.getCoursesID()); 
            ps.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
            ps.setInt(11, 1); 
            ps.setInt(12, student.getBuildingID());
            ps.setString(13, student.getRemark());
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<Student>();
        try {
            Statement statement = connection.createStatement();
            String sql="SELECT a.ID_Student, a.Name, a.N_Matric, a.NRIC, b.Gender_Desc, a.D_Apply, "
                    + "c.Status_Name, d.Building_Name FROM student a "
                    + "LEFT JOIN gender b ON a.ID_Gender=b.ID_Gender "
                    + "LEFT JOIN statuses c ON a.ID_Status=c.ID_Status "
                    + "LEFT JOIN building d ON a.ID_Building=d.ID_Building";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("ID_Student"));
                student.setName(rs.getString("Name"));
                student.setMatric(rs.getString("N_Matric"));
                student.setIc(rs.getString("NRIC"));
                student.setGenderName(rs.getString("Gender_Desc"));
                student.setCreated(rs.getDate("D_Apply"));
                student.setStatusName(rs.getString("Status_Name"));
                student.setBuildingName(rs.getString("Building_Name"));
                listStudent.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listStudent;
    }
    
    public Student getStudentById(String studentId) {
        Student student = new Student();
        try {
            String sql="SELECT a.ID_Student, a.Name, a.N_Matric, a.NRIC,a.Address,a.Email, "
                    + "b.Gender_Desc, a.D_Apply, a.N_Mobile, a.Session_Year, e.Courses_Name, "
                    + "d.Building_Name,f.Faculty_Name,a.ID_Building,a.Cancel_Remark,g.Status_Name FROM student a "
                    + "LEFT JOIN gender b ON a.ID_Gender=b.ID_Gender "
                    + "LEFT JOIN building d ON a.ID_Building=d.ID_Building "
                    + "LEFT JOIN courses e ON a.ID_Courses=e.ID_Courses "
                    + "LEFT JOIN faculty f ON e.ID_Faculty=f.ID_Faculty "
                    + "LEFT JOIN statuses g ON a.ID_Status=g.ID_Status "
                    + "WHERE N_Matric=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                student.setStudentID(rs.getInt("ID_Student"));
                student.setName(rs.getString("Name"));
                student.setMatric(rs.getString("N_Matric"));
                student.setIc(rs.getString("NRIC"));
                student.setGenderName(rs.getString("Gender_Desc"));
                student.setCreated(rs.getDate("D_Apply"));
                student.setBuildingName(rs.getString("Building_Name"));
                student.setFacultyName(rs.getString("Faculty_Name"));
                student.setCoursesName(rs.getString("Courses_Name"));
                student.setAddress(rs.getString("Address"));
                student.setEmail(rs.getString("Email"));
                student.setSessionYear(rs.getString("Session_Year"));
                student.setMobile(rs.getString("N_Mobile"));
                student.setBuildingID(rs.getInt("ID_Building"));
                student.setRemark(rs.getString("Cancel_Remark"));
                student.setStatusName(rs.getString("Status_Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return student;
    }
    
    public void updateStudent(Student student) {
        try {
            String sql="UPDATE student SET ID_Status=?, ID_Room=?, Cancel_Remark=?, ID_User=? "
                    + "WHERE N_Matric=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getStatusID());
            preparedStatement.setInt(2, student.getRoomID());
            preparedStatement.setString(3, student.getRemark());
            preparedStatement.setInt(4, student.getUserID());
            preparedStatement.setString(5, student.getMatric());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
