package dao;

import java.util.List;

import model.Connection;

public interface ConnectionDAO {

	public List<Connection> list();
	
	public void create(Connection connection);
	
	public List<Connection> getUserConnections(Long id);
	
	public List<Connection> getUserUnansweredConnectionsRequests(Long id);

}
