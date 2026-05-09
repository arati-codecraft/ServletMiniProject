package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.app.model.DeptModel;
import org.app.service.DeptService;
import org.app.service.DeptServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ViewDeptController
 */
@WebServlet("/viewdept")
public class ViewDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count =1;
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		
		out.println("<br>");
		out.println("<div class='container '>");  
		out.println("<table class='table table-striped'>"); 
		out.println("<tr>");
		out.println("<th>SRNO</th>");
		out.println("<th>DEPTNAME</th>");
		out.println("<th><a href=''>DELETE</a></th>");
		out.println("<th><a href=''>UPDATE</a></th>");  
		out.println("</tr>"); 
		
		DeptService deptService=new DeptServiceImpl();
		Optional<List<DeptModel>> o=deptService.getAllDepts();
		if(o.isPresent())
			
		for (DeptModel data : o.get()) {
		    out.println("<tr>");
		    out.println("<td>" + (count++) + "</td>");
		    out.println("<td>" + data.getName() + "</td>");
		    out.println("<td><a href='deldept?did=" + data.getId() + "'>DELETE</a></td>");		   
		    out.println("<td><a href='updatecontrl?did="+data.getId()+"&dname="+data.getName()+"'>UPDATE</a></td>");
		    out.println("</tr>");
		}
		if(count == 1) 
		{
			out.println("<tr><td colspan='4'>DATA NOT FOUND IN TABLE</td></tr>");  
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
