package jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {
	@Autowired 
	private JobRepo jobRepo;
	
	@RequestMapping("/jobs")
	public String getAllJobs(ModelMap model) {
		Iterable<Job> jobs = jobRepo.findAll();
		model.addAttribute("jobs", jobs);
		return "jobslist";
	}
	

	@RequestMapping("/addjob")
	public String addJob(ModelMap model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "addjob";
	}

	@RequestMapping(value = "/addjob", method = RequestMethod.POST)
	public String addJob(Job job, ModelMap model) {
		jobRepo.save(job);
		job = new Job();  
		model.addAttribute("job", job);
		model.addAttribute("message", "Job has been added!");
		return "addjob";
	}
	
	@RequestMapping(value = "/deletejob")
	public String deleteJob(@RequestParam("id") String id) {
		Optional<Job>  job = jobRepo.findById(id);
		if (job.isPresent())
		   jobRepo.delete(job.get());
		
		return "redirect:jobs";
	}

}
