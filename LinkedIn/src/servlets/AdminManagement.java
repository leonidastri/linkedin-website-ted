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
        String redirect = "/admin_management.jsp";
		
		HttpSession session = request.getSession();
		
		if ((boolean) session.getAttribute("isAdmin")) {
			switch (request.getParameter("action") ) {
				case "getSpecificUser":
					String email = request.getParameter("email");
					System.out.println("id " + email);
					User user = dao.find(email);
					request.setAttribute("user", user);
					redirect = "/user_information.jsp";
					break;
				case "getAllUsers":
					int currentPage = 1;
			        String previousPage = null, nextPage = null;
			        int usersPerPage = 5;
			        int numberOfPages;
			        List<User> users = dao.list();
			        List<Integer> checkBoxes = new ArrayList<Integer>();
			        
			        String pageNumberValue = request.getParameter("pageNumber");
			    
			        if (pageNumberValue != null) {
			            try {
			                currentPage = Integer.parseInt(pageNumberValue);
			                String a = request.getParameter("checkBoxes");
			                	System.out.println(a);
			                System.out.println("Page Number:" + currentPage);
			            } catch (NumberFormatException e) {
			                e.printStackTrace();
			            }
			        }
			        	
			        numberOfPages = users.size() / usersPerPage;
			        if( numberOfPages % usersPerPage != 0 )
			        	numberOfPages++;
			        
			        int offset = usersPerPage * (currentPage - 1);
			        
			        List<User> tempUsers = new ArrayList<User>();
			        int to = offset + usersPerPage;
			        if( offset > users.size() )
			            offset = users.size();
			        if( to > users.size() )
			            to = users.size();
			        for( int i = offset; i < to; i++) {
			            tempUsers.add(users.get(i));
			            checkBoxes.add(0);
			            //System.out.println(tempUsers.get(i));
			        }
			        
			        request.setAttribute("users", tempUsers);
			        
			        if( currentPage > 1 && currentPage < numberOfPages) {
			        	previousPage = "AdminManagement?action=getAllUsers&pageNumber=" + (currentPage-1);
			        	nextPage = "AdminManagement?action=getAllUsers&pageNumber=" + (currentPage+1);
			        } else if( currentPage == 1 ) {
			        	previousPage = null;
			        	nextPage = "AdminManagement?action=getAllUsers&pageNumber=" + (currentPage+1);
			        } else {
			        	previousPage = "AdminManagement?action=getAllUsers&pageNumber=" + (currentPage-1);
			        	nextPage = null;
			        }
			        
			        //System.out.println(previousPage);
			        //System.out.println(nextPage);
			        
			        request.setAttribute("checkBoxes",checkBoxes);
			        request.setAttribute("previousPage", previousPage);
			        request.setAttribute("nextPage", nextPage);
			        
			        break;
			    	default:
			    	redirect = "/access_error.jsp";
			}
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
