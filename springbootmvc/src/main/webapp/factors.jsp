<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Factors</title>
</head>
<body>
	<h1>Factors</h1>
	<form action="factors" method="post">
		Number <input type="number" name="number" value="${number}" /> <input
			type="submit" value="Factors" />
	</form>

	<ul>
		<c:forEach var="n" items="${factors}">
			<li>${n}</li>
		</c:forEach>
	</ul>
</body>
</html>