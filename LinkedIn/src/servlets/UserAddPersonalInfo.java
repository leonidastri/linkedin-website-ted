package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddPersonalInfo")
public class UserAddPersonalInfo extends HttpServlet {
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
			
			if( action.equals("job") ) {
	        	String title = request.getParameter("title");
	        	String description = request.getParameter("description");
	        	String dFrom = request.getParameter("dateFrom");
	        	String dTo = request.getParameter("dateTo");
	        	String isPrivate = request.getParameter("private");
	        	
	        	System.out.println("Given: " + title + " " + description + " " + dFrom + " " + dTo + " " + isPrivate );
			}
			else if( action.equals("education") ) {
				String title = request.getParameter("title");
	        	String description = request.getParameter("description");
	        	String dFrom = request.getParameter("dateFrom");
	        	String dTo = request.getParameter("dateTo");
	        	String isPrivate = request.getParameter("private");
	        	
	        	System.out.println("Given: " + title + " " + description + " " + dFrom + " " + dTo + " " + isPrivate );
			}
			else if( action.equals("skill") ) {
				String description = request.getParameter("description");
	        	String isPrivate = request.getParameter("private");
	        	
	        	System.out.println("Given: " + description + " " + isPrivate );
			}		
			
			redirect = "/user_add_personal_info.jsp";
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
