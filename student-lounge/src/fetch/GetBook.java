package fetch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Book;
import util.UtilDB;

/**
 * Servlet implementation class GetBook
 */
@WebServlet("/GetBook")
public class GetBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		Book book = UtilDB.getBookById(id);
		String output = String.format(
				
				"<div\r\n" + 
				"									style=\"padding-top: 50px; padding-right: 30px; padding-bottom: 50px; padding-left: 30px;\">\r\n" + 
				"									<form class=\"form-horizontal\" action=\"EditBook\" method=\"post\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"										<div class=\"form-group\">\r\n" + 
				"											<label for=\"Fname\">Author : </label> <input type=\"text\"\r\n" + 
				"												class=\"form-control\" name=\"AUTHOR\" value=\"%s\"> <br> <label\r\n" + 
				"												for=\"Lname\">Title : </label> <input type=\"text\"\r\n" + 
				"												class=\"form-control\" name=\"TITLE\" value=\"%s\"> <br> <label\r\n" + 
				"												for=\"JobRole\">ISBN : </label> <input type=\"text\"\r\n" + 
				"												class=\"form-control\" name=\"ISBN\" value=\"%s\"> <br> <label\r\n" + 
				"												for=\"Age\">Major : </label> <input type=\"text\"\r\n" + 
				"												class=\"form-control\" name=\"MAJOR\" value=\"%s\"> <br> <label\r\n" + 
				"												for=\"Age\">Book Class : </label> <input type=\"text\"\r\n" + 
				"												class=\"form-control\" name=\"CLASS\" value=\"%s\"> <br>\r\n" + 
				"\r\n" + 
				"											<button type=\"submit\" name=\"id\" value=\"%d\" \">Submit</button>\r\n" + 
				"										</div>\r\n" + 
				"									</form>\r\n" + 
				"									\r\n" + 
				"								</div>"
				
				, book.getAuthor(), book.getTitle(), book.getISBN(), book.getMajor(), book.getBookClass(), book.getId());
		response.getWriter().append(output);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
