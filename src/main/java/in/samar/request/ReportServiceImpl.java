package in.samar.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.samar.entity.PersonPlan;
import in.samar.repo.PersonPlanRepo;
import in.samar.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private PersonPlanRepo repo;

	@Override
	public List<String> getPlanNames() {

		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<String> getGender() {
		List<String> gender = repo.getGender();
		return gender;
	}

	@Override
	public List<PersonPlan> search(Searchrequest req) {
		
		return repo.findAll();
	}

	@Override
	public void exportExcel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exportPdf() {
		// TODO Auto-generated method stub

	}

}
