package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogWithSetter {
 	Books books;

 
	public Books getBooks() {
		return books;
	}

	// Setter Injection 
    @Autowired 
	public void setBooks(Books books) {
		this.books = books;
		System.out.println("setBooks()");
	}


	public void print() {
		for (String title : books.getTitles())
			System.out.println(title);
	}
}
