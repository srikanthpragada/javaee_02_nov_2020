<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	     import="javax.sql.rowset.*" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
<style>
   body { font-family : calibri; font-size:12pt;}
   .heading {background-color:navy;color:white; font-weight:bold}
</style>
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
    %>
    <table style="width:100%" border="1">
       <tr class="heading">
           <th>Id</th>
           <th>Fullname</th>
           <th>Job</th> 
           <th>Salary </th> 
       </tr>
       
       <%
	    while (rowSet.next()) {
		      String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td style='text-align:right'>%s</td></tr>",
		    		     rowSet.getString("id"),
		    		     rowSet.getString("fullname"),
		    		     rowSet.getString("job"),
		    		     rowSet.getString("salary")
		    		    );
		      out.println(row);
	    }
	  %>
    </table>
</body>
</html>