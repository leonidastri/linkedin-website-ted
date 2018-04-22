package servlets;

import java.io.IOException;

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
@WebServlet("/userRegister")
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
        
        try {
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	String confirmPassword = request.getParameter("confirmPassword");
        	String firstName = request.getParameter("firstName");
        	String lastName = request.getParameter("lastName");
        	String phoneNumber = request.getParameter("phoneNumber");
        	
        	User user = new User();
        	user.setEmail(email);
        	
        	em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
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
