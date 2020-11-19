<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second Page</title>
</head>
<body>
	<h1>Second Page</h1>
	Number is ${param.num}
	<p></p>
	Name passed to page1 is ${param.name}
	<p></p>
	Title = ${requestScope.title}
</body>
</html>