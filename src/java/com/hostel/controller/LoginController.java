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

//import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.hostel.dao.UserDAO;
import com.hostel.model.User;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet{
    private UserDAO dao;
    
    public LoginController() {
        super();
        dao = new UserDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UnsupportedEncodingException {
        
        String action=request.getParameter("loginPage");
        if(action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(true);   
            session.invalidate();
            request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
        }else{
        
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            user.setUsername(userName); 
            user.setPassword(password);

            String userValidate = dao.authenticateUser(user);

            if(userValidate.equals("SUCCESS")) 
            {
                //request.setAttribute("user", dao.getUserById(userName));
                HttpSession session = request.getSession();
                session.setAttribute("user", dao.getUserById(userName));
                request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
            }
             else
            {
                request.setAttribute("errMessage", userValidate); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
                request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);//forwarding the request
            }
        }
    }
    
}
