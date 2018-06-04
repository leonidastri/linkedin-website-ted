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
import model.Education;
import model.Job;
import model.LikeArticle;
import model.LikeListing;
import model.Listing;
import model.Skill;
import model.User;

/**
 * Servlet implementation class UserProfileShowAll
 */
@WebServlet("/UserProfileShowAll")
public class UserProfileShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_profile.jsp";

		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String action = request.getParameter("action");
		String email = request.getParameter("email");

		if (isUser) {
			
			String userID = (String) session.getAttribute("userID");
			UserDAO userDAO = new UserDAOImpl();
			
			User user;
			
			if( email != null) {
				user = userDAO.find(email);
				userID = user.getUserID();
			} else {
				user = userDAO.find(Long.parseLong(userID));
			}
			
			if( action.equals("jobs") ) {
				
				JobDAO jobDAO = new JobDAOImpl();
				List<Job> jobs = jobDAO.getUserJobs(Long.parseLong(userID));
				
				request.setAttribute("jobs", jobs);
				redirect="/user_profile_all_jobs.jsp";
				
			}
			else if( action.equals("education") ) {
			
				EducationDAO educationDAO = new EducationDAOImpl();
				List<Education> education = educationDAO.getUserEducation(Long.parseLong(userID));
				
				request.setAttribute("education", education);
				redirect="/user_profile_all_education.jsp";
			}
			else if( action.equals("skills") ) {
				
				SkillDAO skillDAO = new SkillDAOImpl();
				List<Skill> skills = skillDAO.getUserSkills(Long.parseLong(userID));
			
				request.setAttribute("skills", skills);
				redirect="/user_profile_all_skills.jsp";
			}
			else if( action.equals("articles") ) {
				
				ArticleDAO articleDAO = new ArticleDAOImpl();
				List<Article> articles = articleDAO.getUserArticles(Long.parseLong(userID));	
			
				request.setAttribute("articles", articles);
				redirect="/user_profile_all_articles.jsp";
			}
			else if( action.equals("listings") ) {
				
				ListingDAO listingDAO = new ListingDAOImpl();
				List<Listing> listings = listingDAO.getUserListings(Long.parseLong(userID));
			
				request.setAttribute("listings", listings);
				redirect="/user_profile_all_listings.jsp";
			}
			else if( action.equals("comments") ) {
				
				CommentDAO commentDAO = new CommentDAOImpl();
				List<Comment> comments = commentDAO.getUserComments(Long.parseLong(userID));
			
				request.setAttribute("comments", comments);
				redirect = "/user_profile_all_comments.jsp";
			}
			else if( action.equals("liked_articles") ) {
				
				ArticleDAO articleDAO = new ArticleDAOImpl();
				LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
				List<LikeArticle> likeArticles = likeArticleDAO.getUserLikeArticles(Long.parseLong(userID));
			
				List<Article> likedArticlesDetails = new ArrayList<Article>();
				if( likeArticles != null )
					for (LikeArticle l : likeArticles)
						likedArticlesDetails.add(articleDAO.find(Long.parseLong(l.getLike_articleID())));
				
				request.setAttribute("likedArticlesDetails", likedArticlesDetails);
				redirect = "/user_profile_all_liked_articles.jsp";
			}
			else if( action.equals("liked_listings") ) {
				
				ListingDAO listingDAO = new ListingDAOImpl();
				LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
				List<LikeListing> likeListings = likeListingDAO.getUserLikeListings(Long.parseLong(userID));
			
				List<Listing> likedListingsDetails = new ArrayList<Listing>();
				if( likeListings != null)
					for (LikeListing l : likeListings)
						likedListingsDetails.add(listingDAO.find(Long.parseLong(l.getLike_listingID())));
				
				request.setAttribute("likedListingsDetails", likedListingsDetails);
				redirect = "/user_profile_all_liked_listings.jsp";
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
