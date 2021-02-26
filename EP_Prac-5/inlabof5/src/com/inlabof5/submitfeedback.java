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

import com.inlabof5.dao.SubmitfeedbackDao;

@WebServlet("/submitfeedback")
public class submitfeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubmitfeedbackDao submitfeedbackDao;
	
	public void init() {
		submitfeedbackDao = new SubmitfeedbackDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    String mail = (String) session.getAttribute("useremail");
		String feedback = request.getParameter("feedback");
		
		try {
			if(submitfeedbackDao.submit(mail, feedback)) {
				out.print("<h1>Your feedback submitted succesfully</h1> <br> You can submit again to change your feedback");
		    	RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");  
		        rd.include(request, response);
			} else {
				out.print("Sorry, Try again");
		    	RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");  
		        rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
