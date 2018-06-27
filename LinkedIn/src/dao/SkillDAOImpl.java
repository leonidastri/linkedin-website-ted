package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Skill;

public class SkillDAOImpl implements SkillDAO {

	public List<Skill> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT s FROM Skill s", Skill.class);
		@SuppressWarnings("unchecked")
		List<Skill> skills = query.getResultList();  
//		em.getTransaction().commit();
		
		if (skills.size() > 0)
			return skills;
		else 
			return new ArrayList<Skill>();
	}
	
	public void create(Skill skill) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(skill);
	}
	
	public List<Skill> getUserSkills(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT s FROM Skill s WHERE s.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Skill> skills = query.getResultList();
		
		if (skills.size() > 0)
			return skills;
		else 
			return new ArrayList<Skill>();
	}
	
	public List<Skill> getOnlyPublicUserSkills(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT s FROM Skill s WHERE s.user.userID = '" + String.valueOf(id) + "' AND s.priv = false");
		
		@SuppressWarnings("unchecked")
		List<Skill> skills = query.getResultList();
		
		if (skills.size() > 0)
			return skills;
		else 
			return new ArrayList<Skill>();
	}
	
}
