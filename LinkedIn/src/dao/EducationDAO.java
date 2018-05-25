package dao;

import java.util.List;
import model.Education;

public interface EducationDAO {

    public List<Education> list();

	public void create(Education education);
	
	public List<Education> getUserEducation(Long id);

}
