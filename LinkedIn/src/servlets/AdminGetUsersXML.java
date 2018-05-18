package servlets;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.AllUsers;
import model.User;

/**
 * Servlet implementation class AdminGetUsersXML
 */
@WebServlet("/GetUsersXML")
public class AdminGetUsersXML extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("AdminGetUsersXML doGet IN");
		HttpSession session = request.getSession();
		String redirect = "admin_homepage.jsp";
		
		UserDAO dao = new UserDAOImpl();
		
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSS");

		File file = new File("./users" + sdf.format(cal.getTime()) + ".xml");
		
		if (isAdmin) {
			List<User> users = dao.list();
			List<User> selectedUsers = new ArrayList<User>();
			@SuppressWarnings("unchecked")
			Vector<Boolean> checked = (Vector<Boolean>) session.getAttribute("checked");
			
			/* get selected users */
			for(int i = 0; i < users.size(); i++)
				if (checked.get(i))
					selectedUsers.add(users.get(i));
			
			if ( selectedUsers.size() > 0 ) {

				AllUsers allUsers = new AllUsers();
				allUsers.setUsers(selectedUsers);
				
				try {
					//Marshalling
					JAXBContext jaxbContext = JAXBContext.newInstance(AllUsers.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					jaxbMarshaller.marshal(allUsers, file);
					jaxbMarshaller.marshal(allUsers, System.out);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				session.setAttribute("succMsg", "success");
			}
			else {
				session.setAttribute("errorMsg", "no selected users");
			}
		}
		else {
			redirect = "start_page.jsp";
			session.setAttribute("errorMsg", "no authorization");
		}
	
		request.getRequestDispatcher(redirect).forward(request, response);
	
		System.out.println("AdminGetUsersXML doGet OUT");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
