package com.inlabof5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inlabof5.dao.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    
	    String fname = request.getParameter("firstname");
	    String lname = request.getParameter("lastname");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    try {
	    	
	    RegisterDao registerDao = new RegisterDao();
	    if(registerDao.register(fname, lname, email, password)) {
	    	out.print("Registeration Succesful Please login");
	    	RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);
	    } else {
	    	out.print("Sorry, Wrong details please try again");
	    	RequestDispatcher rd=request.getRequestDispatcher("/signup.html");  
	        rd.include(request, response);
	    }
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
