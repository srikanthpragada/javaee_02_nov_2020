package rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jpa.Job;
import jpa.JobRepo;

@RestController
@RequestMapping("/rest/job")
public class RestJobController {

	@Autowired
	JobRepo jobRepo;

	@GetMapping() // For Http GET request
	public Iterable<Job> getAllJobs() {
		return jobRepo.findAll();
	}

	@GetMapping("/{id}") // For Http GET request with id
	public Job getOneDept(@PathVariable("id") String id) {
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent())
			return job.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Id Not Found"); // 404
	}

	@PostMapping() // For Http POST request
	public Job addJob(Job job) {
		try {
			// check whether job id is already present
			// if so, throw exception
			jobRepo.save(job);
			return job;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data"); // 400

		}
	}

	@DeleteMapping("/{id}") // For Http DELETE request
	public void deleteJob(@PathVariable("id") String id) {
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			try {
				jobRepo.delete(job.get());
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR); // 500
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Id Not Found!");
		}
	}

	@PutMapping("/{id}") // For Http PUT request
	public Job updateJobWithPut(@PathVariable("id") String id, Job newJob) {
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			try {
				Job dbJob = job.get();
				dbJob.setTitle(newJob.getTitle());
				jobRepo.save(dbJob); // Update
				return dbJob;
			} catch (Exception ex) {
				System.out.println("Error  " + ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR); // 500
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Id Not Found!");
		}
	}

 
	@PatchMapping("/{id}")
	public Job updateJobWithPatch(@PathVariable("id") String id, Job newJob) {
		Optional<Job> job = jobRepo.findById(id);
		if (job.isPresent()) {
			try {
				Job dbJob = job.get();
				dbJob.setTitle(newJob.getTitle());
				jobRepo.save(dbJob); // Update
				return dbJob;
			} catch (Exception ex) {
				System.out.println("Error  " + ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR); // 500
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Id Not Found!");
		}
	}
}
