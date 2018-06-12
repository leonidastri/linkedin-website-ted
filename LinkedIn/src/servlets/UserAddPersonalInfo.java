package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EducationDAO;
import dao.EducationDAOImpl;
import dao.JobDAO;
import dao.JobDAOImpl;
import dao.SkillDAO;
import dao.SkillDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Education;
import model.Job;
import model.Skill;
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
	        	
	        	job.setJobFrom(java.sql.Date.valueOf(dFrom));
	        	job.setJobTo(java.sql.Date.valueOf(dTo));
	        	
	        	if (isPrivate.equals("true"))
	        		job.setPrivate(true);
	        	else
	        		job.setPrivate(false);
	        	
	        	jobDao.create(job);
	        	
	        	System.out.println("Given: " + title + " " + description + " " + dFrom + " " + dTo + " " + isPrivate );
			}
			else if( action.equals("education") ) {
				String title = request.getParameter("title");
	        	String description = request.getParameter("description");
	        	String dFrom = request.getParameter("dateFrom");
	        	String dTo = request.getParameter("dateTo");
	        	String isPrivate = request.getParameter("private");
	        	
	        	EducationDAO educationDao = new EducationDAOImpl();
	        	Education education = new Education();
	        	
	        	education.setUser(user);
	        	education.setEducationTitle(title);
	        	education.setEducationDescription(description);
	        	
	        	education.setEducationFrom(java.sql.Date.valueOf(dFrom));
	        	education.setEducationTo(java.sql.Date.valueOf(dTo));
	        	
	        	if (isPrivate.equals("true"))
	        		education.setPrivate(true);
	        	else
	        		education.setPrivate(false);
	        	
	        	educationDao.create(education);
	        	System.out.println("Given: " + title + " " + description + " " + dFrom + " " + dTo + " " + isPrivate );
			}
			else if( action.equals("skill") ) {
				String description = request.getParameter("description");
	        	String isPrivate = request.getParameter("isPrivate");
	        	
	        	SkillDAO skillDao = new SkillDAOImpl();
	        	Skill skill = new Skill();
	        	
	        	skill.setUser(user);
	        	skill.setSkill(description);
	        	
	        	if (isPrivate.equals("true"))
	        		skill.setPrivate(true);
	        	else
	        		skill.setPrivate(false);
	        	
	        	skillDao.create(skill);
	        	
	        	System.out.println("Given: " + description + " " + isPrivate );
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
