
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","mysql");
        
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs order by minsal");
		
		// next() returns true on success, false on failure
		while(rs.next()) {
			System.out.printf("%-20s %8d\n", rs.getString("title"), rs.getInt("minsal"));
		}

		rs.close();
		st.close();
		con.close();
	}

}
