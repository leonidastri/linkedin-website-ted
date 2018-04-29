package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserRegister")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl();
        
        String redirect = "/user_homepage.jsp";
        
        String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	User user = dao.login(email, password);
    	
    	if (user == null) {
    		redirect = "login_error.jsp";
    	}
    	else {
    		request.setAttribute("user", user);
    	}
        
        request.getRequestDispatcher(redirect).forward(request, response);
	}
	
}
