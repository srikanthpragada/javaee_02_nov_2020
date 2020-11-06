
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
		System.out.println(con.getClass());
		System.out.println("Connected To HR Database of MySQL!");
		Statement st = con.createStatement();
		System.out.println(st.getClass());
		con.close();
	}
}
