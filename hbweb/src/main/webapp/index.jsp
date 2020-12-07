<%@page
	import="org.hibernate.*,org.hibernate.cfg.*, java.util.*, core.*"%>
<html>
<body>
<%
Configuration c = new Configuration();
c.configure(); // load hibernate.cfg.xml

SessionFactory sf = c.buildSessionFactory();
Session s = sf.openSession();

List<Job> jobs = s.createQuery("from Job").list();

for (Job j : jobs) {
	 out.println (j.getTitle() + "<p></p>");
}

s.close();
sf.close();
%>
</body>
</html>
