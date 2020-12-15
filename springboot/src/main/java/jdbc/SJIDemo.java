package jdbc;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class SJIDemo {
	private SimpleJdbcInsert sji;
	
    // Constructor injection 
	public SJIDemo(DataSource datasource) {
		this.sji = new SimpleJdbcInsert(datasource);
		String [] columns =  {"id","title","minsal"};
		this.sji.withTableName("jobs").usingColumns(columns);
		 
	}

	public void add() {
		HashMap<String, Object> job = new HashMap<>();
		job.put("id", "AD");   // Column name and value 
		job.put("title", "Angular Developer");
		job.put("minsal",1000000);
		int count = sji.execute(job);  // INSERT is executed 
		System.out.printf("\nInserted %d row(s)\n",  count);
		System.out.println("Added Job Successfully!");
	}
}
