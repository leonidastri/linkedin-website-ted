package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSettings
 */
@WebServlet("/UserSettings")
public class UserSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action;
		String redirect = "/user_settings.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		
		if (isUser) {
			action = (String) request.getParameter("action");
			System.out.println(action);
			
			if( action.equals("changePassword") ) {
	        	String currentPassword = request.getParameter("currentPassword");
	        	String newPassword = request.getParameter("newPassword");
	        	String confirmPassword = request.getParameter("confirmPassword");
	        	
	        	System.out.println("Given: " + currentPassword + " " + newPassword + " " + confirmPassword );
	        	
			}
			else if( action.equals("changeEmail") ) {
				String newEmail = request.getParameter("newEmail");
	        	
	        	System.out.println("Given: " + newEmail );
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
