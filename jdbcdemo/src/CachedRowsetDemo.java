

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetDemo {

	public static void main(String[] args) throws Exception  {

		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		System.out.println(rowSet.getClass());
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		// rowSet.setCommand("select * from employees");
		rowSet.setCommand("select fullname, salary, title from  employees join jobs on (employees.job = jobs.id)");
		rowSet.execute();

		while (rowSet.next()) {
            System.out.printf("%-20s %8d %-5s\n", 
            		 rowSet.getString("fullname"), 
            		 rowSet.getInt("salary"),
            		 rowSet.getString("title"));
		}

	}

}
