/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.controller;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shukor.saharuni
 */
public class CheckController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String VIEW_INDEX = "check.jsp";
    private StudentDAO Studentdao;
 
    public CheckController() {
        super();
        Studentdao = new StudentDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        
        //request.setAttribute("listGender", Dropdowndao.getAllGender());
        //request.setAttribute("listFaculty", Dropdowndao.getAllFaculty());
        
        forward = VIEW_INDEX;

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("matric");
        
        Student student = Studentdao.getStudentById(action);
        
        String alert = "alert-success";
        
        request.setAttribute("alert",alert);
        request.setAttribute("message","Your status is "+student.getStatusName());
        request.setAttribute("students", student);
        request.getRequestDispatcher("/views/form/check.jsp").forward(request, response);
    }
}

