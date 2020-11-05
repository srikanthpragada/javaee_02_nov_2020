import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateMinSal {

	public static void main(String[] args) throws Exception {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql"))
		{
			Scanner s = new Scanner(System.in);
			// Take input from user
			System.out.print("Enter ID          :");
			String id = s.nextLine(); 
			System.out.print("Enter Min. Salary :");
			int minsal = s.nextInt(); 
		
			String cmd = "update jobs set minsal = " + minsal + " where id ='" + id + "'";
			System.out.println("Executing " + cmd);
			
			Statement st = con.createStatement();
		    int count = st.executeUpdate(cmd); // Execute DML
		    if (count == 1)
		         System.out.println("Updated Job Successfully!");
		    else
		    	 System.out.println("Sorry! Id not found!");
		    st.close();
	     }// try
	} // main() 
}
