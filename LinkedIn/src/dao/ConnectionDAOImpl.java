package dao;

import java.util.ArrayList;
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
	
	public List<Connection> getUserUnansweredConnectionsRequests(Long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Connection c WHERE c.user1.userID = '" + String.valueOf(id) + "' AND c.accepted = false AND c.rejected = false");
		
		@SuppressWarnings("unchecked")
		List<Connection> connections = query.getResultList();
		
		if (connections.size() > 0)
			return connections;
		else 
			return null;
	}

	public Connection getConnection(Long id1, Long id2) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Connection c WHERE c.user1.userID = '" + String.valueOf(id1) + "' AND c.user2.userID = '" + String.valueOf(id2) + "'");
		
		@SuppressWarnings("unchecked")
		List<Connection> connections = query.getResultList();
		
		if (connections.size() == 1)
			return connections.get(0);
		else 
			return null;
	}
	
	public List<String> getConnectedUsersIDs(Long id1) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c.user2.userID FROM Connection c WHERE c.user1.userID = '" + String.valueOf(id1) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> connections = query.getResultList();
		
		if (connections.size() > 0)
			return connections;
		else
			return null;
	}
	
	public List<String> getNotConnectedUsersIDs(Long id1) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT c.user2.userID FROM Connection c WHERE c.user1.userID = '" + String.valueOf(id1) + "'");
		
		@SuppressWarnings("unchecked")
		List<String> connections = query.getResultList();
		
		UserDAO userDAO = new UserDAOImpl();
		List<String> allUsers = userDAO.listUserIDs();
		
		List<String> nonConnections = new ArrayList<String>();
		
		for (String u : allUsers)
			if (!connections.contains(u))
				nonConnections.add(u);
		
		if (nonConnections.size() > 0)
			return nonConnections;
		else
			return null;
	}
	
	public void connectionChangeStatus(Long id1, Long id2, String acceptFriend) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		Connection connection = getConnection(id1, id2);
		Connection con = em.find(Connection.class, connection.getConnectionID());
		
		if( acceptFriend.equals("true") ) {
			con.setAccepted(true);
		}
		else {
			con.setRejected(true);
		}
	}
}
