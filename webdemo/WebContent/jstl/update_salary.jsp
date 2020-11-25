<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Salary</title>
</head>
<body>
	<h1>Update Employee Salary</h1>
	<form>
		Employee Id <br /> 
		<input type="number" required name="id" value="${param.id}" />
		<p></p>
		New Salary <br /> 
		<input type="number" required name="salary"	value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update" />
	</form>

	<c:if test="${!empty param.id}">
		<!-- catch exception into ex variable -->
		<c:catch var="ex">
			<!--  Connect to MySQL  -->
			<sql:setDataSource var="mysql" driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost:3306/hr" user="root" password="mysql" />

			<sql:update dataSource="${mysql}" var="uc">
 			  update employees set salary = ? where id = ?
                  <sql:param value="${param.salary}" />
				  <sql:param value="${param.id}" />
			</sql:update>
			<c:choose>
				<c:when test="${uc == 1}">
					<h3>Updated Employee Successfully!</h3>
				</c:when>
				<c:otherwise>
					<h3>Employee Id Not Found!</h3>
				</c:otherwise>
			</c:choose>
		</c:catch>

		<!--  if variable ex is not empty then it has an exception -->
		<c:if test="${!empty ex}">
			<h3>Sorry! Error during updation : ${ex.message}</h3>
		</c:if>
	</c:if>

</body>
</html>