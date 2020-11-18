<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee</title>
</head>
<body>
	<h2>Insert Employee</h2>
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
	%>
	
	<jsp:useBean id="empBean" class="beans.EmployeeBean"  scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="empBean"/>
	<%
	   if (empBean.insertRow())
		   out.println("<h4>Inserted Employee Successfully!");
	   else
		   out.println("<h4>Sorry! Could not insert employee due to error!");
	%>
	
</body>
</html>