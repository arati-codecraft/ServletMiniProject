package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateController
 */
@WebServlet("/updatecontrl")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text.html");
		PrintWriter out =response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		int deptId=Integer.parseInt(request.getParameter("did"));
		String deptName=request.getParameter("dname");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container m-5 bg-dark p-5'/>");
		out.println("<div class='form-group p-2'>"); 
		out.println("<input type='hidden' name='id' value='"+deptId+"' placeholder='deptId' class='form-control' />");
		out.println("</div>"); 
		out.println("<div class='form-group p-2'>"); 
		out.println("<input type='text' name='name' value='"+deptName+"' placeholder='dept name' class='form-control' />"); 
		out.println("</div>");
		out.println("<div class='form-group p-2'>"); 
		out.println("<input type='submit' name='s' value='Update Dept' class='form-control' />"); 
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String button=request.getParameter("s");
		if(button!=null)
		{
			int did=Integer.parseInt(request.getParameter("id"));
			String dname=request.getParameter("name");
			DeptModel model=new DeptModel();
			model.setId(did);
			model.setName(dname);
			DeptService deptService=new DeptServiceImpl();
			boolean result=deptService.isUpdateDept(model);
			if(result)
			{
				response.sendRedirect("viewdept");
			}
			else
			{
				out.println("<h1>Some problem is there</h1>");
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
