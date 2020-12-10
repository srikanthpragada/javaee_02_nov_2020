package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Catalog {
	@Autowired 
	// @Qualifier("pythonBooks")
	Books books;

	public Catalog() {
		System.out.println("Catalog()");
	}

	public void print() {
		for (String title : books.getTitles())
			System.out.println(title);
	}
}
