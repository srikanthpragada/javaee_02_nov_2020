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

<%
   request.setAttribute("title","Srikanth Technologies");
%>

<jsp:forward page="page2.jsp">
   <jsp:param value="100" name="num"/>
</jsp:forward>

</body>
</html>