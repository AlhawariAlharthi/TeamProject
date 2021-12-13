package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Hash;
import util.UtilDB;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String fname = request.getParameter("firtsname");
		String lname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		if (password.equals(repassword)) {
			password = Hash.hash(password);
			
			
			if( UtilDB.getUsers(email, "email").isEmpty() &&
					UtilDB.getUsers(userName, "userName").isEmpty())
			{
				UtilDB.createUser(email, userName, fname, lname, password, false);
				response.sendRedirect("login.jsp");
			}
			else
			{
				// user is existed error
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  This user/email is already existed!.\r\n" + "</div>";
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			// password error
			// user is existed error
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  Passwords dose not match!.\r\n" + "</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
	
	}


