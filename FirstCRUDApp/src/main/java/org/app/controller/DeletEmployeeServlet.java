package org.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.app.service.EmployeeService;
import org.app.service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delemp")
public class DeletEmployeeServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int empId = Integer.parseInt(
                request.getParameter("eid"));

        EmployeeService empService =
                new EmployeeServiceImpl();

        boolean result =
                empService.isDeleteEmployee(empId);

        if(result)
        {
            response.sendRedirect("viewemp");
        }
        else
        {
            out.println("<h2>Delete Failed</h2>");
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request,response);
    }
}