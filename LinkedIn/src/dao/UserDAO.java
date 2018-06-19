package dao;

import java.util.List;
import model.User;

public interface UserDAO {

	public User find(Long id);
	
	public User find(String email);
	
	public List<User> find(String name, String surname);
	
	public void changeEmail( String userID, String email);

	public void changePassword( String userID, String passwordHashed);
	
    public List<User> list();
    
    public List<String> listUserIDs();
    
    public User login(String email, String pass);

    public void create(User user);
    
    public void changeCvPath( String userID, String newCvPath);
    
    public void changePhotoPath( String userID, String newPhotoPath);
	
}
