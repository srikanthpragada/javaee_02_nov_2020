<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<h1>Employees By Job</h1>
<form>
	Job <input type="text" name="jobid" value="${param.jobid}" /> 
	<input type="submit" value="Employees" />
</form>


<c:if test="${!empty param.jobid}">
	<sql:setDataSource var="mysql" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/hr" user="root" password="mysql" />

	<sql:query var="emplist" dataSource="${mysql}">
      select *
      from employees
      where job = ?
         <sql:param value="${param.jobid}" />
	</sql:query>


	<c:choose>
		<c:when test="${emplist.rowCount == 0}">
			<h3>Sorry! No Employees Found!</h3>
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach var="emp" items="${emplist.rows}">
					<li>${emp.id},${emp.fullname},${emp.salary}
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>

</c:if>
