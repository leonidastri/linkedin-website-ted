package dao;

import java.util.List;

import model.Connection;

public interface ConnectionDAO {

	public List<Connection> list();
	
	public void create(Connection connection);
	
	public List<Connection> getUserConnections(Long id);
	
	public List<Connection> getUserUnansweredConnectionsRequests(Long id);

	public Connection getConnection(Long id1, Long id2);

	public List<String> getConnectedUsersIDs(Long id1);
	
	public List<String> getNotConnectedUsersIDs(Long id1);
	
	public void connectionChangeStatus(Long id1, Long id2, String change);
}
