package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public User find(Long id) {
//		EntityManager em = EntityManagerHelper.getEntityManager();
//		User user = em.find(User.class, id); 
//        return user;
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userID = '" + String.valueOf(id) + "'");
		System.out.println("SELECT u FROM User u WHERE u.userID = '" + String.valueOf(id) + "'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		
		if (users.size() == 1) {
			System.out.println("find userID A");
			return users.get(0);
		}
		else {
			System.out.println("find userID B");
			return null;
		}
	}
	
	@Override
	public User find(String email) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = '" + email + "'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		
		if (users.size() == 1) {
			System.out.println("find email A");
			return users.get(0);
		}
		else {
			System.out.println("find email B");
			return null;
		}
	}
	
	@Override
	public List<User> find(String name, String surname) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = null;
		
		if( !name.equals("emptyName") && !surname.equals("emptySurname") ) {
			System.out.println("a");
			query = em.createQuery("SELECT u FROM User u WHERE u.firstName = '" + name + "'AND u.lastName = '" + surname + "'");			
		}
		else if( !name.equals("emptyName") && surname.equals("emptySurname")) {
			System.out.println("b");
			query = em.createQuery("SELECT u FROM User u WHERE u.firstName = '" + name + "'");
		}
		else if( name.equals("emptyName") && !surname.equals("emptySurname") ) {
			System.out.println("c");
			query = em.createQuery("SELECT u FROM User u WHERE u.lastName = '" + surname + "'");
		} 
		else {
			System.out.println("d");
			query = em.createQuery("SELECT u FROM User u");
		}
		
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		
		if (users.size() > 0) {
			System.out.println("found users");
			return users;
		}
		else {
			System.out.println("found no users");
			return null;
		}
	}
	
	@Override
	public void changeEmail( String userID, String email) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class ,userID);
		user.setEmail(email);
	}

	@Override
	public void changePassword( String userID, String passwordHashed) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class ,userID);
		user.setPasswordHashed(passwordHashed);
	}
	
	@Override
	public void changeCvPath( String userID, String newCvPath) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class ,userID);
		user.setCvPath(newCvPath);
	}
	
	@Override
	public void changePhotoPath( String userID, String newPhotoPath) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class ,userID);
		user.setPhotoPath(newPhotoPath);
	}
	
	@Override
	public List<User> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u", User.class);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();  
//		em.getTransaction().commit();
        return users;
	}
	
	@Override
	public List<String> listUserIDs() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT u.userID FROM User u", User.class);
		@SuppressWarnings("unchecked")
		List<String> userIDs = query.getResultList();  
//		em.getTransaction().commit();
        return userIDs;
	}
	
	@Override
	public User login(String email, String pass) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = '" + email + "' and u.passwordHashed = '" + pass + "'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		
		if (users.size() == 1) {
			System.out.println("login A");
			return users.get(0);
		}
		else {
			System.out.println("login B");
			return null;
		}
	}

	@Override
	public void create(User user) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
//		em.getTransaction().begin();
		em.persist(user);
//		em.getTransaction().commit();
//		em.flush();

   	 // Close the database connection:
//		if (em.getTransaction().isActive())
//			em.getTransaction().rollback();
//		em.close();
	}
	
}
