package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Hash;
import util.UtilDB;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get session
		HttpSession session = request.getSession();
		String emailS = session.getAttribute("email").toString();
		
		
		String confirm = request.getParameter("confirm");
		String password = request.getParameter("pass");
		String changePassword = request.getParameter("changePassword");
		
		String email = request.getParameter("email");
		String changeEmail = request.getParameter("changeEmail");
		
		String username = request.getParameter("username");
		String changeUserName = request.getParameter("changeUserName");
		
		if ( changePassword != null && confirm.equals(password))
		{
			
			UtilDB.editUser(emailS, Hash.hash(password), "password");
			response.sendRedirect("profile.jsp");
		}
		
		
		
		if ( changeEmail != null && UtilDB.getUsers(email, "email").isEmpty()) 
		{
			
			UtilDB.editBook("uploader", emailS,  email, "uploader");
			UtilDB.editUser(emailS, email, "email");
			
			session.setAttribute("email", email);
			
			response.sendRedirect("profile.jsp");
		}
		else if ( changeEmail != null  )
		{
			// user is existed error
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  This user/email is already existed!.\r\n" + "</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
		
		if ( changeUserName != null  && UtilDB.getUsers(username, "userName").isEmpty())
		{
			UtilDB.editUser(emailS, username, "userName");
			response.sendRedirect("profile.jsp");
		}
		else if ( changeUserName != null )
		{
			// user is existed error
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  This user/email is already existed!.\r\n" + "</div>";
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
