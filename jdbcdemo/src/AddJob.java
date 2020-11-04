import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AddJob {

	public static void main(String[] args) throws Exception {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql"))
		{
			Scanner s = new Scanner(System.in);
			// Take input from user
			System.out.print("Enter ID          :");
			String id = s.nextLine(); 
			System.out.print("Enter Title       :");
			String title = s.nextLine(); 
			System.out.print("Enter Min. Salary :");
			int minsal = s.nextInt(); 
		
			String cmd = "insert into jobs values('" + id + "','" + title + "'," + minsal + ")";
			System.out.println("Executing " + cmd);
			
			Statement st = con.createStatement();
		    st.executeUpdate(cmd); // Execute DML 
		    System.out.println("Added Job Successfully!");
		    st.close();
	     }// try
	} // main() 
}
