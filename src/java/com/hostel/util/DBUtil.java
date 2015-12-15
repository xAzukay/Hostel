/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.util;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBUtil {
 
    public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosteldb","root","");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}
