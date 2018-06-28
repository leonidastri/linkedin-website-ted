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

import dao.ApplicationDAO;
import dao.ApplicationDAOImpl;
import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.CommentDAO;
import dao.CommentDAOImpl;
import dao.ConnectionDAO;
import dao.ConnectionDAOImpl;
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
import dao.LikeListingDAO;
import dao.LikeListingDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
//import dao.ListingDAO;
//import dao.ListingDAOImpl;
import jpautils.RecommendationSystem;
import model.Article;
import model.Comment;
import model.Connection;
import model.LikeArticle;
import model.LikeListing;
import model.Listing;
import model.User;

/**
 * Servlet implementation class UserNavigation
 */
@WebServlet("/UserNavigation")
public class UserNavigation extends HttpServlet {
	
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
		
		if (isUser) {
			
			action = (String) request.getParameter("action");
			System.out.println(action);
			
			if( action.equals("Homepage") ) {
				
				UserDAO userDAO = new UserDAOImpl();
				
				User user = userDAO.find(Long.parseLong(userID));
				
				RecommendationSystem recommendationSystem = new RecommendationSystem();
				
				List<Article> recommendedConnectedUsersArticles = recommendationSystem.getConnectedRecommendedArticles(userID);
				List<Article> recommendedNotConnectedUsersArticles = recommendationSystem.getNotConnectedRecommendedArticles(userID);

				if( recommendedConnectedUsersArticles == null )
					recommendedConnectedUsersArticles = new ArrayList<Article>();
				
				if( recommendedNotConnectedUsersArticles == null )
					recommendedNotConnectedUsersArticles = new ArrayList<Article>();
				
				List<String> alreadyLikedConArticle = new ArrayList<String>();
				List<String> alreadyLikedNotConArticle = new ArrayList<String>();
				
				LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
				
				for( Article a : recommendedConnectedUsersArticles) {
					if ( likeArticleDAO.find(Long.parseLong(userID), Long.parseLong(a.getArticleID())) != null )
						alreadyLikedConArticle.add("true");					
					else
						alreadyLikedConArticle.add("false");				
				}
				
				for( Article a : recommendedNotConnectedUsersArticles) {
					if ( likeArticleDAO.find(Long.parseLong(userID), Long.parseLong(a.getArticleID())) != null )
						alreadyLikedNotConArticle.add("true");					
					else
						alreadyLikedNotConArticle.add("false");
				}
				
				request.setAttribute("firstname", user.getFirstName());
				request.setAttribute("photopath", user.getPhotoPath());
				request.setAttribute("recommendedConnectedUsersArticles", recommendedConnectedUsersArticles);
				request.setAttribute("recommendedNotConnectedUsersArticles", recommendedNotConnectedUsersArticles);
				request.setAttribute("alreadyLikedConArticle", alreadyLikedConArticle);
				request.setAttribute("alreadyLikedNotConArticle", alreadyLikedNotConArticle);
				
				redirect = "/user_homepage.jsp";
			}
			else if( action.equals("Network") ) {
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				List<Connection> connections = connectionDAO.getUserConnections(Long.parseLong(userID));
				
				List<User> networkUsers = new ArrayList<User>();
				
				if( connections != null) {
					for (Connection con : connections) {
						if( con.getUser1().getUserID() == userID ) {
							networkUsers.add(con.getUser2());
						} else if( con.getUser2().getUserID() == userID ) {
							networkUsers.add(con.getUser1());
						}
					}
				}
				
				request.setAttribute("networkUsers", networkUsers);
				redirect = "/user_network.jsp";
			}
			else if( action.equals("Listings") ) {
//				ListingDAO listingDAO = new ListingDAOImpl();
//				List<Listing> connectedUsersListings = listingDAO.getConnectedUsersListings(Long.parseLong(userID));
//				List<Listing> notConnectedUsersListings = listingDAO.getNotConnectedUsersListings(Long.parseLong(userID));
				
				/* TODO: filter the notConnectedUsersListings
				 * TODO: should we filter the connectedUsersListingsAsWell */
				
				/* for now, just take the recommended users' listings directly */
				RecommendationSystem recommendationSystem = new RecommendationSystem();
				List<Listing> recommendedConnectedUsersListings = recommendationSystem.getConnectedRecommendedListings(userID);
				List<Listing> recommendedNotConnectedUsersListings = recommendationSystem.getNotConnectedRecommendedListings(userID);

				if( recommendedConnectedUsersListings == null )
					recommendedConnectedUsersListings = new ArrayList<Listing>();
				
				if( recommendedNotConnectedUsersListings == null )
					recommendedNotConnectedUsersListings = new ArrayList<Listing>();
				
				ApplicationDAO applicationDAO = new ApplicationDAOImpl();
				LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
				
				List<String> conApplied = new ArrayList<String>();
				List<String> alreadyLikedConListing = new ArrayList<String>();
				
				for( Listing l : recommendedConnectedUsersListings ) {
					
					if ( applicationDAO.getApplication(Long.parseLong(userID), Long.parseLong(l.getListingID())) != null )
						conApplied.add("true");					
					else
						conApplied.add("false");
					
					if ( likeListingDAO.find(Long.parseLong(userID), Long.parseLong(l.getListingID())) != null )
						alreadyLikedConListing.add("true");					
					else
						alreadyLikedConListing.add("false");
				}
				
				List<String> notConApplied = new ArrayList<String>();
				List<String> alreadyLikedNotConListing = new ArrayList<String>();
				
				for( Listing l : recommendedNotConnectedUsersListings ) {
					
					if ( applicationDAO.getApplication(Long.parseLong(userID), Long.parseLong(l.getListingID())) != null )
						notConApplied.add("true");
					else
						notConApplied.add("false");
					
					if ( likeListingDAO.find(Long.parseLong(userID), Long.parseLong(l.getListingID())) != null )
						alreadyLikedNotConListing.add("true");					
					else
						alreadyLikedNotConListing.add("false");
				}
				
//				request.setAttribute("connectedUsersListings", connectedUsersListings);
//				request.setAttribute("notConnectedUsersListings", notConnectedUsersListings);
				request.setAttribute("recommendedConnectedUsersListings", recommendedConnectedUsersListings);
				request.setAttribute("recommendedNotConnectedUsersListings", recommendedNotConnectedUsersListings);
				request.setAttribute("conApplied", conApplied);
				request.setAttribute("notConApplied", notConApplied);
				request.setAttribute("alreadyLikedConListing", alreadyLikedConListing);
				request.setAttribute("alreadyLikedNotConListing", alreadyLikedNotConListing);
				redirect = "/user_listings.jsp";
			}
			else if( action.equals("Notifications") ) {
				
				String acceptFriend = request.getParameter("acceptFriend");
				String otherUserID = request.getParameter("otherUserID");
				
				if( acceptFriend != null) {
					
					ConnectionDAO connectionDAO = new ConnectionDAOImpl();
					
					if( acceptFriend.equals("true") ) 
						connectionDAO.connectionChangeStatus(Long.parseLong(userID), Long.parseLong(otherUserID), acceptFriend);
					else
						connectionDAO.connectionChangeStatus(Long.parseLong(userID), Long.parseLong(otherUserID), acceptFriend);
				}
				
				ArticleDAO articlesDAO = new ArticleDAOImpl();
				List<Article> articles = articlesDAO.getUserArticles(Long.parseLong(userID));

				LikeArticleDAO likeArticlesDAO = new LikeArticleDAOImpl();
				List<LikeArticle> likeArticles = new ArrayList<LikeArticle>();
				
				if( articles != null ) {
					for( Article article : articles ) {
						List<LikeArticle> likedArticleList = likeArticlesDAO.getLikesOfUserArticles(Long.parseLong(article.getArticleID()));
						
						if( likedArticleList != null )
							likeArticles.addAll( likedArticleList );
					}
				}
				
				ListingDAO listingDAO = new ListingDAOImpl();
				List<Listing> listings = listingDAO.getUserListings(Long.parseLong(userID));

				LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
				List<LikeListing> likeListings = new ArrayList<LikeListing>();
				
				if( listings != null ) {
					for( Listing l : listings ) {
						List<LikeListing> likedListingsList = likeListingDAO.getLikesOfUserListings(Long.parseLong(l.getListingID()));
						
						if( likedListingsList != null )
							likeListings.addAll( likedListingsList );
					}
				}
				
				CommentDAO commentDAO = new CommentDAOImpl();
				List<Comment> comments = new ArrayList<Comment>();
				
				if( articles != null) {
					for( Article article : articles ) {
						List<Comment> articleComments = commentDAO.getArticleComments(Long.parseLong(article.getArticleID()));
						
						if (articleComments != null) 
							comments.addAll( articleComments );
					}
				}
				
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				
				List<Connection> unansweredCons = connectionDAO.getUserUnansweredConnectionsRequests(Long.parseLong(userID));
				
				if( unansweredCons == null ) {
					unansweredCons = new ArrayList<Connection>();
				}
				
				//System.out.println(unansweredCons.size() );
				//System.out.println(comments.size() );
				//System.out.println(likeArticles.size() );
				
				request.setAttribute("likeArticles", likeArticles);
				request.setAttribute("likeListings", likeListings);
				request.setAttribute("unansweredCons", unansweredCons);
				request.setAttribute("comments", comments);
				
				redirect = "/user_notifications.jsp";
			}
			else if( action.equals("Messenger") ) {
			
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				List<Connection> connections = connectionDAO.getUserConnections(Long.parseLong(userID));
				
				List<User> networkUsers = new ArrayList<User>();
				
				if( connections != null) {
					for (Connection con : connections) {
						if( con.getUser1().getUserID() == userID ) {
							networkUsers.add(con.getUser2());
						} else if( con.getUser2().getUserID() == userID ) {
							networkUsers.add(con.getUser1());
						}
					}
					
				}
				
				MessageDAO messageDAO= new MessageDAOImpl();
				List<User> chattingUsers;
				
				chattingUsers = messageDAO.getChattingUsers(Long.parseLong(userID));
				
				if( chattingUsers == null ) {
					chattingUsers = new ArrayList<User>();
				}
				
				request.setAttribute("networkUsers", networkUsers);
				request.setAttribute("chattingUsers", chattingUsers);
				redirect = "/user_messenger.jsp";
			}
			else if( action.equals("Personal Details") ) {
				redirect = "/user_add_personal_info.jsp";
			}
			else if( action.equals("Settings") ) {
				redirect = "/user_settings.jsp";
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
