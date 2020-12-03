package onetomany;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListEmployees {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetomany/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		List<Employee> employees = s.createQuery("from Employee").getResultList();
		for(Employee e : employees) {
		    System.out.printf("%-20s %s\n",e.getName(),e.getJob().getTitle());
		}
		s.close();
		sf.close();
	}
}
