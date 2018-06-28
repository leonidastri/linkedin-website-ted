package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.LikeArticle;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddLikeArticle")
public class UserAddLikeArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/* TODO: check if alright */
		String redirect = "UserNavigation?action=Homepage";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			String articleID = request.getParameter("articleID");
			
			ArticleDAO articleDAO = new ArticleDAOImpl();
			LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
			UserDAO userDAO = new UserDAOImpl();
			
			LikeArticle likeArticle = new LikeArticle();
			
			likeArticle.setArticle(articleDAO.find(Long.parseLong(articleID)));
			likeArticle.setUser(userDAO.find(Long.parseLong(userID)));
			
			likeArticleDAO.create(likeArticle);
			
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
