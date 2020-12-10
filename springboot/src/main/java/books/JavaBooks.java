package books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component 
@Lazy
public class JavaBooks implements Books {
	
	public JavaBooks() {
        System.out.println("JavaBooks()");		 
	}

	@Override
	public List<String> getTitles() {
		 var titles = new ArrayList<String>();
		 titles.add("Thinking in Java");
		 titles.add("Java Persistence with Hibernate");
		 return titles;
	}
	

}
