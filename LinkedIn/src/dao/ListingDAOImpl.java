package dao;

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
        return listings;
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
			return null;
	}
	
}
