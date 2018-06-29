package servlets;

import java.io.IOException;
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
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
import model.Article;
import model.Comment;

/**
 * Servlet implementation class UserViewArticle
 */
@WebServlet("/UserViewArticle")
public class UserViewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/start_page.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			
			String articleID = request.getParameter("articleID");
			String liked = null;
			
			ArticleDAO articleDAO = new ArticleDAOImpl();
			LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
			CommentDAO commentDAO = new CommentDAOImpl();
			
			if ( likeArticleDAO.find(Long.parseLong(userID), Long.parseLong(articleID)) != null )
				liked = "true";
			else
				liked = "false";
			
			
			Article article = articleDAO.find(Long.parseLong(articleID));
			
			List<Comment> comments = commentDAO.getArticleComments(Long.parseLong(articleID));
			
			request.setAttribute("article", article);
			request.setAttribute("comments", comments);
			request.setAttribute("liked", liked);
			
			redirect = "/user_view_article.jsp";
		} else {
			
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
