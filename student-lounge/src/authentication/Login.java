package authentication;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.User;
import util.Hash;
import util.UtilDB;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		try {
			
			User user1 = UtilDB.getUsers(username, "email").get(0);

			if ( username.equals(user1.getEmail()) && Hash.hash(password).equals(user1.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("email", username);
				
				response.sendRedirect("profile.jsp");

			} 

			else {
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + "</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
