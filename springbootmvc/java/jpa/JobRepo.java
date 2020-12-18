package jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<Job,String> {
    
	// Query Derivation
    List<Job> findByTitleContainingIgnoreCase(String title);
}
 