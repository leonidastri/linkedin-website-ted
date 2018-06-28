package dao;

import java.util.List;

import model.LikeArticle;

public interface LikeArticleDAO {

    public List<LikeArticle> list();

	public void create(LikeArticle likeArticle);
	
	public List<LikeArticle> getUserLikeArticles(Long id);
	
	public List<LikeArticle> getLikesOfUserArticles(Long articleID);
	
	public List<String> getLikeArticleUserIDs(Long articleID);
	
	public List<String> getUserLikeArticlesArticleIDs(Long userID);
	
	public void delete(Long id1, Long id2);
	
	public LikeArticle find(Long id1, Long id2);
}
