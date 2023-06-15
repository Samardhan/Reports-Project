package in.samar.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.samar.entity.PersonPlan;
import in.samar.request.Searchrequest;
import in.samar.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;

	@PostMapping("/search")
	public String handleSearch(Searchrequest search, Model model) {

		

		List<PersonPlan> data = service.search(search);
		model.addAttribute("plans", data);
		model.addAttribute("search", search);

		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {

		Searchrequest search = new Searchrequest();

		model.addAttribute("search", search);
		init(model);

		return "index";

	}

	private void init(Model model) {

		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
		model.addAttribute("gender", service.getGender());
	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse resp) throws Exception {

		resp.setContentType("application/octet-stream");

		resp.addHeader("content-Disposition", "attachment;filename=Reports.xls");

		service.exportExcel(resp);
	}

	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse resp) throws Exception {
		resp.setContentType("application/pdf");

		resp.addHeader("content-Disposition", "attachment;filename=Reports.pdf");

		service.exportPdf(resp);

	}
}
