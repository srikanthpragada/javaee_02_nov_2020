package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeBean {
	private String fullname, job;
	private int salary;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public boolean insertRow() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver for MySQL
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
			PreparedStatement ps = con.prepareStatement
					  ("insert into employees(fullname,salary,job) values(?,?,?)");
			ps.setString(1, fullname);
			ps.setInt(2, salary);
			ps.setString(3, job);
			ps.executeUpdate(); // Execute DML 
		    ps.close();
			con.close();
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

}
