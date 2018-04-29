package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	public User find(long id);

    public List<User> list();
    
    public User login(String email, String pass);

    public void create(User user);
	
}
