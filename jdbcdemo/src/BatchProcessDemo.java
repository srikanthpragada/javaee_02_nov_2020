

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessDemo {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
		con.setAutoCommit(false);  // Start transaction 
		Statement stmt = con.createStatement();
		try {
			// Add command to batch 
			stmt.addBatch("update employees set salary=salary + 25000 where salary <= 500000");
			// Add another command to batch 
			stmt.addBatch("update employees set salary=salary + 50000 where salary > 500000");
			int[] uc = stmt.executeBatch();// execute batch of commands 
			con.commit();
			for (int i = 0; i < uc.length; i++) {
				System.out.println(i + ":" + uc[i]);
			} // end of for loop
		} catch (BatchUpdateException ex) {
			System.out.println("Batch Update Exception :" + ex.getMessage());
			con.rollback();
		}
	}
}
