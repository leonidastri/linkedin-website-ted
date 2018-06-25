package dao;

import java.util.List;

import model.Application;

public interface ApplicationDAO {

	public List<Application> list();
	
	public void create(Application application);
	
	public List<Application> getUserApplications(Long id);
	
	public List<Application> getUserUnansweredApplications(Long id);
	
	public List<Application> getListingUnansweredApplications(Long id);

	public Application getApplication(Long id1, Long id2);
	
	public void applicationChangeStatus(Long id1, Long id2, String change);

	public List<Application> getUserAcceptedApplications(Long id);
}
