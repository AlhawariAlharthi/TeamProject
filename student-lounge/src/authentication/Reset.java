package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;

import datamodel.User;
import util.Hash;
import util.UtilDB;

import java.util.Properties;
import java.util.Random;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class Reset
 */
@WebServlet("/Reset")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reset() {
		super();
		// TODO Auto-generated constructor stub
	}

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//
//		final String err = "/error.jsp";
//		final String succ = "/success.jsp";
//
//		String from = "studentloungeproject@gmail.com";
//		String to = "alharrsiali@gmail.com";
//		String subject = "test";
//		String message = "test";
//		String login = "studentloungeproject@gmail.com";
//		String password = "XXXXXX";
//
//		try {
//			Properties props = new Properties();
//			props.setProperty("mail.host", "smtp.gmail.com");
//			props.setProperty("mail.smtp.port", "465");
//			props.setProperty("mail.smtp.auth", "true");
//			props.setProperty("mail.smtp.ssl.enable", "true");
//
//			Authenticator auth = new SMTPAuthenticator(login, password);
//
//			Session session = Session.getInstance(props, auth);
//
//			MimeMessage msg = new MimeMessage(session);
//			msg.setText(message);
//			msg.setSubject(subject);
//			msg.setFrom(new InternetAddress(from));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			Transport.send(msg);
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher(succ);
//			dispatcher.forward(request, response);
//
//		} catch (AuthenticationFailedException ex) {
//			request.setAttribute("ErrorMessage", "Authentication failed");
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
//			dispatcher.forward(request, response);
//
//		} catch (AddressException ex) {
//			request.setAttribute("ErrorMessage", "Wrong email address");
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
//			dispatcher.forward(request, response);
//
//		} catch (MessagingException ex) {
//			request.setAttribute("ErrorMessage", ex.getMessage());
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher(err);
//			dispatcher.forward(request, response);
//		}
//		
//
//	}
//
//	private class SMTPAuthenticator extends Authenticator {
//
//		private PasswordAuthentication authentication;
//
//		public SMTPAuthenticator(String login, String password) {
//			authentication = new PasswordAuthentication(login, password);
//		}
//
//		protected PasswordAuthentication getPasswordAuthentication() {
//			return authentication;
//		}
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//processRequest(request, response);
		
		String email = request.getParameter("email");
		
		try
		{
			User user = UtilDB.getUsers(email, "email").get(0);
			
			if (user != null)
			{
				String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
				String specialCharacters = "!@#$";
				String numbers = "1234567890";
				String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
				Random random = new Random();
				int length = 20;
				char[] password = new char[length];

				password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
				password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
				password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
				password[3] = numbers.charAt(random.nextInt(numbers.length()));

				for (int i = 4; i < length; i++) {
					password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
				}
				
				UtilDB.editUser(email, Hash.hash(password.toString()), "password");

				MailjetClient client;
				MailjetRequest requestt;
				MailjetResponse responset = null;
				client = new MailjetClient("e2fc74790fb07fbece050767a3fae8eb", "185878afcdd3dfbc4050319fd5ddeaca",
						new ClientOptions("v3.1"));
				requestt = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES,
						new JSONArray().put(new JSONObject()
								.put(Emailv31.Message.FROM,
										new JSONObject().put("Email", "qsx560560@gmail.com").put("Name", "Student-Lounge-Team"))
								.put(Emailv31.Message.TO,
										new JSONArray()
												.put(new JSONObject().put("Email", email).put("Name", user.getFirstName() + " " + user.getLastName())))
								.put(Emailv31.Message.SUBJECT, "Student-Lounge Password reset.")
								.put(Emailv31.Message.TEXTPART, "Password rest email")
								.put(Emailv31.Message.HTMLPART,
										String.format("<h1>Welcome %s</h1> <br> <h3>Here is your temporary password: %s</h3>", user.getFirstName() + " " + user.getLastName(), password.toString()))
								.put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
				try {
					responset = client.post(requestt);
				} catch (MailjetException | MailjetSocketTimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(responset.getStatus());
				System.out.println(responset.getData());
				
				
				if (responset.getStatus() == 200)
				{
					String wronginput = "A temporary password was sent to your email, check your spam if you did not see anything.";
					request.setAttribute("wronginput", wronginput);
					RequestDispatcher rd = request.getRequestDispatcher("reset.jsp");
					rd.forward(request, response);
				}
				else
				{
					String wronginput = "<div class=\"alert alert-warning\">\r\n"
							+ "  <strong>Warning!</strong> The email was not sent an error occured!.\r\n" + "</div>";
					
					request.setAttribute("wronginput", wronginput);
					RequestDispatcher rd = request.getRequestDispatcher("reset.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				String wronginput = "<div class=\"alert alert-warning\">\r\n"
						+ "  <strong>Warning!</strong> The email dose not exist!.\r\n" + "</div>";
				
				request.setAttribute("wronginput", wronginput);
				RequestDispatcher rd = request.getRequestDispatcher("reset.jsp");
				rd.forward(request, response);
			}
		}
		catch (IndexOutOfBoundsException ie)
		{
			String wronginput = "<div class=\"alert alert-warning\">\r\n"
					+ "  <strong>Warning!</strong> The email dose not exist!.\r\n" + "</div>";
			
			request.setAttribute("wronginput", wronginput);
			RequestDispatcher rd = request.getRequestDispatcher("reset.jsp");
			rd.forward(request, response);
		}
		
	}

}
