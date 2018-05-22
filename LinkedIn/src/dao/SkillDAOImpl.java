package dao;

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
        return skills;
	}
	
	public void create(Skill skill) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(skill);
	}
	
}
