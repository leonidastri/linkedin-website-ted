package dao;

import java.util.List;
import model.Skill;

public interface SkillDAO {

    public List<Skill> list();

	public void create(Skill skill);
	
	public List<Skill> getUserSkills(Long id);

}
