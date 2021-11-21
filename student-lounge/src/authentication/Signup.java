package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String password = hash(request.getParameter("password"));
		String cpassword = request.getParameter("repassword");
		
		PrintWriter out = response.getWriter();
		
		out.append(userName + " " + password + " " + cpassword + " " + email + " " + " " + fname + " " + lname);
		
		UtilDB.createUser(email, userName, fname, lname, password, false);
	}
	
	public static String hash(String str) {
		 String passwordToHash = str;
		    String generatedPassword = null;

		    try 
		    {
		      // Create MessageDigest instance for MD5
		      MessageDigest md = MessageDigest.getInstance("MD5");

		      // Add password bytes to digest
		      md.update(passwordToHash.getBytes());

		      // Get the hash's bytes
		      byte[] bytes = md.digest();

		      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
		      StringBuilder sb = new StringBuilder();
		      for (int i = 0; i < bytes.length; i++) {
		        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		      }

		      // Get complete hashed password in hex format
		      generatedPassword = sb.toString();
		    } catch (NoSuchAlgorithmException e) {
		      e.printStackTrace();
		    }
		    return(generatedPassword);
		  }
	}


