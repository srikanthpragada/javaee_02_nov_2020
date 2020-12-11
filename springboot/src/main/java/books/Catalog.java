package books;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Catalog {
	// @Autowired
	// @Qualifier("pythonBooks")
	Books books;

	// Constructor Injection
	public Catalog(Books books) {
		System.out.println("Catalog()");
		this.books = books;
	}

	@PostConstruct
	public void init() {
		System.out.println("init() in Catalog");
	}

	@PreDestroy
	public void clearAll() {
		System.out.println("clearAll() in Catalog");
	}

	public void print() {
		for (String title : books.getTitles())
			System.out.println(title);
	}
}
