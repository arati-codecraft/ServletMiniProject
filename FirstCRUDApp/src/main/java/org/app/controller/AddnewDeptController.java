package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddnewDeptController
 */
@WebServlet("/addept")
public class AddnewDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddnewDeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		out.println("<form name='frm' action='' method='POST'>");
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response); 
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container mt-5 bg-dark p-5'>");
		out.println("<div class='form-group'>");
		out.println("<div><input type='text' name='name' value='' class='form-control mt-2'/>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<div><input type='submit' name='s' value='Add New Dept' class='form-control mt-2'/>");
		out.println("</div>");
		out.println("</form>");
		String btnValue=request.getParameter("s"); 
		if(!Optional.ofNullable(btnValue).isEmpty()) 
		{	
	   String deptName=request.getParameter("name");
		DeptModel model = new DeptModel(); 
		model.setName(deptName); 
		DeptService deptService=new DeptServiceImpl(); 
		boolean result=deptService.isAddNewDept(model); 
		if(result) { out.println("<h1 class='text-white'>New Dept Added</h1>"); 
		}
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
