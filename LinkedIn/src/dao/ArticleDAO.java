package dao;

import java.util.List;

import model.Article;

public interface ArticleDAO {

	public Article find(Long id);

    public List<Article> list();

	public void create(Article article);
	
	public List<Article> getUserArticles(Long id);
	
	public List<Article> getOtherUsersArticles(Long id);

}
