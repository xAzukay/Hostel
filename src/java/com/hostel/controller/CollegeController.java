/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.controller;

//import com.google.gson.Gson;
import com.hostel.dao.DropdownDAO;
import com.hostel.dao.CollegeDAO;
import com.hostel.model.College;
import com.hostel.model.Util;
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
public class CollegeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String VIEWS = "create.jsp";
    private static String LIST_COLLEGE = "list.jsp";
    private CollegeDAO Collegedao;
    private DropdownDAO Dropdowndao;
 
    public CollegeController() {
        super();
        Collegedao = new CollegeDAO();
        Dropdowndao = new DropdownDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        String id = request.getParameter("collegeId");
        
            if (action.equalsIgnoreCase("edit")){
                forward = VIEWS;
                byte[] strNum = Util.Base64Decode(id);
                String studentId = new String(strNum);
                //College collge = Collegedao.getAllCollege(studentId);
                
                //request.setAttribute("result", student);
            } else if (action.equalsIgnoreCase("listCollege")){
                forward = LIST_COLLEGE;
                request.setAttribute("college", Collegedao.getAllCollege());
            } else {
                request.setAttribute("college", Collegedao.getAllCollege());
                forward = LIST_COLLEGE;
            }
        //}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        String alert = "";
        Student student = new Student();
        //String id = request.getParameter("actionPost");
        
        //String studentid = request.getParameter("user_id");
        //byte[] strNum = Util.Base64Decode(studentid);
        //String sid = new String(strNum);
                
        student.setStatusID(Integer.parseInt(request.getParameter("status")));
        student.setRoomID(Integer.parseInt(request.getParameter("room")));
        student.setRemark(request.getParameter("remark"));
        student.setUserID(Integer.parseInt(request.getParameter("user_id")));
        student.setMatric(request.getParameter("student_id"));
        Studentdao.updateStudent(student);
        alert = "alert-success";
        message = "Record has been successfully updated";
        
        request.setAttribute("alert",alert);
        request.setAttribute("message",message);
        request.setAttribute("students", Studentdao.getAllStudent());
        request.getRequestDispatcher("/views/student/list.jsp").forward(request, response);
        

        
//        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//        request.setAttribute("users", Userdao.getAllUsers());
//        view.forward(request, response);

        //RequestDispatcher view = request.getRequestDispatcher(forward);
        //view.forward(request, response);
        
    }*/
}

