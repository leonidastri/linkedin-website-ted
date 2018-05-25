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
import model.Message;

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
		String redirect = "/users_conversation.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		
		if (isUser) {
			String senderID = (String) session.getAttribute("senderID");
			String receiverID = (String) session.getAttribute("receiverID");
			
			MessageDAO messageDAO = new MessageDAOImpl();
			
			List<Message> senderMessages = messageDAO.getUserSentMessages(Long.parseLong(senderID));
			List<Message> receiverMessages = messageDAO.getUserSentMessages(Long.parseLong(receiverID));
			
			request.setAttribute("senderMessages", senderMessages);
			request.setAttribute("receiverMessages", receiverMessages);
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
