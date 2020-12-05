package annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddJob { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		c.addAnnotatedClass(annotations.Job.class);
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Job job = new Job();      // Transient 
		job.setId("sppro");
		job.setTitle("Spring Programmer");
		job.setMinSal(500000);
		
		Transaction trans = s.beginTransaction();
		s.save(job);           
	    trans.commit();
		s.close();              
		sf.close();
	}
}
