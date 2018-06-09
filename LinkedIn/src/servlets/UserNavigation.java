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
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
//import dao.ListingDAO;
//import dao.ListingDAOImpl;
import jpautils.RecommendationSystem;
import model.Article;
import model.Comment;
import model.Connection;
import model.LikeArticle;
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
				redirect = "/user_homepage.jsp";
			}
			else if( action.equals("Network") ) {
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				List<Connection> connections = connectionDAO.getUserConnections(Long.parseLong(userID));
				
				List<User> networkUsers = new ArrayList<User>();
				
				if( connections != null) {
					
					for (Connection con : connections) {
						if( con.getUser1().getUserID() == userID ) {
							networkUsers.add(con.getUser1());
						} else if( con.getUser2().getUserID() == userID ) {
							networkUsers.add(con.getUser2());
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

//				request.setAttribute("connectedUsersListings", connectedUsersListings);
//				request.setAttribute("notConnectedUsersListings", notConnectedUsersListings);
				request.setAttribute("recommendedConnectedUsersListings", recommendedConnectedUsersListings);
				request.setAttribute("recommendedNotConnectedUsersListings", recommendedNotConnectedUsersListings);
				
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
						likeArticles.addAll( likeArticlesDAO.getLikesOfUserArticles(Long.parseLong(article.getArticleID())) );
					}
				}
				
				CommentDAO commentDAO = new CommentDAOImpl();
				List<Comment> comments = new ArrayList<Comment>();
				
				if( articles != null) {
					for( Article article : articles ) {
						comments.addAll( commentDAO.getArticleComments(Long.parseLong(article.getArticleID())) );
					}
				}
				
				ConnectionDAO connectionDAO = new ConnectionDAOImpl();
				
				List<Connection> unansweredCons = connectionDAO.getUserUnansweredConnectionsRequests(Long.parseLong(userID));
				
				if( unansweredCons == null ) {
					unansweredCons = new ArrayList<Connection>();
				}
				
				System.out.println(unansweredCons.size() );
				System.out.println(comments.size() );
				System.out.println(likeArticles.size() );
				
				request.setAttribute("likeArticles", likeArticles);
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
				
				request.setAttribute("networkUsers", networkUsers);
				redirect = "/user_messenger.jsp";
			}
			else if( action.equals("Personal info") ) {
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
