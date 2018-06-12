package servlets;

import java.io.IOException;
import java.util.Date;

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
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Comment;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddComment")
public class UserAddComment extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirect = "/user_homepage.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			String articleID = (String) session.getAttribute("articleID");
			String text = request.getParameter("text");
			
			ArticleDAO articleDAO = new ArticleDAOImpl();
			CommentDAO commentDAO = new CommentDAOImpl();
			UserDAO userDAO = new UserDAOImpl();
			
			Comment comment = new Comment();
			
			comment.setArticle(articleDAO.find(Long.parseLong(articleID)));
			comment.setPubDate(new Date());
			comment.setText(text);
			comment.setUser(userDAO.find(Long.parseLong(userID)));
			
			commentDAO.create(comment);
		}
		else {
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
