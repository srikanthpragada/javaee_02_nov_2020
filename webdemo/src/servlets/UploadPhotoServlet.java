package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadPhoto")
@MultipartConfig
public class UploadPhotoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext ctx = this.getServletContext();
		try {
			Part p1 = request.getPart("photo");
			InputStream is = p1.getInputStream();
			// Create a file with same name in Server's /photos folder
			String filename = p1.getSubmittedFileName();
			System.out.println(filename);
			String target_filename = ctx.getRealPath("/photos/" + filename);
			System.out.println(target_filename);
			FileOutputStream fos = new FileOutputStream(target_filename);
			fos.write(is.readAllBytes());
			fos.close();
			out.println("<h3>Uploaded Successfully!</h3>");
		} catch (Exception ex) {
			out.println("Sorry! Could not save photo due to error!");
			System.out.println("Error -> " + ex.getMessage());
		}
	}
}
