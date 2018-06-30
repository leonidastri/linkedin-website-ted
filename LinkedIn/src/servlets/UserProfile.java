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

import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.CommentDAO;
import dao.CommentDAOImpl;
import dao.ConnectionDAO;
import dao.ConnectionDAOImpl;
import dao.EducationDAO;
import dao.EducationDAOImpl;
import dao.JobDAO;
import dao.JobDAOImpl;
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
import dao.LikeListingDAO;
import dao.LikeListingDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.SkillDAO;
import dao.SkillDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Article;
import model.Comment;
import model.Connection;
import model.Education;
import model.Job;
import model.LikeArticle;
import model.LikeListing;
import model.Listing;
import model.Skill;
import model.User;

/**
 * Servlet implementation class UserNavigation
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_homepage.jsp";
		String userID2 = null;
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		
		System.out.println(email);
		if (isUser) {
			
			String userID = (String) session.getAttribute("userID");
			UserDAO userDAO = new UserDAOImpl();
			User user;
			
			if( email != null) {
				user = userDAO.find(email);
				userID2 = user.getUserID();
				
			} else {
				user = userDAO.find(Long.parseLong(userID));
			}
			
			if( action.equals("UserProfile") ) {
				
				JobDAO jobDAO = new JobDAOImpl();
				SkillDAO skillDAO = new SkillDAOImpl();
				EducationDAO educationDAO = new EducationDAOImpl();
				ListingDAO listingDAO = new ListingDAOImpl();
				CommentDAO commentDAO = new CommentDAOImpl();
				ArticleDAO articleDAO = new ArticleDAOImpl();
				LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
				LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
			
				List<Job> jobs = jobDAO.getUserJobs(Long.parseLong(userID));
				List<Skill> skills = skillDAO.getUserSkills(Long.parseLong(userID));
				List<Education> education = educationDAO.getUserEducation(Long.parseLong(userID));
				List<Listing> listings = listingDAO.getUserListings(Long.parseLong(userID));
				List<Comment> comments = commentDAO.getUserComments(Long.parseLong(userID));
				List<Article> articles = articleDAO.getUserArticles(Long.parseLong(userID));
				List<LikeArticle> likeArticles = likeArticleDAO.getUserLikeArticles(Long.parseLong(userID));
				List<LikeListing> likeListings = likeListingDAO.getUserLikeListings(Long.parseLong(userID));
			
				List<Article> likedArticlesDetails = new ArrayList<Article>();
				if( likeArticles != null )
					for (LikeArticle l : likeArticles)					
						likedArticlesDetails.add(articleDAO.find(Long.parseLong(l.getArticle().getArticleID())));
				List<Listing> likedListingsDetails = new ArrayList<Listing>();
				if( likeListings != null)
					for (LikeListing l : likeListings)
						likedListingsDetails.add(listingDAO.find(Long.parseLong(l.getListing().getListingID())));
			
				
				request.setAttribute("jobs", jobs);
				request.setAttribute("skills", skills);
				request.setAttribute("education", education);
				request.setAttribute("listings", listings);
				request.setAttribute("comments", comments);
				request.setAttribute("articles", articles);
				request.setAttribute("likedArticlesDetails", likedArticlesDetails);
				request.setAttribute("likedListingsDetails", likedListingsDetails);
				request.setAttribute("email", email);
				request.setAttribute("userID2", userID2);
				
				redirect = "/user_profile.jsp";
			}
			else if ( action.equals("OtherUserProfile") ) {
				
				JobDAO jobDAO = new JobDAOImpl();
				SkillDAO skillDAO = new SkillDAOImpl();
				EducationDAO educationDAO = new EducationDAOImpl();
				ListingDAO listingDAO = new ListingDAOImpl();
				CommentDAO commentDAO = new CommentDAOImpl();
				ArticleDAO articleDAO = new ArticleDAOImpl();
				LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
				LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				
				Connection con = connectionDAO.getConnection( Long.parseLong(userID), Long.parseLong(userID2));
				
				List<Job> jobs;
				List<Skill> skills;
				List<Education> education;
				
				if( con == null ) {
					jobs = jobDAO.getOnlyPublicUserJobs(Long.parseLong(userID2));
					skills = skillDAO.getOnlyPublicUserSkills(Long.parseLong(userID2));
					education = educationDAO.getOnlyPublicUserEducation(Long.parseLong(userID2));
				}
				else {
					jobs = jobDAO.getUserJobs(Long.parseLong(userID2));
					skills = skillDAO.getUserSkills(Long.parseLong(userID2));
					education = educationDAO.getUserEducation(Long.parseLong(userID2));
				}
				
				List<Listing> listings = listingDAO.getUserListings(Long.parseLong(userID2));
				List<Comment> comments = commentDAO.getUserComments(Long.parseLong(userID2));
				List<Article> articles = articleDAO.getUserArticles(Long.parseLong(userID2));
				List<LikeArticle> likeArticles = likeArticleDAO.getUserLikeArticles(Long.parseLong(userID2));
				List<LikeListing> likeListings = likeListingDAO.getUserLikeListings(Long.parseLong(userID2));
				
				List<Article> likedArticlesDetails = new ArrayList<Article>();
				if( likeArticles != null )
					for (LikeArticle l : likeArticles) {
						System.out.println(l.getLike_articleID());
						likedArticlesDetails.add(articleDAO.find(Long.parseLong(l.getArticle().getArticleID())));
					}
				List<Listing> likedListingsDetails = new ArrayList<Listing>();
				if( likeListings != null)
					for (LikeListing l : likeListings)
						likedListingsDetails.add(listingDAO.find(Long.parseLong(l.getListing().getListingID())));
			
				request.setAttribute("jobs", jobs);
				request.setAttribute("skills", skills);
				request.setAttribute("education", education);
				request.setAttribute("listings", listings);
				request.setAttribute("comments", comments);
				request.setAttribute("articles", articles);
				request.setAttribute("likedArticlesDetails", likedArticlesDetails);
				request.setAttribute("likedListingsDetails", likedListingsDetails);
				request.setAttribute("email", email);
				
				request.setAttribute("userID2", userID2);
			
				String noFriendRequest = null;
				
				Connection connection = connectionDAO.getConnection(Long.parseLong(userID), Long.parseLong(userID2));
				
				// if not accepted and not rejected or accepted cannot send again
				if( connection != null )
					if ( (!connection.getAccepted() && !connection.getRejected()) || connection.getAccepted() )
						noFriendRequest = "yes";
				
				request.setAttribute("noFriendRequest", noFriendRequest);
				redirect = "/user_profile.jsp";
			}
			else if ( action.equals("Network") ) {
				
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				List<Connection> connections = connectionDAO.getUserConnections(Long.parseLong(userID));
				
				List<User> networkUsers = new ArrayList<User>();
				
				if( connections != null) {
					
					for (Connection con : connections) {
						if( con.getUser2().getUserID() == userID ) {
							networkUsers.add(con.getUser2());
						}
					}
					
				}
				
				request.setAttribute("networkUsers", networkUsers);
				redirect = "/user_network.jsp";
			}
			
			request.setAttribute("user", user);
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
