<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobs List</title>
</head>
<body>
	<h2>Jobs</h2>
	<ul>
		<c:forEach var="job" items="${jobs}">
			<li>${job.id},${job.title} <br />
			    <a href="/employees?id=${job.id}">Employees</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>