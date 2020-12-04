package query;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

@Entity
class JobCount {
	@Id
	private String id;
	private int count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

public class NativeQueries {
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure("query/hibernate.cfg.xml");
		// c.addAnnotatedClass(JobCount.class);
		Session session = c.buildSessionFactory().openSession();

		List result = session.createSQLQuery("select upper(title), round(minsal,-4) from jobs").list();

		for (Object obj : result) {
			Object[] cols = (Object[]) obj;
			System.out.printf("%-25s %10d\n", cols[0], cols[1]);
		}

		List<Job> jobs = (List<Job>) session.createSQLQuery("select * from jobs where id in (select job from employees group by job having avg(salary) > 750000)")
				                     .addEntity(Job.class).list();
		for (Job j : jobs) {
			System.out.println(j.getTitle());
		}
		
		/*
		 * List summary = session.
		 * createSQLQuery("select job_id, count(*) count from employees group by job_id"
		 * ) .addScalar("job_id", StandardBasicTypes.STRING).addScalar("count",
		 * StandardBasicTypes.INTEGER).list();
		 * 
		 * for (Object row : summary) { Object cols[] = (Object[]) row;
		 * System.out.printf("%-10s %3d\n", cols[0], cols[1]); }
		 * 
		 * List<JobCount> jobCounts = session
		 * .createSQLQuery("select job_id id, count(*) count from employees group by job_id"
		 * ) .addEntity(JobCount.class).getResultList();
		 * 
		 * for (JobCount job : jobCounts) { System.out.printf("%-10s %3d\n",
		 * job.getId(), job.getCount()); }
		 * 
		 */
	}

}
