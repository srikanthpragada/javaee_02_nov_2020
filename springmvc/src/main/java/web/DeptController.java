package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
public class DeptController {
	@Autowired
	private DeptRepo repo;

	@RequestMapping("/depts")
	public String getAllDept(ModelMap model) {
		Iterable<Department> depts = repo.findAll();
		model.addAttribute("depts", depts);
		return "deptslist";
	}

}
