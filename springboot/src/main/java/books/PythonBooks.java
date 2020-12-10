package books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class PythonBooks implements Books {

	public PythonBooks() {
		System.out.println("PythonBooks()");
	}

	@Override
	public List<String> getTitles() {
		var titles = new ArrayList<String>();
		titles.add("Python Tricks");
		titles.add("Django in Action");
		return titles;
	}

}
