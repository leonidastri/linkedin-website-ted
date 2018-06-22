package dao;

import java.util.ArrayList;
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
	
	public List<Comment> getArticleComments(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Comment c WHERE c.article.articleID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Comment> comments = query.getResultList();
		
		if (comments.size() > 0)
			return comments;
		else 
			return null;
	}
	
	public List<String>  getArticleCommentsUserIDs(Long articleID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c.user.userID FROM Comment c WHERE c.article.articleID = '" + String.valueOf(articleID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> userIDs = query.getResultList();
		
		if (userIDs.size() > 0)
			return userIDs;
		else 
			return null;
	}

	
	public List<String> getUserCommentsArticleIDs(Long userID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c.article.articleID FROM Comment c WHERE c.user.userID = '" + String.valueOf(userID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> articleIDs = query.getResultList();
		
		if (articleIDs.size() > 0)
			return articleIDs;
		else 
			return new ArrayList<String>();
	}
	
}
