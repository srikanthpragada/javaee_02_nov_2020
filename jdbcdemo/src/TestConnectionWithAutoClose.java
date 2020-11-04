
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectionWithAutoClose {

	public static void main(String[] args) {
		// ARM or try with resources
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql")) {
			System.out.println("Connected To HR Database of MySQL!");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
