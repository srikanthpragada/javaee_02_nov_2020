<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="javax.sql.rowset.*,java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<h2>Add Employee</h2>
	<form method="post">
		Fullname <br /> <input type="text" name="fullname" value="${param.fullname}" size="30" />
		<p></p>
		Job <br /> <input type="text" name="job" size="10" value="${param.job}" />
		<p></p>
		Salary <br /> <input type="number" name="salary" size="10" value="${param.salary}" />
		<p></p>
		<input type="submit" value="Add Employee" />
	</form>

	<%
	String fullname = request.getParameter("fullname");
	if (fullname == null) // no data is passed 
		return; // return from jspService(), terminating JSP 
	try {
		Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver for MySQL
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql");
		PreparedStatement ps = con.prepareStatement("insert into employees(fullname,salary,job) values(?,?,?)");
		ps.setString(1, fullname);
		ps.setInt(2, Integer.parseInt(request.getParameter("salary")));
		ps.setString(3, request.getParameter("job"));
		ps.executeUpdate(); // Execute DML 
		out.println("<h4>Added Employee Successfully!</h4>");
		ps.close();
		con.close();
	} catch (Exception ex) {
		System.out.println(ex);
		out.println("<h4>Sorry! Could not add employee due to error!</h4>");
	}
		
	%>
</body>
</html>