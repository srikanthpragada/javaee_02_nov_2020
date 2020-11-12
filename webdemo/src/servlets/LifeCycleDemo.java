package servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleDemo extends HttpServlet {
	private int count = 0;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init");
	}

	public void destroy() {
		System.out.println("Destory");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       count++;
       response.getWriter().println("Count = " + count);
	}

}
