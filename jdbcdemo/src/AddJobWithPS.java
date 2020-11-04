import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddJobWithPS {

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
		
    		PreparedStatement ps = con.prepareStatement("insert into jobs values(?,?,?)");
		    ps.setString(1,id);  
		    ps.setString(2, title); 
		    ps.setInt(3, minsal);
    		ps.executeUpdate(); // Execute DML 
		    System.out.println("Added Job Successfully!");
		    ps.close();
	     }// try
	} // main() 
}
