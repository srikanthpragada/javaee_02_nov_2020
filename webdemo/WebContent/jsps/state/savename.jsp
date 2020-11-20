<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Name</title>
</head>
<body>

<%
   Cookie c = new Cookie("fullname", request.getParameter("fullname"));
   c.setMaxAge(7 * 24 * 60 * 60);  // Seconds
   response.addCookie(c);
   response.sendRedirect("showname.jsp");
%>

</body>
</html>