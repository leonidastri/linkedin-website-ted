package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import jpautils.PasswordAuthentication;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl();
        
        String redirect = "/user_homepage.jsp";
        
        String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	User user = dao.find(email);
    	
    	if (user == null) {
			redirect = "login_error.jsp";
		}
		else {
			PasswordAuthentication pa = new PasswordAuthentication();
			System.out.println(user.getPasswordHashed());
			if (pa.authenticate(password, user.getPasswordHashed())) {
				request.setAttribute("user", user);
				
				if (user.getEmail().equals("admin@linkedin.com"))
					redirect = "/admin_homepage.jsp";
			}
			else {
				redirect = "login_error.jsp";
			}
		}
        
        request.getRequestDispatcher(redirect).forward(request, response);
	}
	
}
