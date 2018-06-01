package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Message;
import model.User;

/**
 * Servlet implementation class UserMessenger
 */
@WebServlet("/UserMessenger")
public class UserMessenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/users_conversation.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		String receiverID = request.getParameter("receiverID");
		
		if (isUser) {
			
			UserDAO userDAO = new UserDAOImpl();
			User user = userDAO.find(Long.parseLong(userID));
			
			MessageDAO messageDAO = new MessageDAOImpl();
			
			List<Message> conversation = messageDAO.getUserConversation( Long.parseLong(userID), Long.parseLong(receiverID));
			
			session.setAttribute("senderID", user.getUserID() );
			session.setAttribute("receiverID", receiverID );
			session.setAttribute("messages", conversation);
			redirect = "/user_messages.jsp";
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
