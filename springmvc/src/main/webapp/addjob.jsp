<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Job</title>
</head>
<body>
	<h2>Add Job</h2>
	<sf:form method="post" modelAttribute="job">
		Job Id <br/>
		<sf:input path="id" type="text" required="true" />
		<p></p>
		Job Title <br/>
		<sf:input path="title" maxlength="20" required="true"  autocomplete="off" />
		<p></p>
		Min. Salary <br/>
		<sf:input path="minSal" type="number" required="true"  autocomplete="off" />
		<p></p>
		<input type="submit" Value="Add Job" />
	</sf:form>
	
	<h4>${message}</h4>

</body>
</html>