<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource 
    var="mysql" 
    driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/hr" 
	user="root" 
	password="mysql" />

<sql:query var="jobs" dataSource="${mysql}">
      select upper(id) as id, title, minsal
      from jobs 
      order by id
</sql:query>

<h1>Jobs</h1>
<ul>
	<c:forEach var="job" items="${jobs.rows}">
		<li>${job.id},${job.title},${job.minsal} </li>
	</c:forEach>
</ul>
