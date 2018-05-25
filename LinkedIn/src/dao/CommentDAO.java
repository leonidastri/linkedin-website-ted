package dao;

import java.util.List;

import model.Comment;

public interface CommentDAO {

	public List<Comment> list();
	
	public void create(Comment comment);
	
	public List<Comment> getUserComments(Long id);
	
}
