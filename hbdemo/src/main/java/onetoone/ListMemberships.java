package onetoone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListMemberships {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("onetoone/hibernate.cfg.xml");

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
	 
		Membership m =  s.load(Membership.class, 1);
		Employee e = m.getEmployee();
		System.out.printf("%s - %s",m.getType(), e.getName());
		s.close();
		sf.close();
	}
}
