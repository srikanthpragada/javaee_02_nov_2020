package ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Catalog {
	@Autowired
	@Qualifier("javaBooks")
	Books books;

	public Catalog() {
		System.out.println("Catalog()");
		System.out.println(this.books);
	}
	
	@PostConstruct 
	public void init() {
		System.out.println(this.books);	
	}
	
	@PreDestroy 
	public void destory() {
		System.out.println("Catalog is being destroyed!");	
	}
}
