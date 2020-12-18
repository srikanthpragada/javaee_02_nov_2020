package web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jpa.Employee;
import jpa.EmployeeRepo;

@Controller
public class AjaxController {
	@Autowired
	private EmployeeRepo empRepo;
	
	
	@RequestMapping("/quote")
	@ResponseBody 
	public String getQuote() {
		return "Winner never quit! Quitters never win!";
	}
	
	@RequestMapping("/employeename")
	@ResponseBody 
	public String getEmployeeName(@RequestParam("id") int id) {
	     // Get employee 
		Optional<Employee> emp = empRepo.findById(id);
		if (emp.isPresent())
			return  emp.get().getName();
		else
			return ""; 
	}
}
