package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import jpautils.FileUploadSystem;
import model.Article;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddArticle")
public class UserAddArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/* TODO: check if alright */
		String redirect = null;
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			
			ArticleDAO articleDAO = new ArticleDAOImpl();
			UserDAO userDAO = new UserDAOImpl();
			
			Article article = new Article();
			
			FileUploadSystem fileUploadSystem = new FileUploadSystem();
			
			/* https://stackoverflow.com/questions/17937841/multipart-form-data-does-not-support-for-request-getparamerter
			
			List<FileItem> items;
			try {
				items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

		        for (FileItem item : items) {
		            if (item.isFormField()) {
		                if( item.getFieldName().equals("title") )
		                	article.setTitle(item.getString());
		                else if( item.getFieldName().equals("text") )
		                	article.setText(item.getString());
		            }
		        }
			
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			article.setUser(userDAO.find(Long.parseLong(userID)));
			article.setPubDate(new Date());			// return current date
			article.setAudioPath(fileUploadSystem.uploadAudio(request));
			article.setPicturePath(fileUploadSystem.uploadPhoto(request));
			article.setVideoPath(fileUploadSystem.uploadVideo(request));
			
			articleDAO.create(article);
			
			redirect = "UserNavigation?action=Homepage";
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
