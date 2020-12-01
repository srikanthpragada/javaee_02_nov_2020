package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddJob { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Job job = new Job();      // Transient 
		job.setId("hbpro");
		job.setTitle("Hibernate Programmer");
		job.setMinSal(500000);

		
		Transaction trans = s.beginTransaction();
		s.save(job);             // Insert into JOBS table   -  Transient to Persistent
		System.out.println("Inserted!");
		trans.commit();
		System.out.println("Committed!");
		s.close();               // Detached 
		sf.close();
	}
}
