package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Connection;

public class ConnectionDAOImpl implements ConnectionDAO {

	public List<Connection> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Connection c", Connection.class);
		@SuppressWarnings("unchecked")
		List<Connection> connections = query.getResultList();  
//		em.getTransaction().commit();
        return connections;
	}
	
	public void create(Connection connection) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(connection);
	}
	
	public List<Connection> getUserConnections(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Connection c WHERE c.user1.userID = '" + String.valueOf(id) + "' OR c.user2.userID = '" + String.valueOf(id) + "'");
		
		@SuppressWarnings("unchecked")
		List<Connection> connections = query.getResultList();
		
		if (connections.size() > 0)
			return connections;
		else 
			return null;
	}

}
