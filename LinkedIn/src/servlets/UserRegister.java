package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtain a database connection:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        
        String redirect = "/user.jsp";
        
        try {
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	String confirmPassword = request.getParameter("confirmPassword");
        	String firstName = request.getParameter("firstName");
        	String lastName = request.getParameter("lastName");
        	String phoneNumber = request.getParameter("phoneNumber");
        	
        	User user = new User();
        	user.setEmail(email);
        	if (password.equals(confirmPassword)) {
        		user.setPasswordHashed(password);	// TODO: hash
            	user.setFirstName(firstName);
            	user.setLastName(lastName);
            	user.setPhoneNumber(phoneNumber);
            	
            	// TODO: may need checking
            	em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                
                List<User> userList = em.createQuery("SELECT u FROM user u", User.class).getResultList();
                request.setAttribute("users", userList);
                request.getRequestDispatcher(redirect).forward(request, response);
        	}
        	else {
        		redirect = "signup_error.jsp";
        	}
        }
        finally {
        	 // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
