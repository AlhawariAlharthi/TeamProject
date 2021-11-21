package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.UtilDB;;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = request.getParameter("AUTHOR");
		String title = request.getParameter("TITLE");
		String iSBN = request.getParameter("ISBN");
		String major = request.getParameter("MAJOR");
		String bookClass = request.getParameter("CLASS");
		
		HttpSession session = request.getSession();
		String uploader = session.getAttribute("username").toString();
		
		UtilDB.createBooks(title, author, iSBN, uploader, major, bookClass);
		
		
	}

}
