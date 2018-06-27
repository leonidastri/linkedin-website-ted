package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import jpautils.FileUploadSystem;
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
 * Servlet implementation class UserServlet
 */
@WebServlet("/UploadCvFromProfile")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class UploadCvFromProfile extends HttpServlet {

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
		UserDAO userDAO = new UserDAOImpl();
		HttpSession session = request.getSession();
		String redirect = "/user_profile.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		String email = request.getParameter("email");
		
		if (isUser) {
			String oldCvPath = userDAO.find(Long.parseLong(userID)).getCvPath();
			
			FileUploadSystem fileUploadSystem = new FileUploadSystem();
			
			userDAO.changeCvPath(userID, fileUploadSystem.uploadCV(request));
			
			/* delete the old cv */
			if (!oldCvPath.equals("")) {
				File file = new File(oldCvPath);
				file.delete();
			}
			
			/* maybe there is a better way... */
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
					likedArticlesDetails.add(articleDAO.find(Long.parseLong(l.getLike_articleID())));
		
			List<Listing> likedListingsDetails = new ArrayList<Listing>();
			if( likeListings != null)
				for (LikeListing l : likeListings)
					likedListingsDetails.add(listingDAO.find(Long.parseLong(l.getLike_listingID())));
		
			request.setAttribute("jobs", jobs);
			request.setAttribute("skills", skills);
			request.setAttribute("education", education);
			request.setAttribute("listings", listings);
			request.setAttribute("comments", comments);
			request.setAttribute("articles", articles);
			request.setAttribute("likedArticlesDetails", likedArticlesDetails);
			request.setAttribute("likedListingsDetails", likedListingsDetails);
			request.setAttribute("email", email);

			User user;
			
			if( email != null) {
				user = userDAO.find(email);
			} else {
				user = userDAO.find(Long.parseLong(userID));
			}
			request.setAttribute("user", user);
			
			redirect = "/user_profile.jsp";
		}
		else {
			redirect = "/start_page.jsp";
			session.setAttribute("errorMsg", "no authorization");
		}

		request.getRequestDispatcher(redirect).forward(request, response);
	}

}
