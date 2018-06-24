package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnectionDAO;
import dao.ConnectionDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Connection;
import model.User;


/**
 * Servlet implementation class UserSendFriendRequest
 */
@WebServlet("/UserSendFriendRequest")
public class UserSendFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_homepage.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		String email = request.getParameter("email");
		String userID2 = request.getParameter("userID2");
		
		if (isUser) {
			UserDAO userDAO = new UserDAOImpl();
			
			User user1 = userDAO.find(Long.parseLong(userID));
			User user2 = userDAO.find(Long.parseLong(userID2));
			
			ConnectionDAO connectionDAO = new ConnectionDAOImpl();
			
			Connection con = connectionDAO.getConnection(Long.parseLong(userID), Long.parseLong(userID2));
			
			// if connection does not exist, create it
			if( (con == null) ) {
				Connection connection = new Connection();
			
				connection.setAccepted(false);
				connection.setRejected(false);
				connection.setUser1(user1);
				connection.setUser2(user2);
			
				connectionDAO.create(connection);
			// if exists, change rejected to false to check again
			} else {
				if ( con.getRejected() ) {
					con.setRejected(false);
				}
			}
			
			request.setAttribute("action", "OtherUserProfile");
			request.setAttribute("email", email);
			redirect = "/UserProfile?action=OtherUserProfile&email=" + email;
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
