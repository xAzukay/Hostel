/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.controller;

import com.google.gson.Gson;
import com.hostel.dao.DropdownDAO;
import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shukor.saharuni
 */
public class ApplicationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String VIEW_INDEX = "index.jsp";
    private DropdownDAO Dropdowndao;
    private StudentDAO StudentDAO;
 
    public ApplicationController() {
        super();
        Dropdowndao = new DropdownDAO();
        StudentDAO = new StudentDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        
        request.setAttribute("listGender", Dropdowndao.getAllGender());
        //request.setAttribute("listCollege", Dropdowndao.getAllCollege());
        //request.setAttribute("listCourses", Dropdowndao.getAllCourses());
        request.setAttribute("listFaculty", Dropdowndao.getAllFaculty());
        
        if(request.getParameter("type") != null){
            int type = Integer.parseInt(request.getParameter("type"));
        //Map<String, String> options = Dropdowndao.getAllCollege(type);
            String json = new Gson().toJson(Dropdowndao.getAllCollege(type));
            response.setContentType("application/json");
            //response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        }
        
        if(request.getParameter("kos") != null){
            int type = Integer.parseInt(request.getParameter("kos"));
            String json = new Gson().toJson(Dropdowndao.getAllCourses(type));
            response.setContentType("application/json");
            //response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        }
        
        
        forward = VIEW_INDEX;

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setName(request.getParameter("fullname"));
        student.setMatric(request.getParameter("matricno"));
        student.setIc(request.getParameter("icno"));
        student.setAddress(request.getParameter("address"));
        student.setGenderID(Integer.parseInt(request.getParameter("gender")));
        student.setEmail(request.getParameter("email"));
        student.setMobile(request.getParameter("mobileno"));
        student.setSessionYear(request.getParameter("sessionyear"));
        student.setCoursesID(Integer.parseInt(request.getParameter("courses")));
        student.setBuildingID(Integer.parseInt(request.getParameter("college")));
        
        StudentDAO.addStudent(student);
        request.setAttribute("message", "Your form successfully submitted and pending for review");
        request.setAttribute("alert", "alert-success");
        request.getRequestDispatcher("/views/form/index.jsp").forward(request, response);
        //String name = request.getParameter("fullname");
        //String matric = request.getParameter("matricno"); 
        //String ic = request.getParameter("icno"); 
        //String address = request.getParameter("address");
        //int genderid = Integer.parseInt(request.getParameter("gender")); 
        //String email = request.getParameter("email"); 
        //String mobile = request.getParameter("mobileno");
        //String sessionYear = request.getParameter("sessionyear");
        //int coursesid = Integer.parseInt(request.getParameter("courses"));
        //int buildingid = Integer.parseInt(request.getParameter("college"));
    
        //User user = new User();
        //user.setUsername(userName); 
        //user.setPassword(password);

        //String userValidate = dao.authenticateUser(user);

        //if(userValidate.equals("SUCCESS")) 
        //{
            //request.setAttribute("user", dao.getUserById(userName));
        //    HttpSession session = request.getSession();
       //     session.setAttribute("user", dao.getUserById(userName));
        //    request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
        //}
         //else
        //{
        //    request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
         //   request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);//forwarding the request
        //}
    }
}
