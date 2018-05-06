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

import dao.UserDAO;
import dao.UserDAOImpl;
import jpautils.PasswordAuthentication;
import model.User;

/**
 * Servlet implementation class AdminManagement
 */
@WebServlet("/AdminManagement")
public class AdminManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl();
		int page = 1;
        int numberOfPages;
        int usersPerPage = 5;
        
        List<User> users = dao.list();
        
        String pageNumberValue = request.getParameter("pageNumber");
 
        if (pageNumberValue != null) {
            try {
                page = Integer.parseInt(pageNumberValue);
                System.out.println("Page Number:" + page);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        
        int offset = usersPerPage * (page - 1);
        
        List<User> tempUsers = new ArrayList<User>();
        int to = offset + usersPerPage;
        if( offset > users.size() )
            offset = users.size();
        if( to > users.size() )
            to = users.size();
        for( int i = offset; i < to; i++) {
            tempUsers.add(users.get(i));
            //System.out.println(tempUsers.get(i));
        }
        
        request.setAttribute("users", tempUsers);
        
        numberOfPages = users.size() / usersPerPage;
        if( users.size() % usersPerPage != 0 ) {
            numberOfPages = numberOfPages + 1;
        }
        
        request.setAttribute("numberOfPages", numberOfPages);
        
        String redirect = "/admin_management.jsp";
        
        request.getRequestDispatcher(redirect).forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String redirect = "/admin_management.jsp";

        request.getRequestDispatcher(redirect).forward(request, response);
	}
	
}
