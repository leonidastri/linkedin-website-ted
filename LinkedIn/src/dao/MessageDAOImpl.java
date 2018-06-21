package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Message;
import model.User;

public class MessageDAOImpl implements MessageDAO {

	public List<Message> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Message m", Message.class);
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();  
//		em.getTransaction().commit();
        return messages;
	}
	
	public void create(Message message) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(message);
	}
	
	public List<Message> getUserSentMessages(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Message m WHERE m.user1.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();
		
		if (messages.size() > 0)
			return messages;
		else 
			return null;
	}
	
	public List<Message> getUserReceivedMessages(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Message m WHERE m.user2.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();
		
		if (messages.size() > 0)
			return messages;
		else 
			return null;
	}
	
	public List<Message> getUserConversation(Long senderID, Long receiverID) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Message m WHERE (m.user1.userID = '" + String.valueOf(senderID) + "' AND m.user2.userID = '" + String.valueOf(receiverID) + "') OR (m.user1.userID = '" + String.valueOf(receiverID) + "' AND m.user2.userID = '" + String.valueOf(senderID) + "')");
		
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();
		
		/* sort conversation */
		for (int i = 0; i < messages.size()-1; i++) {
			for (int j = 0; j < messages.size()-i-1; j++) {
				if (messages.get(j).getPubDate().after(messages.get(j+1).getPubDate())) {
					Message temp = messages.get(j);
					
					messages.get(j).setMessageID(messages.get(j+1).getMessageID());
					messages.get(j).setText(messages.get(j+1).getText());
					messages.get(j).setPubDate(messages.get(j+1).getPubDate());
					messages.get(j).setUser1(messages.get(j+1).getUser1());
					messages.get(j).setUser2(messages.get(j+1).getUser2());
					
					messages.get(j+1).setMessageID(temp.getMessageID());
					messages.get(j+1).setText(temp.getText());
					messages.get(j+1).setPubDate(temp.getPubDate());
					messages.get(j+1).setUser1(temp.getUser1());
					messages.get(j+1).setUser2(temp.getUser2());
				}
			}
		}
		
		if (messages.size() > 0)
			return messages;
		else 
			return null;
	}
	
	public List<User> getChattingUsers(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT DISTINCT u FROM User u, Message m WHERE ( m.user1.userID = '" + String.valueOf(id) + "' AND u.userID = m.user2.userID) OR (m.user2.userID = '" + String.valueOf(id) + "' AND u.userID = m.user1.userID)");
		
		@SuppressWarnings("unchecked")
		List<User> otherUsers = query.getResultList();
		
		if (otherUsers.size() > 0)
			return otherUsers;
		else 
			return null;
		
	}

}
