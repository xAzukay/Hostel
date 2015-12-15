/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hostel.controller;

/**
 *
 * @author shukor.saharuni
 */
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hostel.model.Util;
import com.hostel.model.Student;
import com.hostel.dao.StudentDAO;
import com.hostel.dao.DropdownDAO;

public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String VIEWS = "view.jsp";
    private static String LIST_STUDENT = "list.jsp";
    private StudentDAO Studentdao;
    private DropdownDAO Dropdowndao;
 
    public StudentController() {
        super();
        Studentdao = new StudentDAO();
        Dropdowndao = new DropdownDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        String id = request.getParameter("studentId");
        
            if (action.equalsIgnoreCase("edit")){
                forward = VIEWS;
                byte[] strNum = Util.Base64Decode(id);
                String studentId = new String(strNum);
                Student student = Studentdao.getStudentById(studentId);
                
                //int room = Integer.parseInt(request.getParameter("room"));
                if(request.getParameter("room") != null){
                    int room = Integer.parseInt(request.getParameter("room"));
                    String level = request.getParameter("level");
                   String json = new Gson().toJson(Dropdowndao.getAllRoom(room,level));
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    response.getWriter().flush();
                    response.getWriter().close(); 
                }
                                
                request.setAttribute("listStatus", Dropdowndao.getAllStatus("ApplicationForm"));
                request.setAttribute("result", student);
            } else if (action.equalsIgnoreCase("listStudent")){
                forward = LIST_STUDENT;
                request.setAttribute("students", Studentdao.getAllStudent());
            } else {
                request.setAttribute("listRole", Dropdowndao.getAllRole());
                forward = VIEWS;
            }
        //}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
    }
}
