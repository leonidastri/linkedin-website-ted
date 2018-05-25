package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Message;

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
		Query query = em.createQuery("SELECT m FROM Message m WHERE m.senderID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();
		
		if (messages.size() > 0)
			return messages;
		else 
			return null;
	}
	
	public List<Message> getUserReceivedMessages(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Message m WHERE m.receiverID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Message> messages = query.getResultList();
		
		if (messages.size() > 0)
			return messages;
		else 
			return null;
	}

}
