<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	     import="javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
</head>
<body>
	<h2>Employees</h2>
	<%
	Class.forName("com.mysql.jdbc.Driver");   // Load JDBC Driver for MySQL
	CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
	rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
	rowSet.setUsername("root");
	rowSet.setPassword("mysql");
    rowSet.setCommand("select * from employees");
	rowSet.execute();

	while (rowSet.next()) {
		out.println(rowSet.getString("fullname") + "<br/>");
	}
	%>

</body>
</html>