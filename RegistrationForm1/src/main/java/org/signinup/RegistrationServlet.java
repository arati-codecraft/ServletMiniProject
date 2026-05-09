package org.signinup;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/registrationservlet")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       
        if (!password.equals(confirmPassword)) {
            out.println("<h3 style='color:red'>Passwords do not match!</h3>");
            return;
        }
        
        Connection con = null;
        PreparedStatement ps = null;
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/LoginRegisterApplication", "root", "AratiSQL@8");

           
            String query = "INSERT INTO users(fullname,email,mobile,username,password) VALUES(?,?,?,?,?)";

            ps = con.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, username);
            ps.setString(5, password);

            int i = ps.executeUpdate();

            if (i > 0) 
            {
                out.println("<h2 style='color:green;text-align:center;'>Registration Successful!</h2>");
                out.println("<div style='text-align:center;'><a href='login.html'>Go to Login</a></div>");
//                RequestDispatcher r=request.getRequestDispatcher("login.html"); 
//                r.forward(request, response);
            } 
            else 
            {
                out.println("<h2 style='color:red;text-align:center;'>Registration Failed</h2>");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            out.println("<h3 style='color:red;'>Username already exists!</h3>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.html");
    }
}