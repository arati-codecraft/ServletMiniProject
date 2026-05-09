package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.app.model.EmployeeModel;
import org.app.service.EmployeeService;
import org.app.service.EmployeeServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateemp")
public class UpdateEmployeeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	// SHOW UPDATE FORM
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		RequestDispatcher r =
				request.getRequestDispatcher("dashboard.html");

		r.include(request, response);

		int id = Integer.parseInt(
				request.getParameter("eid"));

		String name =
				request.getParameter("ename");

		out.println("<div class='container p-5'>");

		out.println("<h2>Update Employee</h2>");

		out.println("<form action='updateemp' method='post'>");

		out.println("<input type='hidden' name='eid' value='"+id+"'>");

		out.println("<div class='mb-3'>");

		out.println("<input type='text' "
				+ "name='ename' "
				+ "value='"+name+"' "
				+ "class='form-control'>");

		out.println("</div>");

		out.println("<input type='submit' "
				+ "value='Update Employee' "
				+ "class='btn btn-primary'>");

		out.println("</form>");

		out.println("</div>");
	}

	// UPDATE DATABASE
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(
				request.getParameter("eid"));

		String name =
				request.getParameter("ename");

		EmployeeModel model =
				new EmployeeModel();

		model.setId(id);
		model.setName(name);

		EmployeeService empService =
				new EmployeeServiceImpl();

		boolean b =
				empService.isUpdateEmployee(model);

		if(b)
		{
			response.sendRedirect("viewemp");
		}
		else
		{
			out.println("<h2>Update Failed</h2>");
		}
	}
}