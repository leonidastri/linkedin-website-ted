package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

/**
 * Servlet implementation class AdminShowAllUsers
 */
@WebServlet("/AdminShowAllUsers")
public class AdminShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Vector<Boolean> checked;
	private static boolean flag = true;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentPage = 1;
		int usersPerPage = 5;
		int numberOfPages;
		UserDAO dao = new UserDAOImpl();
        String redirect = null, previousPage = null, nextPage = null, pageNumberValue = null;
        
		HttpSession session = request.getSession();
		
		if ((boolean) session.getAttribute("isAdmin")) {
			List<User> users = dao.list();
	        List<User> tempUsers = new ArrayList<User>();
	        
	        if( flag == true) {
	        	checked = new Vector<Boolean>(users.size());
	        	flag = false;
	        }
	        Vector<Boolean> tempChecked = new Vector<Boolean>(usersPerPage);
	        
	        for (int i = 0; i < users.size(); i++)
	        	checked.addElement(false);
	        for (int i = 0; i < usersPerPage; i++)
	        	tempChecked.addElement(false);
	        
	        pageNumberValue = request.getParameter("pageNumber");
	        
	        if (pageNumberValue != null) {
	            try {
	                currentPage = Integer.parseInt(pageNumberValue);
	                //debug
	                //for(int i = 0; i < usersPerPage; i++)
	                //	System.out.println(request.getParameter("checkList"+i));
	                //if (session.getAttribute("tempChecked") != null && !session.getAttribute("tempChecked").equals(""))
	                //	tempChecked = (Vector<Boolean>)request.getAttribute("tempChecked");
	                System.out.println("Page Number:" + currentPage);
	            } catch (NumberFormatException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        numberOfPages = users.size() / usersPerPage;
	        if( numberOfPages % usersPerPage != 0 )
	        	numberOfPages++;
	        
	        int offset = usersPerPage * (currentPage - 1);
	        int found = 0;
	        
	        String[] checkList = request.getParameterValues("checkList");
	        if( pageNumberValue != null && checkList != null ) {
	        	System.out.println(checkList.length);
	        	for(int i = 0; i < usersPerPage; i++ ) {
	        		found = 0;
	        		if( i < users.size() ) {
	        			for( int j = 0; j < checkList.length; j++ ) {
	        				if( users.get(offset+i).getEmail().equals(checkList[j]) ) {
	        					checked.set(offset+i,true);
	        					found = 1;
	        				}
	        			}
	        			
	        			if( found == 0 ) {
	        				checked.set(offset+i,false);
	        			}
	        		}
	        	}
	        }
	        
	        for( int i = 0; i < users.size(); i++) {
	        	System.out.println(i + " " + checked.get(i));
	        }
	        
	        //System.out.println("Page");
	        int to = offset + usersPerPage;
	        if( offset > users.size() )
	            offset = users.size();
	        if( to > users.size() )
	            to = users.size();
	        for( int i = offset; i < to; i++) {
	        	
	            tempUsers.add(users.get(i));
	            
	            if( checked.get(i) ) {
		            tempChecked.set(i-offset,true);
	            } else {
	            	tempChecked.set(i-offset,false);
	            }
	        }
	        
	        request.setAttribute("users", tempUsers);
	        
	        if( currentPage > 1 && currentPage < numberOfPages) {
	        	previousPage = "AdminShowAllUsers?pageNumber=" + (currentPage-1);
	        	nextPage = "AdminShowAllUsers?pageNumber=" + (currentPage+1);
	        } else if( currentPage == 1 ) {
	        	previousPage = null;
	        	nextPage = "AdminShowAllUsers?pageNumber=" + (currentPage+1);
	        } else {
	        	previousPage = "AdminShowAllUsers?pageNumber=" + (currentPage-1);
	        	nextPage = null;
	        }
	        
	        redirect = "/admin_management.jsp";
	        session.setAttribute("tempChecked",tempChecked);
	        request.setAttribute("usersPerPage", usersPerPage);
	        request.setAttribute("previousPage", previousPage);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("nextPage", nextPage);
	        
		} else {
			redirect = "/access_error.jsp";
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
