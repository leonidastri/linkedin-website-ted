package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Education;

public class EducationDAOImpl implements EducationDAO {

	public List<Education> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT e FROM Education e", Education.class);
		@SuppressWarnings("unchecked")
		List<Education> educations = query.getResultList();  
//		em.getTransaction().commit();
        return educations;
	}
	
	public void create(Education education) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(education);
	}
	
	public List<Education> getUserEducation(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT e FROM Education e WHERE e.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Education> educations = query.getResultList();
		
		if (educations.size() > 0)
			return educations;
		else 
			return null;
	}
	
	public List<Education> getOnlyPublicUserEducation(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT e FROM Education e WHERE e.user.userID = '" + String.valueOf(id) + " AND e.priv = false'");
		
		@SuppressWarnings("unchecked")
		List<Education> educations = query.getResultList();
		
		if (educations.size() > 0)
			return educations;
		else 
			return null;
	}
	
}
