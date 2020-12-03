package onetomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListJobs {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetomany/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		Job job =  s.get(Job.class,"jpro");
		System.out.println(job.getTitle());
		
		for (Employee e : job.getEmployees())
			System.out.println(e.getName());
		
		s.close();
		sf.close();
	}
}
