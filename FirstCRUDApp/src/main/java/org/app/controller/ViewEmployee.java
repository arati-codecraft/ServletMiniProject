package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.app.service.EmployeeService;
import org.app.service.EmployeeServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/viewemp")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		EmployeeService empService=new EmployeeServiceImpl();
		out.println("<div class='container p-5 m-5'>"); 
		out.println("<table class='table table-striped'>"); 
		out.println("<tr><th>SrNo</th><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>SAL</th><th>DEPT</th><th>DELETE</th><th>UPDATE</th></tr>");
		List<Object[]> list=empService.getEmployeeWithDept();
		int count=0;
		for(Object obj[]:list)
		{   ++count;
		out.println("<tr>"
		        + "<td>"+count+"</td>"
		        + "<td>"+obj[1]+"</td>"
		        + "<td>"+obj[2]+"</td>"
		        + "<td>"+obj[3]+"</td>"
		        + "<td>"+obj[4]+"</td>"
		        + "<td>"+obj[5]+"</td>"

		        + "<td><a href='delemp?eid="+obj[0]+"'>DELETE</a></td>"

+ "<td><a href='updateemp?eid="+obj[0]
+"&ename="+obj[1]+"'>UPDATE</a></td>"

		        + "</tr>");       
		}
		out.println("</table>"); 
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
