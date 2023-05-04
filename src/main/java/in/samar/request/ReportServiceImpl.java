package in.samar.request;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import in.samar.entity.PersonPlan;
import in.samar.repo.PersonPlanRepo;
import in.samar.service.ReportService;
import in.samar.util.EmailUtils;
import in.samar.util.ExcelGenerator;
import in.samar.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private PersonPlanRepo repo;

	@Autowired
	private EmailUtils email;

	@Autowired
	private ExcelGenerator excel;

	@Autowired
	private PdfGenerator pdf;

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

		if (null != req.getPlanName() && !"".equals(req.getPlanName())) {

			entity.setPlanName(req.getPlanName());
			System.out.println();

		}

		if (null != req.getPlanStatus() && !"".equals(req.getPlanStatus())) {

			entity.setPlanStatus(req.getPlanStatus());

		}

		if (null != req.getGender() && !"".equals(req.getGender())) {

			entity.setGender(req.getGender());

		}

		if (req.getStartDate() != null && !req.getStartDate().equals("")) {

			String startdate = req.getStartDate();

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate start = LocalDate.parse(startdate, format);

			entity.setStartDate(start);
		}

		if (req.getEndDate() != null && !req.getEndDate().equals("")) {

			String enddate = req.getEndDate();

			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate end = LocalDate.parse(enddate, format);

			entity.setEndDate(end);
		}
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File f = new File("Reports.xls");

		List<PersonPlan> plans = repo.findAll();

		excel.generate(response, plans, f);

		String to = "kampallysamardhan@gmail.com";
		String subject = "Reports";
		String body = "<h1>Reports Excel File</h1>";
		email.sendmail(to, subject, body, f);

		f.delete();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse resp) throws Exception {

		File f = new File("Reports.pdf");

		List<PersonPlan> plans = repo.findAll();

		pdf.generate(resp, plans, f);
		String to = "kampallysamardhan@gmail.com";
		String subject = "Reports";
		String body = "<h1>Reports PDF File</h1>";
		email.sendmail(to, subject, body, f);

		f.delete();

		return true;
	}

}
