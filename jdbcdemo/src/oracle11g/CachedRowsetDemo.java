package oracle11g;


import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowsetDemo {

	public static void main(String[] args) throws Exception  {

		CachedRowSet rowSet = new  OracleCachedRowSet();
		rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		rowSet.setUsername("hr");
		rowSet.setPassword("hr");
		rowSet.setCommand("select * from jobs");
		rowSet.execute();

		while (rowSet.next()) {
            System.out.printf("%-10s %s\n", rowSet.getString("job_id"), rowSet.getString("job_title"));
		}

	}

	private static CachedRowSet OracleCachedRowSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
