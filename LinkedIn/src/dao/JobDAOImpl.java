package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Job;

public class JobDAOImpl implements JobDAO {

	public List<Job> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT j FROM Job j", Job.class);
		@SuppressWarnings("unchecked")
		List<Job> jobs = query.getResultList();  
//		em.getTransaction().commit();
        return jobs;
	}
	
	public void create(Job job) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(job);
	}
	
}
