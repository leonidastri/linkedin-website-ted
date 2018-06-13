package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LikeListingDAO;
import dao.LikeListingDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.LikeListing;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddLikeListing")
public class UserAddLikeListing extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/* TODO: check if alright */
		String redirect = "/user_homepage.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			String listingID = (String) session.getAttribute("listingID");
			
			LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
			ListingDAO listingDAO = new ListingDAOImpl();
			UserDAO userDAO = new UserDAOImpl();
			
			LikeListing likeListing = new LikeListing();
			
			likeListing.setListing(listingDAO.find(Long.parseLong(listingID)));
			likeListing.setUser(userDAO.find(Long.parseLong(userID)));
			
			likeListingDAO.create(likeListing);
		}
		else {
			/* TODO: check if alright */
			redirect = "/user_homepage.jsp";
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
