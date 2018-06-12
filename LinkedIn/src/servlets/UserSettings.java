package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;
import jpautils.PasswordAuthentication;
import model.User;

/**
 * Servlet implementation class UserSettings
 */
@WebServlet("/UserSettings")
public class UserSettings extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl();
		HttpSession session = request.getSession();
		String action;
		String redirect = "/user_settings.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			action = (String) request.getParameter("action");
			System.out.println(action);
			
			User user = dao.find(Long.parseLong(userID));
			
			if( action.equals("changePassword") ) {
				
	        	String currentPassword = request.getParameter("currentPassword");
	        	String newPassword = request.getParameter("newPassword");
	        	String confirmPassword = request.getParameter("confirmPassword");
	        	
	        	System.out.println("Given: " + currentPassword + " " + newPassword + " " + confirmPassword );
	        	
	        	PasswordAuthentication pa = new PasswordAuthentication();
	        	
	        	if (pa.authenticate(currentPassword, user.getPasswordHashed())) {
	        		System.out.println("Given: " + currentPassword + " " + newPassword + " " + confirmPassword );
	        		if (newPassword.equals(confirmPassword)) {
	        			System.out.println("Given: " + currentPassword + " " + newPassword + " " + confirmPassword );
	        			String passwordHashed = pa.hash(newPassword);
	        			System.out.println(passwordHashed);
	        			dao.changePassword(userID, passwordHashed);
	        		}
	        		else {
						redirect = "/user_settings";
						session.setAttribute("errorMsg", "passwords do not match");
	        		}
	        	}
				else {
					redirect = "/user_settings";
					session.setAttribute("errorMsg", "wrong password");
				}
	        	
			}
			else if( action.equals("changeEmail") ) {
				
				String newEmail = request.getParameter("newEmail");
				
	        	dao.changeEmail(userID, newEmail);
	        	
	        	System.out.println("Given: " + userID + " " + newEmail );
			}	
			
			redirect = "/user_settings.jsp";
		}
		else {
			redirect = "/start_page.jsp";
			session.setAttribute("errorMsg", "no authorization");
		}

		request.getRequestDispatcher(redirect).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
