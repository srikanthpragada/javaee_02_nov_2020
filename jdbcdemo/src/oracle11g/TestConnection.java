package oracle11g;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		System.out.println(con.getClass());
		System.out.println("Connected To Oracle Database 11g XE!");
		con.close();
	}
}
