package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserNavigation
 */
@WebServlet("/UserNavigation")
public class UserNavigation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action;
		String redirect = "/start_page.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		
		if (isUser) {
			action = (String) request.getParameter("action");
			System.out.println(action);
			if( action.equals("Homepage") ) {
				redirect = "/user_homepage.jsp";
			}
			else if( action.equals("Connections") ) {
				redirect = "/user_connections.jsp";
			}
			else if( action.equals("Listings") ) {
				redirect = "/user_listings.jsp";
			}
			else if( action.equals("Messenger") ) {
				redirect = "/user_messenger.jsp";
			}
			else if( action.equals("Personal info") ) {
				redirect = "/user_information.jsp";
			}
			else if( action.equals("Settings") ) {
				redirect = "/user_settings.jsp";
			}			
			
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
