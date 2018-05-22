package dao;

import java.util.List;
import model.Job;

public interface JobDAO {

    public List<Job> list();

	public void create(Job job);

}
