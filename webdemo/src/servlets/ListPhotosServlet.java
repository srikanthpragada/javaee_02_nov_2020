package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listphotos")
public class ListPhotosServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext ctx = this.getServletContext();
		try {
			File folder = new File(ctx.getRealPath("/photos"));
	 		for (File file : folder.listFiles())
				out.printf("<img style='width:200px;height:200px' src='photos/%s' /><p/>",file.getName());
		} catch (Exception ex) {
			System.out.println("Error -> " + ex.getMessage());
		}
	}
}
