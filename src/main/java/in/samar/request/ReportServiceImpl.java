package in.samar.request;

import java.util.List;

import org.springframework.stereotype.Service;

import in.samar.entity.PersonPlan;
import in.samar.repo.PersonPlanRepo;
import in.samar.service.ReportService;


@Service
public class ReportServiceImpl implements ReportService {

	private PersonPlanRepo repo;
	
	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonPlan> search(Searchrequest req) {
		// TODO Auto-generated method stub
		return null;
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
