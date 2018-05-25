package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.LikeListing;

public class LikeListingDAOImpl implements LikeListingDAO {

	public List<LikeListing> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll FROM LikeListing ll", LikeListing.class);
		@SuppressWarnings("unchecked")
		List<LikeListing> likeListings = query.getResultList();  
//		em.getTransaction().commit();
        return likeListings;
	}
	
	public void create(LikeListing likeListing) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(likeListing);
	}
	
	public List<LikeListing> getUserLikeListings(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT ll FROM LikeListing ll WHERE ll.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeListing> likeListings = query.getResultList();
		
		if (likeListings.size() > 0)
			return likeListings;
		else 
			return null;
	}

}
