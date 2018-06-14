package dao;

import java.util.List;
import model.Job;

public interface JobDAO {

    public List<Job> list();

	public void create(Job job);
	
	public List<Job> getUserJobs(Long id);

	public List<Job> getOnlyPublicUserJobs(Long id);
}
