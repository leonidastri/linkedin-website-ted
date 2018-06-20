package dao;

import java.util.List;

import model.Message;
import model.User;

public interface MessageDAO {

	public List<Message> list();
	
	public void create(Message message);
	
	public List<Message> getUserSentMessages(Long id);
	
	public List<Message> getUserReceivedMessages(Long id);

	public List<Message> getUserConversation(Long senderID, Long receiverID);

	public List<User> getChattingUsers(Long id);
}
