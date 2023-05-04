package in.samar.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.samar.entity.PersonPlan;
import in.samar.request.Searchrequest;

public interface ReportService {

	public List<String> getPlanNames();

	public List<String> getPlanStatus();

	public List<String> getGender();

	public List<PersonPlan> search(Searchrequest req);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response)throws Exception;

}
