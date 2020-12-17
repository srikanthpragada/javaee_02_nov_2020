package web;

import java.util.List; 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job,String> {
   
	// Query Derivation
    List<Job> findByTitleContainingIgnoreCase(String title);
}
