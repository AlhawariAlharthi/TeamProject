package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
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
		//processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//processRequest(request, response);
	}

}
