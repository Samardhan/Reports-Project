package in.samar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.samar.entity.PersonPlan;

public interface PersonPlanRepo extends JpaRepository<PersonPlan, Integer>{

	
	@Query("select distinct (planName) from PersonPlan")
	public List<String> getPlanNames();
	
	@Query("select distinct (planStatus) from PersonPlan")
	public List<String> getPlanStatus();
	
	@Query("select distinct (gender) from PersonPlan")
	public List<String> getGender();
	
	
	
}
