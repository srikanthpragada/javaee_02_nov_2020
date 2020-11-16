<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Factors</title>
</head>
<body>
	<h2>Factors</h2>
	<form action="listfactors.jsp">
		Number : <input type="number" name="num" value="${param.num}" />
		<p />
		<input type="submit" value="Submit" />
	</form>

	<p></p>

	
		<%
		String input = request.getParameter("num");
		// Do the following if parameter num is found 
		if (input != null) {
			try {
				int num = Integer.parseInt(input);
				out.println("<ul>");
				for (int i = 2; i <= num / 2; i++) {
			      if (num % i == 0)
				      out.println("<li>" + i + "</li>");
				}
				out.println("</ul>");
			} catch (Exception ex) {
				out.println("<h4>Sorry! Invalid number. Please enter valid number!</h4>");
			}
		}
		%>

</body>
</html>