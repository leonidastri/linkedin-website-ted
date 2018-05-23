package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JobDAO;
import dao.JobDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Job;
import model.User;

/**
 * Servlet implementation class UserAddPersonalInfo
 */
@WebServlet("/UserAddPersonalInfo")
public class UserAddPersonalInfo extends HttpServlet {
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
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.find(Long.parseLong(userID));
		
		if (isUser) {
			action = (String) request.getParameter("action");
			System.out.println(action);
			
			if( action.equals("job") ) {
	        	String title = request.getParameter("title");
	        	String description = request.getParameter("description");
	        	String dFrom = request.getParameter("dateFrom");
	        	String dTo = request.getParameter("dateTo");
	        	String isPrivate = request.getParameter("isPrivate");
	        	
	        	JobDAO jobDao = new JobDAOImpl();
	        	Job job = new Job();
	        	
	        	job.setUser(user);
	        	job.setJobTitle(title);
	        	job.setJobDescription(description);
	        	
	        	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	        	java.util.Date dateFrom = null;
				try {
					dateFrom = sdf1.parse(dFrom);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	        	java.sql.Date sqlDateFrom = new java.sql.Date(dateFrom.getTime()); 
	        	job.setJobFrom(sqlDateFrom);
	        	
	        	java.util.Date dateTo = null;
				try {
					dateTo = sdf1.parse(dTo);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	        	java.sql.Date sqlDateTo = new java.sql.Date(dateTo.getTime());
	        	job.setJobTo(sqlDateTo);
	        	
	        	job.setPrivate(Boolean.valueOf(isPrivate));
	        	
	        	jobDao.create(job);
	        	
	        	System.out.println("Given: " + title + " " + description + " " + sqlDateFrom + " " + sqlDateTo + " " + isPrivate );
			}
			else if( action.equals("education") ) {
				String title = request.getParameter("title");
	        	String description = request.getParameter("description");
	        	String dFrom = request.getParameter("dateFrom");
	        	String dTo = request.getParameter("dateTo");
	        	String isPrivate = request.getParameter("private");
	        	
	        	//System.out.println("Given: " + title + " " + description + " " + dFrom + " " + dTo + " " + isPrivate );
			}
			else if( action.equals("skill") ) {
				String description = request.getParameter("description");
	        	String isPrivate = request.getParameter("private");
	        	
	        	//System.out.println("Given: " + description + " " + isPrivate );
			}		
			
			redirect = "/user_add_personal_info.jsp";
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
