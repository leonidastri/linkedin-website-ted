package servlets;

import java.io.IOException;
import java.util.Date;
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
 * Servlet implementation class UserNavigation
 */
@WebServlet("/UsersConversation")
public class UsersConversation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_messages.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		String messageText = (String) request.getParameter("newMessage");
		
		System.out.println(messageText);
		
		if (isUser) {
			String receiverID = (String) session.getAttribute("receiverID");
			
			UserDAO userDAO = new UserDAOImpl();
			
			User sender = userDAO.find(Long.parseLong(userID));
			User receiver = userDAO.find(Long.parseLong(receiverID));
			
			MessageDAO messageDAO = new MessageDAOImpl();
			
			Message newMessage = new Message();
			newMessage.setPubDate(new Date());			// return current date
			newMessage.setText(messageText);
			newMessage.setUser1(sender);
			newMessage.setUser2(receiver);
			
			messageDAO.create(newMessage);
			
			List<Message> conversation = messageDAO.getUserConversation( Long.parseLong(userID), Long.parseLong(receiverID));
			
			//for( Message c : conversation )
			//	System.out.println(c.getUser1() + ": " + c.getText() );
			
			request.setAttribute("messages", conversation);
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
