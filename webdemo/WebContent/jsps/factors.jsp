<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Factors</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
	%>

	<h2>Factors <%=num%>  </h2>
	<ul>
		<%
			for (int i = 2; i <= num / 2; i++) {
			   if (num % i == 0)
				 out.println("<li>" + i + "</li>");
		    }
		%>
	</ul>
</body>
</html>