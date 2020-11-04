import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddEmployee {

	public static void main(String[] args) throws Exception {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql"))
		{
			Scanner s = new Scanner(System.in);
			// Take input from user
			System.out.print("Enter Name   :");
			String name = s.nextLine();
			System.out.print("Enter Job    :");
			String job = s.nextLine(); 
			System.out.print("Enter Salary :");
			int salary = s.nextInt(); 
		
    		PreparedStatement ps = con.prepareStatement
				    ("insert into employees(fullname,salary,job) values(?,?,?)");
		    ps.setString(1,name);  
		    ps.setInt(2, salary); 
		    ps.setString(3, job);
    		ps.executeUpdate(); // Execute DML 
		    System.out.println("Added Employee Successfully!");
		    ps.close();
	     }// try
	} // main() 
}
