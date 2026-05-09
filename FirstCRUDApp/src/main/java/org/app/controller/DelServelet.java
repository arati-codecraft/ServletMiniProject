package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.app.service.DeptService;
import org.app.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deldept")
public class DelServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");   // corrected

		PrintWriter out = response.getWriter();

		int deptId = Integer.parseInt(request.getParameter("did"));

		DeptService deptService = new DeptServiceImpl();
		boolean result = deptService.isDeleteDept(deptId);

		if (result) {
			response.sendRedirect("viewdept");
		} else {
			out.println("<h2>Delete Failed</h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}