package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Connection users = null;
			try {
				users = DBConnection.openConnection();

				String id = request.getParameter("updateId");
				String name = request.getParameter("updateName");
				Statement state = users.createStatement();



				state.executeUpdate("UPDATE user_table SET name='" + name + "' WHERE id ='" + id + "'");
				DBConnection.closeConnection(users,state);
				response.sendRedirect("/select"); //UserSelectServletを呼び出す

		}catch(SQLException e){
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
