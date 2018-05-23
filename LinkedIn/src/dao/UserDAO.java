package dao;

import java.util.List;
import model.User;

public interface UserDAO {

	public User find(Long id);
	
	public User find(String email);
	
	public Boolean changeEmail( String userID, String email);

    public List<User> list();
    
    public User login(String email, String pass);

    public void create(User user);
	
}
