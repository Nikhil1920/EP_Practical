package com.inlabof5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inlabof5.dao.LoginDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao;
	
	public void init() {
		loginDao = new LoginDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    try {
	    	
	    
	    if(loginDao.check(email, password)) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("useremail", email);
	    	if(loginDao.submitted(email)) {
	    		response.sendRedirect("submitted.jsp");
	    	} else {
	    	response.sendRedirect("welcome.jsp");
	    	}
	    	} else {
	    	out.print("Sorry, username or password error!");
	    	RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);
	    }
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
