import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateMinSalWithParams {

	public static void main(String[] args) throws Exception {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql"))
		{
			Scanner s = new Scanner(System.in);
			// Take input from user
			System.out.print("Enter ID          :");
			String id = s.nextLine(); 
			System.out.print("Enter Min. Salary :");
			int minsal = s.nextInt(); 
		
			String cmd = "update jobs set minsal = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(cmd);
			ps.setInt(1, minsal);
			ps.setString(2,id);
			
		    int count = ps.executeUpdate(); // Execute DML
		    if (count == 1)
		         System.out.println("Updated Job Successfully!");
		    else
		    	 System.out.println("Sorry! Id not found!");
		    ps.close();
	     }// try
	} // main() 
}
