/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.dao;

import java.sql.*;
import java.util.*;
import com.hostel.model.User;
import com.hostel.util.DBUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class UserDAO {
 
    private Connection connection;
 
    public UserDAO() {
        connection = DBUtil.getConnection();
    }
 
//    public void checkUser(User user) {
//        try {
//            PreparedStatement ps = connection.prepareStatement("SELECT Name FROM user WHERE N_Matric = ?");
//            ps.setString(1, user.getMatric());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) // found
//            {
//                //updateUser(user);
//            } else {
//                addUser(user);
//            }
//        } catch (Exception ex) {
//            System.out.println("Error in check() -->" + ex.getMessage());
//        } 
//    }
    public void addUser(User user) {
        try {
            String query = "INSERT INTO user(Name, Username, Password,D_Created,ID_Role) values (?,?, ?, ?, ? )";
            PreparedStatement ps = connection.prepareStatement(query);
            // Parameters start with 1
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());            
            ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            ps.setInt(5, user.getRole());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteUser(Integer userId) {
        try {
            String query="DELETE FROM user WHERE ID_User=?";
            PreparedStatement ps = connection.prepareStatement(query);
            // Parameters start with 1
            ps.setInt(1, userId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateUser(User user) {
        try {
            String sql="UPDATE user SET password=?, email=?, registeredon=?"
                    + "where uname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Parameters start with 1
            //System.out.println(new java.sql.Date(user.getRegisteredon().getTime()));
            //preparedStatement.setString(1, user.getIc());
            //preparedStatement.setString(2, user.getMatric());
            //preparedStatement.setDate(3, new java.sql.Date(user.getRegisteredon().getTime()));
            //preparedStatement.setString(4, user.getUname());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<User> getAllUsers() {
        List<User> listUser = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            String sql="SELECT a.ID_User,a.Username,a.Name,c.Role_Name,a.D_Created "
                    + "FROM user as a "
                    + "LEFT JOIN Role as c ON a.ID_Role=c.ID_Role";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("ID_User"));
                user.setName(rs.getString("Name"));
                user.setUsername(rs.getString("Username"));
                user.setCreated(rs.getDate("D_Created"));
                user.setRoleName(rs.getString("Role_Name"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return listUser;
    }
 
    public User getUserById(String userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE Username=?");
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
                user.setUserID(rs.getInt("ID_User"));
                user.setName(rs.getString("Name"));
                user.setUsername(rs.getString("Username"));
                user.setRole(rs.getInt("ID_Role"));
                user.setCreated(rs.getDate("D_Created"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return user;
    }
    
    public String authenticateUser(User user) 
    {

    //String userName = user.getMatric(); 
    //String password = user.getIc();

    try{
        //String sql = "SELECT N_Matric, NRIC FROM user";
        String sql = "SELECT * FROM user WHERE Username=? AND Password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] hash = md.digest(user.getPassword().getBytes());
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < hash.length; i++){
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        ps.setString(2, sb.toString());
        ResultSet rs = ps.executeQuery();

    while(rs.next()) 
    {
     //String userNameDB = rs.getString("N_Matric"); 
     //String passwordDB = rs.getString("NRIC");

      //if(userName.equals(userNameDB) && password.equals(passwordDB))
      //{
      //   return "SUCCESS"; 
      //}
        return "SUCCESS";
    }
    }
    catch(SQLException e)
    {
    e.printStackTrace();
    }
    catch(NoSuchAlgorithmException e)
    {
    e.printStackTrace();
    }
    return "Invalid user credentials"; // Just returning appropriate message otherwise
    }
    
    
    public boolean isExist(User user)
    {

    try{
        String query = "SELECT Name FROM user WHERE ID_User = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, user.getUserID());
        ResultSet rs = ps.executeQuery();

        while(rs.next()) // Until next row is present otherwise it return false
        {
         return true;
        }
    }
    catch(SQLException e)
    {
    e.printStackTrace();
    }
    return false; // Just returning appropriate message otherwise
    }
}