package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetJob {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		// Eager load
		Job job = s.get(Job.class, "jprog"); // Class and Primary key
		if (job == null)
			System.out.println("Not Found!");
		else {
			System.out.println(job.getClass());
			System.out.println(job.getTitle());
		}

		s.close();
		sf.close();
	}
}
