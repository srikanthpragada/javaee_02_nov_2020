package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/greet", "/wish" })
public class GreetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		if(name == null)  // name parameter not found 
			name = "Guest";
		
        int hour = LocalDateTime.now().getHour();
		String message = "Good Evening!";
		if(hour < 12)
			message = "Good Morning!";
		else
			if(hour < 17)
				 message = "Good Afternoon!";
		
		pw.println("<h1>" + name + ", " +  message + "</h1>");
			
	}

}
