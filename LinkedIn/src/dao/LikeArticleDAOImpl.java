package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.LikeArticle;

public class LikeArticleDAOImpl implements LikeArticleDAO {

	public List<LikeArticle> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la", LikeArticle.class);
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();  
//		em.getTransaction().commit();
        return likeArticles;
	}
	
	public void create(LikeArticle likeArticle) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(likeArticle);
	}
	
	public List<LikeArticle> getUserLikeArticles(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();
		
		if (likeArticles.size() > 0)
			return likeArticles;
		else 
			return null;
	}

	public List<LikeArticle> getLikesOfUserArticles(Long articleID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.article.articleID = '" + String.valueOf(articleID) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();
		
		if (likeArticles.size() > 0)
			return likeArticles;
		else 
			return null;
	}
	
	public List<String> getLikeArticleUserIDs(Long articleID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la.user.userID FROM LikeArticle la WHERE la.article.articleID = '" + String.valueOf(articleID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> userIDs = query.getResultList();
		
		if (userIDs.size() > 0)
			return userIDs;
		else 
			return null;
	}

	
	public List<String> getUserLikeArticlesArticleIDs(Long userID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la.article.articleID FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(userID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> articleIDs = query.getResultList();
		
		if (articleIDs.size() > 0)
			return articleIDs;
		else 
			return null;
	}
	
}
