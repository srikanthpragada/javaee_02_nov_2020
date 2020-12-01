package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetJobWithLoad { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
        
		// Lazy load
		Job job = s.load(Job.class,"jpro"); // Class and Primary key
		System.out.println(job.getClass()); // Proxy class 
		System.out.println(job.getTitle()); // Execute query to retrieve data 
		
		s.close();
		sf.close();
	}
}
