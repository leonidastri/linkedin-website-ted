package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Listing;

public class ListingDAOImpl implements ListingDAO {

	@Override
	public Listing find(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT l FROM Listing l WHERE l.listingID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Listing> listings = query.getResultList();
		
		if (listings.size() == 1)
			return listings.get(0);
		else
			return null;
	}

	public List<Listing> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT l FROM Listing l", Listing.class);
		@SuppressWarnings("unchecked")
		List<Listing> listings = query.getResultList();  
//		em.getTransaction().commit();
		
		if (listings.size() > 0)
			return listings;
		else 
			return new ArrayList<Listing>();
	}
	
	public void create(Listing listing) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(listing);
	}
	
	public List<Listing> getUserListings(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT l FROM Listing l WHERE l.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Listing> listings = query.getResultList();
		
		if (listings.size() > 0)
			return listings;
		else 
			return new ArrayList<Listing>();
	}
	
	public List<Listing> getOtherUsersListings(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT l FROM Listing l WHERE NOT l.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Listing> listings = query.getResultList();
		
		if (listings.size() > 0)
			return listings;
		else 
			return new ArrayList<Listing>();
	}
	
	public List<Listing> getConnectedUsersListings(Long id) {
		ConnectionDAO connectionDAO = new ConnectionDAOImpl();
		List<String> userIDs = connectionDAO.getConnectedUsersIDs(id);
		
		List<Listing> listings = new ArrayList<Listing>();
		
		for (String userID : userIDs) {
			EntityManager em = EntityManagerHelper.getEntityManager();
			Query query = em.createQuery("SELECT l FROM Listing l WHERE l.user.userID = '" + userID + "'");
			
			@SuppressWarnings("unchecked")
			List<Listing> temp = query.getResultList();
			
			if (temp.size() == 1)
				listings.add(temp.get(0));
			else
				System.out.println("getConnectedUsersListings: Error, temp > 1");
		}
		
		if (listings.size() > 0)
			return listings;
		else 
			return new ArrayList<Listing>();
	}
	
	public List<Listing> getNotConnectedUsersListings(Long id) {
		ConnectionDAO connectionDAO = new ConnectionDAOImpl();
		List<String> userIDs = connectionDAO.getNotConnectedUsersIDs(id);
		
		List<Listing> listings = new ArrayList<Listing>();
		
		for (String userID : userIDs) {
			EntityManager em = EntityManagerHelper.getEntityManager();
			Query query = em.createQuery("SELECT l FROM Listing l WHERE l.user.userID = '" + userID + "'");
			
			@SuppressWarnings("unchecked")
			List<Listing> temp = query.getResultList();
			
			if (temp.size() == 1)
				listings.add(temp.get(0));
			else
				System.out.println("getNotConnectedUsersListings: Error, temp > 1");
		}
		
		if (listings.size() > 0)
			return listings;
		else 
			return new ArrayList<Listing>();
	}
	
}
