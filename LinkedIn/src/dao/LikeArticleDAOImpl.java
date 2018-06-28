package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.LikeArticle;

public class LikeArticleDAOImpl implements LikeArticleDAO {

	public LikeArticle find(Long id1, Long id2) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(id1) + "' AND la.article.articleID = '" + String.valueOf(id2) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeArticle> articles = query.getResultList();
		
		if (articles.size() == 1) {
			System.out.println("hey there");
			return articles.get(0);
		}else
			return null;
	}
	
	public List<LikeArticle> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la", LikeArticle.class);
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();  
//		em.getTransaction().commit();
		
		if (likeArticles.size() > 0)
			return likeArticles;
		else 
			return new ArrayList<LikeArticle>();
	}
	
	public void create(LikeArticle likeArticle) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(likeArticle);
	}
	
	public void delete(Long id1, Long id2) {

		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(id1) + "' AND la.article.articleID = '" + String.valueOf(id2) + "'");
		 
		@SuppressWarnings("unchecked")
		List<LikeArticle> articles = query.getResultList();
				
		if (articles.size() == 1)
			em.remove(articles.get(0));
	}
	
	public List<LikeArticle> getUserLikeArticles(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();
		
		if (likeArticles.size() > 0)
			return likeArticles;
		else 
			return new ArrayList<LikeArticle>();
	}

	public List<LikeArticle> getLikesOfUserArticles(Long articleID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la FROM LikeArticle la WHERE la.article.articleID = '" + String.valueOf(articleID) + "'");
		
		@SuppressWarnings("unchecked")
		List<LikeArticle> likeArticles = query.getResultList();
		
		if (likeArticles.size() > 0)
			return likeArticles;
		else 
			return new ArrayList<LikeArticle>();
	}
	
	public List<String> getLikeArticleUserIDs(Long articleID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la.user.userID FROM LikeArticle la WHERE la.article.articleID = '" + String.valueOf(articleID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> userIDs = query.getResultList();
		
		if (userIDs.size() > 0)
			return userIDs;
		else 
			return new ArrayList<String>();
	}

	
	public List<String> getUserLikeArticlesArticleIDs(Long userID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT la.article.articleID FROM LikeArticle la WHERE la.user.userID = '" + String.valueOf(userID) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> articleIDs = query.getResultList();
		
		if (articleIDs.size() > 0)
			return articleIDs;
		else 
			return new ArrayList<String>();
	}
	
}
