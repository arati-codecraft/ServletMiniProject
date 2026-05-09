package org.register;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class Registrationform
 */
@WebServlet("/registrationform")
public class Registrationform extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Registrationform() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        String[] skillsArr = request.getParameterValues("skills");

        // Convert skills array to string
        String skills = "";
        if (skillsArr != null) {
            skills = String.join(",", skillsArr);
        }

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/aug2025",
                "root",
                "AratiSQL@8"
            );

            // Insert query
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password,gender,skills) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setString(5, skills);

            int i = ps.executeUpdate();

          

            if (i > 0) {
                out.println("<h2>Data Saved Successfully ✅</h2>");
            } else {
                out.println("<h2>Error saving data ❌</h2>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
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
