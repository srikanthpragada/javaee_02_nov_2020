package jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private JobRepo jobRepo;

	@RequestMapping("/employees")
	public String getEmployeesByJob(@RequestParam("id") String id, ModelMap model) {
		List<Employee> employees = empRepo.getEmployeesByJob(id);
		model.addAttribute("emps", employees);
		return "employees";
	}

	 
	@RequestMapping("/empbyjob")
	public String employeesByJob(ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		Job job = new Job();
		model.addAttribute("job",job);
		model.addAttribute("jobs", jobs);
		return "empByJob";
	}
	
	@RequestMapping(value = "/empbyjob", method = RequestMethod.POST)
	public String employeesByJob(Job job, ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		model.addAttribute("job",job);
		model.addAttribute("jobs", jobs );
		// Get all employees by given department id
		model.addAttribute("employees",empRepo.getEmployeesByJob(job.getId()));
		return "empByJob";
	}
}
