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
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.hostel.dao.UserDAO;
import com.hostel.dao.DropdownDAO;
import com.hostel.model.User;
import com.hostel.model.Util;
import java.security.NoSuchAlgorithmException;
 
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "create.jsp";
    private static String LIST_USER = "list.jsp";
    private UserDAO Userdao;
    private DropdownDAO Dropdowndao;
 
    public UserController() {
        super();
        Userdao = new UserDAO();
        Dropdowndao = new DropdownDAO();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        String id = request.getParameter("userId");
        
//        HttpSession session = request.getSession(false);
//        if(session == null){
//            forward = "/login.jsp";
//        }
//        if(session.getAttribute("user") == null){
//            forward = "/login.jsp";
//        }
//        else{
            if (action.equalsIgnoreCase("edit")){
                forward = INSERT_OR_EDIT;
                byte[] strNum = Util.Base64Decode(id);
                String userId = new String(strNum);
                User user = Userdao.getUserById(userId);
                request.setAttribute("listRole", Dropdowndao.getAllRole());
                request.setAttribute("student", user);
            } else if (action.equalsIgnoreCase("listUser")){
                forward = LIST_USER;
                request.setAttribute("users", Userdao.getAllUsers());
            } else {
                request.setAttribute("listRole", Dropdowndao.getAllRole());
                forward = INSERT_OR_EDIT;
            }
        //}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        String alert = "";
        User user = new User();
        String id = request.getParameter("actionPost");
        
        if(id.equalsIgnoreCase("delete")){
            user.setUserID(Integer.parseInt(request.getParameter("user_id")));
            Userdao.deleteUser(user.getUserID());
            //request.setAttribute("users", Userdao.getAllUsers());
            alert = "alert-success";
            message = "Record has been successfully removed";
            //request.setAttribute("message", "Record has been successfully removed");
            //request.getRequestDispatcher("/views/student/list.jsp").forward(request, response);
        }else{
            try{
                user.setName(request.getParameter("name"));
                user.setUsername(request.getParameter("username"));
                user.setPassword(Util.HashPassword(request.getParameter("password")));
                user.setRole(Integer.parseInt(request.getParameter("role")));

                if (id.equalsIgnoreCase("add")){
                    if(Userdao.isExist(user) == true){
                        request.setAttribute("message", "Record already exist");
                    }else{
                        Userdao.addUser(user);
                        //request.setAttribute("users", Userdao.getAllUsers());
                        alert = "alert-success";
                        message = "Record successfully saved";
                        //request.setAttribute("message","Record successfully saved");
//                        request.getRequestDispatcher("/views/student/list.jsp").forward(request, response);
                    }
                }
                else{
                    Userdao.updateUser(user);
                    alert="alert-success";
                }
            }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();                
            }
        }
        
        request.setAttribute("alert",alert);
        request.setAttribute("message",message);
        request.setAttribute("users", Userdao.getAllUsers());
        request.getRequestDispatcher("/views/student/list.jsp").forward(request, response);
        

        
//        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//        request.setAttribute("users", Userdao.getAllUsers());
//        view.forward(request, response);

        //RequestDispatcher view = request.getRequestDispatcher(forward);
        //view.forward(request, response);
        
    }
}
