package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

			if (username.equals("a@a.a") && password.equals("a")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> You are in!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
				rd.forward(request, response);

			} else if (username.equals("")) {
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> Please Enter Username!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
				rd.forward(request, response);

			} else if (password.equals("")) {
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> Please Enter Password!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
				rd.forward(request, response);

			} else {
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  <strong>Warning!</strong> You entered wrong credetionals!.\r\n" + "</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		}

	}

}
