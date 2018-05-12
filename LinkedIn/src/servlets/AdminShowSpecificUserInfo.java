package servlets;

import java.io.IOException;
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
 * Servlet implementation class AdminShowSpecificUserInfo
 */
@WebServlet("/AdminShowSpecificUserInfo")
public class AdminShowSpecificUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAO dao = new UserDAOImpl();
		String redirect, email;
		
		HttpSession session = request.getSession();
		
		if ((boolean) session.getAttribute("isAdmin")) {
			redirect = "/user_information.jsp";
			email = (String) request.getParameter("email");
		
			System.out.println("id " + email);
			User user = dao.find(email);
		
			request.setAttribute("user", user);
			redirect = "/user_information.jsp";
		} else {
			redirect = "/access_error.jsp";
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
