package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Article;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public Article find(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Article a WHERE a.articleID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Article> articles = query.getResultList();
		
		if (articles.size() == 1)
			return articles.get(0);
		else
			return null;
	}

	public List<Article> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Article a", Article.class);
		@SuppressWarnings("unchecked")
		List<Article> articles = query.getResultList();  
//		em.getTransaction().commit();
        return articles;
	}
	
	public void create(Article article) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(article);
	}
	
	public List<Article> getUserArticles(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Article a WHERE a.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Article> articles = query.getResultList();
		
		if (articles.size() > 0)
			return articles;
		else 
			return new ArrayList<Article>();
	}
	
	public List<Article> getOtherUsersArticles(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Article a WHERE NOT a.user.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Article> articles = query.getResultList();
		
		if (articles.size() > 0)
			return articles;
		else 
			return null;
	}

}
