<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using Cookie</title>
</head>
<body>
City = ${cookie.city.value}

<p></p>

<%
    String city = null;
    for (Cookie c : request.getCookies()) {
    	if(c.getName().equals("city"))
    	{
    		city = c.getValue();
    		break;
    	}
    }
   
    if (city == null)
    	out.println("City not known");
    else
    	out.println("City = " + city);
%>

</body>
</html>