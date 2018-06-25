package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationDAO;
import dao.ApplicationDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Application;
import model.Listing;
import model.User;

/**
 * Servlet implementation class UserNavigation
 */
@WebServlet("/UserListings")
public class UserListings extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action;
		String redirect = "/start_page.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.find(Long.parseLong(userID));
		
		if (isUser) {
			action = (String) request.getParameter("action");
			System.out.println(action);
			
			if (action.equals("ListingApplication")) {
				ApplicationDAO applicationDAO = new ApplicationDAOImpl();
				ListingDAO listingDAO = new ListingDAOImpl();
				
				Application application = new Application();
				
				String listingID = (String) request.getParameter("listingID");
				
				application.setListing(listingDAO.find(Long.parseLong(listingID)));
				application.setUser(user);
				application.setAccepted(false);
				application.setRejected(false);
				
				applicationDAO.create(application);
				
				redirect = "/UserNavigation?action=Listings";
			}
			else if (action.equals("UserListingsPersonal")) {
				ApplicationDAO applicationDAO = new ApplicationDAOImpl();
				
				List<Application> unansweredApplications = applicationDAO.getUserUnansweredApplications(Long.parseLong(userID));
				
				if( unansweredApplications == null )
					unansweredApplications = new ArrayList<Application>();
				
				List<Application> acceptedApplications = applicationDAO.getUserAcceptedApplications(Long.parseLong(userID));
				
				if( acceptedApplications == null )
					acceptedApplications = new ArrayList<Application>();
				
				request.setAttribute("unansweredApplications", unansweredApplications);
				request.setAttribute("acceptedApplications", acceptedApplications);
				
				redirect = "/user_listings_personal.jsp";
			}
			else if (action.equals("AddListing")) {
				ListingDAO listingDAO = new ListingDAOImpl();
				
				Listing listing = new Listing();
				
				listing.setTitle(request.getParameter("title"));
				listing.setDescription("description");
				listing.setPubDate(new Date());
				listing.setUser(user);
				
				listingDAO.create(listing);
				
				/* we need them again -- re-send them */
				ApplicationDAO applicationDAO = new ApplicationDAOImpl();
				
				List<Application> unansweredApplications = applicationDAO.getUserUnansweredApplications(Long.parseLong(userID));
				
				if( unansweredApplications == null )
					unansweredApplications = new ArrayList<Application>();
				
				List<Application> acceptedApplications = applicationDAO.getUserUnansweredApplications(Long.parseLong(userID));
				
				if( acceptedApplications == null )
					acceptedApplications = new ArrayList<Application>();
				
				request.setAttribute("unansweredApplications", unansweredApplications);
				request.setAttribute("acceptedApplications", acceptedApplications);
				
				redirect = "/user_listings_personal.jsp";
			} else if( action.equals("CheckApplication") ) {
				String acceptApplication = request.getParameter("acceptApplication");
				String listingID = request.getParameter("listingID");
				String otherUserID = request.getParameter("otherUserID");
				
				System.out.println(otherUserID + " " + listingID + " " + acceptApplication);
				if( acceptApplication != null) {
					
					ApplicationDAO applicationDAO = new ApplicationDAOImpl();
					applicationDAO.applicationChangeStatus(Long.parseLong(otherUserID), Long.parseLong(listingID), acceptApplication);
				}
				

				ApplicationDAO applicationDAO = new ApplicationDAOImpl();
				
				List<Application> unansweredApplications = applicationDAO.getUserUnansweredApplications(Long.parseLong(userID));
				
				if( unansweredApplications == null )
					unansweredApplications = new ArrayList<Application>();
				
				List<Application> acceptedApplications = applicationDAO.getUserUnansweredApplications(Long.parseLong(userID));
				
				if( acceptedApplications == null )
					acceptedApplications = new ArrayList<Application>();
				
				request.setAttribute("unansweredApplications", unansweredApplications);
				request.setAttribute("acceptedApplications", acceptedApplications);
				
				redirect = "/user_listings_personal.jsp";
			}
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
