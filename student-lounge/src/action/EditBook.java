package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDB;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String emailS = session.getAttribute("email").toString();
		
		
		String author = request.getParameter("AUTHOR");
		String title = request.getParameter("TITLE");
		String isbn = request.getParameter("ISBN");
		
		String major = request.getParameter("MAJOR");
		String bookClass = request.getParameter("CLASS");
		String id = request.getParameter("id");
		
		UtilDB.editBook("id", id, author, "AUTHOR");
		UtilDB.editBook("id", id, title, "TITLE");
		UtilDB.editBook("id", id, isbn, "ISBN");
		UtilDB.editBook("id", id, major, "MAJOR");
		UtilDB.editBook("id", id, bookClass, "BookClass");
		
		response.sendRedirect("profile.jsp");
	}

}
