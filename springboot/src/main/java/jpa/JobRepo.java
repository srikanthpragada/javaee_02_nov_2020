package jpa;

import java.util.List; 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job,String> {
   
	// Custom query using JPQL
	@Query("from Job j where j.minSal > ?1")   
	List<Job> getCostlyJobs(int minsal);
	
	// Native Query
	@Query(value="select avg(minsal) from jobs", nativeQuery=true)
	int  getAvgMinSalary();
	
	// Query Derivation 
	List<Job> getByTitleContaining(String title);
	
	// Query Derivation 
    int countByMinSal(int minSal);
}
