<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Page</title>
</head>
<body>
	<h1>First Page</h1>
	<jsp:include page="second.jsp">
	    <jsp:param name="title" value="Srikanth Technologies" />
	</jsp:include>
	<h3>Again in First</h3>
</body>
</html>