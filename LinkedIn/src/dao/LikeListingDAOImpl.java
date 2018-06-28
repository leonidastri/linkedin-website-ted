package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.LikeListing;

public class LikeListingDAOImpl implements LikeListingDAO {

	public LikeListing find(Long id1, Long id2) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT l FROM LikeListing l WHERE l.user.userID = '" + String.valueOf(id1) + "' AND l.listing.listingID = '" + String.valueOf(id2) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeListing> listings = query.getResultList();
		
		if (listings.size() == 1)
			return listings.get(0);
		else
			return null;
	}
	
	public List<LikeListing> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll FROM LikeListing ll", LikeListing.class);
		@SuppressWarnings("unchecked")
		List<LikeListing> likeListings = query.getResultList();  
//		em.getTransaction().commit();
		
		if (likeListings.size() > 0)
			return likeListings;
		else 
			return new ArrayList<LikeListing>();
	}
	
	public void create(LikeListing likeListing) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(likeListing);
	}
	
	public void delete(Long id1, Long id2) {

		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll FROM LikeListing ll WHERE ll.user.userID = '" + String.valueOf(id1) + "' AND ll.listing.listingID = '" + String.valueOf(id2) + "'");
		 
		@SuppressWarnings("unchecked")
		List<LikeListing> listings = query.getResultList();
				
		if (listings.size() == 1)
			em.remove(listings.get(0));
	}
	
	public List<LikeListing> getUserLikeListings(Long userID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll FROM LikeListing ll WHERE ll.user.userID = '" + String.valueOf(userID) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeListing> likeListings = query.getResultList();
		
		if (likeListings.size() > 0)
			return likeListings;
		else 
			return new ArrayList<LikeListing>();
	}
	
	public List<String> getLikeListingUserIDs(Long listingID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll.user.userID FROM LikeListing ll WHERE ll.listing.listingID = '" + String.valueOf(listingID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> userIDs = query.getResultList();
		
		if (userIDs.size() > 0)
			return userIDs;
		else 
			return new ArrayList<String>();
	}

	
	public List<String> getUserLikeListingsListingIDs(Long userID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll.listing.listingID FROM LikeListing ll WHERE ll.user.userID = '" + String.valueOf(userID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> listingIDs = query.getResultList();
		
		if (listingIDs.size() > 0)
			return listingIDs;
		else 
			return new ArrayList<String>();
	}
	
	public List<LikeListing> getLikesOfUserListings(Long listingID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeListing la WHERE la.listing.listingID = '" + String.valueOf(listingID) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeListing> likeListings = query.getResultList();
		
		if (likeListings.size() > 0)
			return likeListings;
		else 
			return new ArrayList<LikeListing>();
	}
	
}
