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
	@SuppressWarnings("null")
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
	        
	        // first time initialize vector for all checked
	        if( flag == true) {
	        	checked = new Vector<Boolean>(users.size());
	        	flag = false;
	        }
	        
	        // find number of pages
	        numberOfPages = users.size() / usersPerPage;
	        if( numberOfPages % usersPerPage != 0 )
	        	numberOfPages++;
	        
	        // fix size of checked vector
	        int s = numberOfPages * usersPerPage - checked.size();
	        System.out.print(s);
	        for (int i = 0; i <= s; i++) {
	        	System.out.println(i);
	        	checked.addElement(false);
	        }
	        
	        Vector<Boolean> tempChecked = new Vector<Boolean>(usersPerPage);
	        for (int i = 0; i < usersPerPage; i++)
	        	tempChecked.addElement(false);
	        
	        pageNumberValue = request.getParameter("pageNumber");
	        
	        if (pageNumberValue != null) {
	            try {
	                currentPage = Integer.parseInt(pageNumberValue);
	                System.out.println("Page Number:" + currentPage);
	            } catch (NumberFormatException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        int offset = usersPerPage * (currentPage - 1);
	        int found;
	        
	        String[] checkList = request.getParameterValues("checkList");
	        
	        // Get checkboxes 
	        if( pageNumberValue != null && checkList != null ) {
	        	//System.out.println(checkList.length);

	        	for(int i = 0; i < usersPerPage; i++ ) {
	        		found = 0;
	        		if( offset+i < users.size() ) {
	        			for( int j = 0; j < checkList.length; j++ ) {
	        				System.out.println("list" + checkList[j]);
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
	            
	            if( checked.get(i) )
		            tempChecked.set(i-offset,true);
	            else
	            	tempChecked.set(i-offset,false);
	            
	            //System.out.println(tempChecked.get(i-offset));
	        }

	        // Fix previous and next page for pagination
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
	        
	        /*	tempChecked contains checked of current page
	         * 	checked contains all checked
	         * 	users contains users of current page
	         */
	        session.setAttribute("checked", checked);
	        request.setAttribute("tempChecked",tempChecked);
	        request.setAttribute("users", tempUsers);
	        request.setAttribute("usersPerPage", usersPerPage);
	        request.setAttribute("previousPage", previousPage);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("nextPage", nextPage);
	        
	        redirect = "/admin_management.jsp";
	        
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

