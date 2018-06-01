package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnectionDAO;
import dao.ConnectionDAOImpl;
import model.Connection;
import model.User;

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
		String userID = (String) session.getAttribute("userID");
		
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
			
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				List<Connection> connections = connectionDAO.getUserConnections(Long.parseLong(userID));
				
				List<User> networkUsers = new ArrayList<User>();
				
				if( connections != null) {
					for (Connection con : connections) {
						if( con.getUser1().getUserID() == userID ) {
							networkUsers.add(con.getUser2());
						} else if( con.getUser2().getUserID() == userID ) {
							networkUsers.add(con.getUser1());
						}
					}
					
				}
				
				request.setAttribute("networkUsers", networkUsers);
				redirect = "/user_messenger.jsp";
			}
			else if( action.equals("Personal info") ) {
				redirect = "/user_add_personal_info.jsp";
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
