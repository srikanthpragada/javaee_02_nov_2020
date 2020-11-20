<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Name</title>
</head>
<body>

	<%
	String fullname = null;
	for (Cookie c : request.getCookies()) {
		if (c.getName().equals("fullname")) {
			fullname = c.getValue();
			break;
		}
	}

	if (fullname == null)
		response.sendRedirect("takename.html");
	else
		out.println("Name = " + fullname);
	%>


</body>
</html>