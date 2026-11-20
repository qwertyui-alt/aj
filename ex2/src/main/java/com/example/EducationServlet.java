package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.*;
import java.io.PrintWriter;

/**
 * Servlet implementation class EducationServlet
 */
@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		session.setAttribute("degree", request.getParameter("degree"));
		session.setAttribute("university", request.getParameter("university"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("Name: " + session.getAttribute("name") + "<br>");
		out.println("Age: " + session.getAttribute("age") + "<br>");
		out.println("Phone: " + session.getAttribute("phone") + "<br>");
		out.println("Email: " + session.getAttribute("email") + "<br>");
		out.println("Degree: " + session.getAttribute("degree") + "<br>");
		out.println("University: " + session.getAttribute("university") + "<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
