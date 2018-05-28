package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Comment;

public class CommentDAOImpl implements CommentDAO {

	public List<Comment> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Comment c", Comment.class);
		@SuppressWarnings("unchecked")
		List<Comment> educations = query.getResultList();  
//		em.getTransaction().commit();
        return educations;
	}
	
	public void create(Comment comment) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(comment);
	}
	
	public List<Comment> getUserComments(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Comment c WHERE c.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Comment> comments = query.getResultList();
		
		if (comments.size() > 0)
			return comments;
		else 
			return null;
	}
	
}
