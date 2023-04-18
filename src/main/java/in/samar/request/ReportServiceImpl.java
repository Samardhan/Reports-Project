package in.samar.request;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

		PersonPlan entity = new PersonPlan();

		if (null != req.getPlanName() && "".equals(getPlanNames())) {

			entity.setPlanName(req.getPlanName());

		}

		if (null != req.getPlanStatus() && "".equals(getPlanStatus())) {

			entity.setPlanName(req.getPlanStatus());

		}
		
		if(null != req.getGender() && "".equals(getGender())) {
			
			entity.setGender(req.getGender());
			
			}

		return repo.findAll(Example.of(entity));
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
