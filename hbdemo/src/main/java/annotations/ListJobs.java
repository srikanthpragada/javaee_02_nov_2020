package annotations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration().
                 configure("hibernate.cfg.xml").
                 addAnnotatedClass(annotations.Job.class);
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		List<Job> jobs = s.createQuery("from AnnotationJob").list();

		for (Job j : jobs) {
			System.out.printf("%-10s  %-20s %7d\n", j.getId(), j.getTitle(), j.getMinSal());
		}
		
		s.close();
		sf.close();
	
	}
}
