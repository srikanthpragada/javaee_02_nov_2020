

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowsetDemo {

	public static void main(String[] args) throws Exception  {

		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("mysql");
		rowSet.setCommand("select * from employees");
		rowSet.execute();

		while (rowSet.next()) {
            System.out.printf("%-20s %8d %-5s\n", 
            		 rowSet.getString("fullname"), 
            		 rowSet.getInt("salary"),
            		 rowSet.getString("job"));
		}

	}

}
