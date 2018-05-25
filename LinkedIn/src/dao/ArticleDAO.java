package dao;

import java.util.List;

import model.Article;

public interface ArticleDAO {

    public List<Article> list();

	public void create(Article article);
	
	public List<Article> getUserArticles(Long id);

}
