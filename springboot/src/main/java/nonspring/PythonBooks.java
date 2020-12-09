package nonspring;

import java.util.ArrayList;
import java.util.List;

public class PythonBooks implements Books {

	@Override
	public List<String> getTitles() {
		 var titles = new ArrayList<String>();
		 titles.add("Python Tricks");
		 titles.add("Django in Action");
		 return titles;
	}
	

}
