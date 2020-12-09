package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner {
	Books books;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	public Books getBooks() {
		return books;
	}

	@Autowired(required = false)
	@Qualifier("javaBooks")
	public void setBooks(Books books) {
		this.books = books;
		System.out.println("setBooks()");
	}

	public Test() {
		System.out.println("Test()");
	}

	@Override
	public void run(String... args) throws Exception {
		if (this.books != null) {
			System.out.println("Topic : " + this.books.getTopic());
			for (String s : this.books.getBooks())
				System.out.println(s);
		}
	}

}
