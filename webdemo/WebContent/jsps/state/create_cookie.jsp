<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
   Cookie c = new Cookie("city","vizag");
   c.setMaxAge( 7 * 24 * 60 * 60);  // Seconds
   response.addCookie(c);
   out.println("Cookie Created");
%>

</body>
</html>