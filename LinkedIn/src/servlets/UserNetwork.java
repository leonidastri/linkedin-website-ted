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
import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class UserNetwork
 */
@WebServlet("/UserNetwork")
public class UserNetwork extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_homepage.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		String action = request.getParameter("action");
		
		if (isUser) {
			
			if( action.equals("Search") ) {
				
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				
				UserDAO userDAO = new UserDAOImpl();
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				
				List<User> searchUsers = userDAO.find(name, surname);
				List<String> searchUserIDs = new ArrayList<String>();
				
				if( searchUsers == null ) {
					searchUsers = new ArrayList<User>();
					
					searchUserIDs = connectionDAO.getConnectedUsersIDs(Long.parseLong(userID));
					
					for (String id : searchUserIDs)
						searchUsers.add(userDAO.find(Long.parseLong(id)));
				}
				else {
					List<User> temp = new ArrayList<User>();
					
					for (User u : searchUsers)
						if (connectionDAO.getConnection(Long.parseLong(userID), Long.parseLong(u.getUserID())) != null)
							temp.add(u);
					
					searchUsers = temp;
				}
				
				request.setAttribute("searchUsers", searchUsers);
				redirect = "/user_network_search_results.jsp";
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
