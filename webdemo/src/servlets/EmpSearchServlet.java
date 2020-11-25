package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import com.google.gson.Gson;

@WebServlet("/ajax/empsearch")
public class EmpSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// search string is name
		String name = request.getParameter("name");
		response.setContentType("text/json");

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Load JDBC Driver
			CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
			rowSet.setUsername("root");
			rowSet.setPassword("mysql");
			rowSet.setCommand("select * from employees where fullname like ?");
			rowSet.setString(1, "%" + name + "%");
			rowSet.execute();

			// Convert each row to an object of Employee class
			ArrayList<Employee> emps = new ArrayList<>();
			while (rowSet.next()) {
				emps.add(new Employee(rowSet.getString("fullname"), rowSet.getString("job"), rowSet.getInt("salary")));
			}
			rowSet.close();

			// Convert Java ArrayList of Employee objects to Json array of objects
			Gson gson = new Gson();
			response.getWriter().println(gson.toJson(emps));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.getWriter().println("[]");
		}
	}

}
