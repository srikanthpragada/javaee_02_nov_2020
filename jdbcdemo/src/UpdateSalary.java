
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
		PreparedStatement ps = con.prepareStatement("update employees set salary = ? where id = ?");
		ps.setInt(1, 550000); // salary
		ps.setInt(2, 11); // id

		int count = ps.executeUpdate();
		System.out.printf("Updated %d row(s)", count);
		ps.close();
		con.close();
	}

}
