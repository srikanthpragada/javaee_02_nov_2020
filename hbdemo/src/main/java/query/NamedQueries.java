package query;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class NamedQueries {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		Session session = c.buildSessionFactory().openSession();
        System.out.println("Costly Employees");
		List<Employee> employees = session.getNamedQuery("costlyEmployees").setParameter("salary", 750000).list();
		for (Employee e : employees) {
			System.out.printf("%-20s %d\n", e.getName(), e.getSalary());
		}

		System.out.println("Important Employees");
		List<Object[]> objects = session.getNamedQuery("importantEmployees")
				                        .setParameter("salary", 800000)
				                        .list();
		
		for (Object[] array : objects) {
			for(Object value : array)
			     System.out.printf(value + " ");
			
			System.out.println();
		}
	}
}
