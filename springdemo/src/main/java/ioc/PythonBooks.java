package ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
public class PythonBooks implements Books {

	public PythonBooks() {
		System.out.println("PythonBooks()");
	}
	
	@Override
	public List<String> getBooks() {
		ArrayList<String> books = new ArrayList<>();
		books.add("Python Tricks");
		books.add("Python Definite Guide");
		return books;
	}

	@Override
	public String getTopic() {
		return "Python";
	}

}
