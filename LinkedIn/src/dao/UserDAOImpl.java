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
	public Boolean changeEmail( String userID, String email) {

		EntityManager em = EntityManagerHelper.getEntityManager();
		System.out.println("UPDATE User SET email = '" + email + "' WHERE userID = '" + userID + "'");
		em.createQuery("UPDATE User SET email = '" + email + "' WHERE userID = '" + userID + "'");

		return true;
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
