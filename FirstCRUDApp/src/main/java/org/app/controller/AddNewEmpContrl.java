package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.app.model.DeptModel;
import org.app.model.EmployeeModel;
import org.app.service.EmployeeService;
import org.app.service.EmployeeServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewEmpContrl
 */
@WebServlet("/addemp")
public class AddNewEmpContrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmpContrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher r = request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		EmployeeService empService=new EmployeeServiceImpl();
        
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<div class='container bg-dark m-2 p-3'>");
		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='name' value='' placeholder='empname' class='form-control' />");
		out.println("</div>");

		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='email' value='' placeholder='email' class='form-control' />");
		out.println("</div>");

		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='contact' value='' placeholder='contact' class='form-control' />");
		out.println("</div>");

		out.println("<div class='form-group m-1'>");
		out.println("<input type='text' name='salary' value='' placeholder='salary' class='form-control' />");
		out.println("</div>");

		List<DeptModel> deptList=empService.getDeptForEmployee();
		
		out.println("<div class='form-group m-1'>");
		out.println("<select name='dept' class='form-control'>");
		out.println("<option>Select Department</option>");
		for(DeptModel model:deptList)
		{
			out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("</div>");

		out.println("<div class='form-group m-1'>");
		out.println("<input type='submit' name='s' value='Add new Employee' class='form-control' />");
		out.println("</div>");

		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String empName=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			int salary=Integer.parseInt(request.getParameter("salary"));
			int deptId = Integer.parseInt(request.getParameter("dept").trim());

			EmployeeModel model=new EmployeeModel(0,empName,email,contact,salary,deptId);
			boolean b=empService.isAddEmployee(model);
			if(b)
			{
				out.println("<h1>New employee added sucesfully</h1>");
			}
			else
			{
				out.println("<h1>New employee not added</h1>");

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
