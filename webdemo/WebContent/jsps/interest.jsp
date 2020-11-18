<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Interest Calculation</h1>
	<form action="interest.jsp" method="post">
		Deposit Amount <br /> <input type="number" name="amount" value="${param.amount}" />
		<p></p>
		No. of Days <br /> <input type="number" name="days"  value="${param.days}" />
		<p></p>
		<input type="submit" value="Calculate" />
	</form>

    <%
       if (request.getParameter("amount") == null)
    	   return;
    %>
    
    <jsp:useBean id="interestBean" class="beans.InterestBean" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="interestBean"/>
    
    <%
        interestBean.calculate();
    %>
    
    <h4>Interest = <jsp:getProperty property="interest" name="interestBean"/></h4>
    <h4>Interest = ${interestBean.interest}</h4>

</body>
</html>