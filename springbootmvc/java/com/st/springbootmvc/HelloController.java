package com.st.springbootmvc;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello"; // View Name i.e. it will be /hello.jsp
	}

	@RequestMapping("/greet")
	public String greet(ModelMap model,
			            @RequestParam(name = "user", required = false) String user) {
		int hour = LocalDateTime.now().getHour();
		String msg = "Good Evening";
		if (hour < 12)
			msg = "Good Morning";
		else if (hour < 17)
			msg = "Good Afternoon";

		if (user == null)
			user = "Guest";
		model.put("message", msg + " " + user);
		return "greet"; // View Name i.e. it will be /greet.jsp
	}
}
