/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.dao;

import java.sql.*;
import com.hostel.util.DBUtil;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author shukor.saharuni
 */
public class RoleDAO extends SimpleTagSupport {
    private Connection connection;
    
    public RoleDAO() {
        connection = DBUtil.getConnection();
    }

    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
         
        try {
            // connect to database
            PreparedStatement ps = connection.prepareStatement("SELECT ID_Role, Role_Name From Role ORDER BY Role_Name");
            ResultSet rs = ps.executeQuery();
            String output = "<select name=uid>";
            output +="<option value=''>" + "-- SELECT --" + "</option>";
            while (rs.next()) {
                output += "<option value=" + rs.getString("ID_Role") + ">" + rs.getString("Role_Name") + "</option>";
            }
            output += "</select>";
            out.println(output);
 
        } catch (Exception ex) {
            throw new JspException("Error in UsersHandler tag", ex);
        }
    }
}
