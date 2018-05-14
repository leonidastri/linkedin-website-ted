package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class AdminGetUsersXML
 */
@WebServlet("/GetUsersXML")
public class AdminGetUsersXML extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "admin_homepage.jsp";
		
		UserDAO dao = new UserDAOImpl();
		
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
				
		if (isAdmin) {
			List<User> users = dao.list();
			List<User> selectedUsers = null;
			@SuppressWarnings("unchecked")
			Vector<Boolean> checked = (Vector<Boolean>) session.getAttribute("checked");
			
			/* get selected users */
			for(int i = 0; i < users.size(); i++)
				if (checked.get(i))
					selectedUsers.add(users.get(i));
			
			if (selectedUsers != null && selectedUsers.size() > 0) {
				;
			}
			else {
				session.setAttribute("errorMsg", "no selected users");
			}
		}
		else {
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
