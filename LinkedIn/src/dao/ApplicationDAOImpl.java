package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Application;

public class ApplicationDAOImpl implements ApplicationDAO {

	public List<Application> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Application a", Application.class);
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();  
//		em.getTransaction().commit();
        return applications;
	}
	
	public void create(Application application) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(application);
	}
	
	public List<Application> getUserApplications(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Application a WHERE a.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();
		
		if (applications.size() > 0)
			return applications;
		else 
			return null;
	}
	
	public List<Application> getUserUnansweredApplications(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Listing l, Application a WHERE l.user.userID = '" + String.valueOf(id) + "' AND l.listingID = a.listing.listingID AND a.accepted = false AND a.rejected = false");
		
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();
		
		if (applications.size() > 0)
			return applications;
		else 
			return null;
	}
	
	public List<Application> getListingUnansweredApplications(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Application a WHERE a.listing.listingID = '" + String.valueOf(id) + "' AND a.accepted = false AND a.rejected = false");
		
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();
		
		if (applications.size() > 0)
			return applications;
		else 
			return null;
	}

	public List<Application> getUserAcceptedApplications(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Listing l, Application a WHERE l.user.userID = '" + String.valueOf(id) + "' AND l.listingID = a.listing.listingID AND a.accepted = false AND a.rejected = false");
		
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();
		
		if (applications.size() > 0)
			return applications;
		else 
			return null;
	}
	
	public Application getApplication(Long id1, Long id2) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Application a WHERE a.user.userID = '" + String.valueOf(id1) + "' AND a.listing.listingID = '" + String.valueOf(id2) + "'");
		
		@SuppressWarnings("unchecked")
		List<Application> applications = query.getResultList();
		
		if (applications.size() == 1)
			return applications.get(0);
		else 
			return null;
	}
	
	public void applicationChangeStatus(Long id1, Long id2, String acceptApplication) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		Application application = getApplication(id1, id2);
		Application app = em.find(Application.class, application.getApplicationID());
		
		if( acceptApplication.equals("true") ) {
			app.setAccepted(true);
		}
		else {
			app.setRejected(true);
		}
	}
	
}
