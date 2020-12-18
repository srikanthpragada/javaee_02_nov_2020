package web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FactorsController {

	@RequestMapping("/factors")
	public String getFactors(ModelMap model, 
			                 @RequestParam(name = "number", required = false) String number) {
		// Find factors only when a number is passed through request param
		if (number != null) {
			int num = Integer.parseInt(number);
			ArrayList<Integer> factors = new ArrayList<>();
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0)
					factors.add(i);
			}
			model.put("number", number);
			model.put("factors", factors);
		}

		return "factors";
	}
}
