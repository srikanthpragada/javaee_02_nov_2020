package nonspring;

import java.util.ArrayList;
import java.util.List;

public class JavaBooks implements Books {

	@Override
	public List<String> getTitles() {
		 var titles = new ArrayList<String>();
		 titles.add("Thinking in Java");
		 titles.add("Java Persistence with Hibernate");
		 return titles;
	}
	

}
