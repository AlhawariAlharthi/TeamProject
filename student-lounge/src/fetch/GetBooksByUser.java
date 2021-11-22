package fetch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.Book;
import datamodel.User;
import util.UtilDB;

/**
 * Servlet implementation class GetBooksByUser
 */
@WebServlet("/GetBooksByUser")
public class GetBooksByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBooksByUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String emailS = session.getAttribute("email").toString();
		User user = UtilDB.getUsers(emailS, "email").get(0);
		List<Book> listbooks = null;
		if(user.isAdmin())
		{
			listbooks = UtilDB.listBooks();
		}
		else
		{
			listbooks = UtilDB.listUserBooks(user.getEmail());
		}
		
		
		for (int i = 0; i < listbooks.size(); i+= 2) {
out.append( String.format("<div class=\"row\">\r\n" + 
		"		<div class=\"column\">\r\n" + 
		"			<div class=\"card\">\r\n" + 
		"				<div class=\"card-horizontal\">\r\n" + 
		"					<div class=\"\">\r\n" + 
		"						<img class=\"bookimg\" src=\"phone3.jpg\" alt=\"\"\r\n" + 
		"							style=\"border-radius: 10px;\">\r\n" + 
		"					</div>\r\n" + 
		"					<div class=\"card-body\">\r\n" + 
		"						<h4 class=\"card-title\">%s</h4>\r\n" + 
		"						<p class=\"card-text\">\r\n" + 
		"							<b>Auther:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>ISBN:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Major:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Class:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Owner:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Contact info:</b> %s\r\n" +
		"						</p>\r\n" + 
		"						<a class=\"btn btn-primary btn-rounded btn-sm my-0\"\r\n" + 
		"						data-toggle=\"modal\" data-target=\"#EditModal\" onclick=\"getBook(%d)\">Edit Book</a> "+
		"						<a class=\"btn btn-danger btn-rounded btn-sm my-0\"\r\n" + 
		"					    onclick=\"deleteBook(%d)\">Delete</a> "+
		"						</p>\r\n" + 
		"					</div>\r\n" + 
		"				</div>\r\n" + 
		"			</div>\r\n" + 
		"		</div>\r\n", listbooks.get(i).getTitle(), listbooks.get(i).getAuthor(), listbooks.get(i).getISBN(),
		listbooks.get(i).getMajor(), listbooks.get(i).getBookClass(), UtilDB.getUsers(listbooks.get(i).getUploader(), "email").get(0).getUserName(), listbooks.get(i).getUploader(), listbooks.get(i).getId(), listbooks.get(i).getId()));
		if (i + 1 >= listbooks.size())
		{
			break;
		}
		
out.append( String.format(
		"		<div class=\"column\">\r\n" + 
		"			<div class=\"card\">\r\n" + 
		"				<div class=\"card-horizontal\">\r\n" + 
		"					<div class=\"\">\r\n" + 
		"						<img class=\"bookimg\" src=\"phone3.jpg\" alt=\"\"\r\n" + 
		"							style=\"border-radius: 10px;\">\r\n" + 
		"					</div>\r\n" + 
		"					<div class=\"card-body\">\r\n" + 
		"						<h4 class=\"card-title\">%s</h4>\r\n" + 
		"						<p class=\"card-text\">\r\n" + 
		"							<b>Auther:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>ISBN:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Major:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Class:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Owner:</b> %s\r\n" + 
		"						</p>\r\n" + 
		"						<p>\r\n" + 
		"							<b>Contact info:</b> %s\r\n" +
		"						</p>\r\n" + 
		"						<a class=\"btn btn-primary btn-rounded btn-sm my-0\"\r\n" + 
		"						data-toggle=\"modal\" data-target=\"#EditModal\" onclick=\"getBook(%d)\">Edit Book</a> "+
		"						<a class=\"btn btn-danger btn-rounded btn-sm my-0\"\r\n" + 
		"						 onclick=\"deleteBook(%d)\">Delete</a> "+
		"						</p>\r\n" + 
		"					</div>\r\n" + 
		"				</div>\r\n" + 
		"			</div>\r\n" + 
		"		</div>\r\n" + 
		"	</div>"	,listbooks.get(i + 1).getTitle(), listbooks.get(i + 1).getAuthor(), listbooks.get(i + 1).getISBN(),
		listbooks.get(i + 1).getMajor(), listbooks.get(i + 1).getBookClass(), UtilDB.getUsers(listbooks.get(i + 1).getUploader(), "email").get(0).getUserName(), listbooks.get(i + 1).getUploader(), listbooks.get(i + 1).getId(), listbooks.get(i + 1).getId()));
	      }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
