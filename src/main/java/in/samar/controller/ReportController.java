package in.samar.controller;

import java.util.List;

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
	public String handleSearch(Searchrequest request, Model model) {

		System.out.println(request);

		List<PersonPlan> plans = service.search(request);
		model.addAttribute("plans", plans);

		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model) {

		init(model);

		return "index";

	}

	private void init(Model model) {

		Searchrequest search = new Searchrequest();

		model.addAttribute("search", search);
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
		model.addAttribute("gender", service.getGender());
	}
}
