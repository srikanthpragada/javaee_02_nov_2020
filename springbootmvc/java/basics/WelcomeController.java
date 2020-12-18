package basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("welcome")  // Map URL to method 
	@ResponseBody               // Return value is the response 
	public String welcome() {
		return "<h1 style='color:blue'>Welcome to Spring MVC</h1>";
	}
}
