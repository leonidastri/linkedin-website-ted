package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;
import jpautils.FileUploadSystem;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UploadPhotoFromProfile")
public class UploadPhotoFromProfile extends HttpServlet {

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
		UserDAO dao = new UserDAOImpl();
		HttpSession session = request.getSession();
		String redirect = "/user_profile.jsp";
		
		Boolean isUser = (Boolean) session.getAttribute("isUser");
		String userID = (String) session.getAttribute("userID");
		
		if (isUser) {
			String oldPhotoPath = dao.find(Long.parseLong(userID)).getPhotoPath();
			
			FileUploadSystem fileUploadSystem = new FileUploadSystem();
			
			dao.changePhotoPath(userID, fileUploadSystem.uploadPhoto(request));
			
			/* delete the old photo */
			if (!oldPhotoPath.equals("")) {
				File file = new File(oldPhotoPath);
				file.delete();
			}
		}
		else {
			redirect = "/start_page.jsp";
			session.setAttribute("errorMsg", "no authorization");
		}

		request.getRequestDispatcher(redirect).forward(request, response);
	}

}
