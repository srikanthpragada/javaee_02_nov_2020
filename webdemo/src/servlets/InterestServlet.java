package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/interest")
public class InterestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int amount = Integer.parseInt(request.getParameter("amount"));
		int days = Integer.parseInt(request.getParameter("days"));

		double interest;

		if (days < 365)
			interest = (amount * 0.05) / (days / 365.0);
		else
			interest = (amount * 0.06) / (days / 365.0);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.printf("<h2>Interest for %d amount for %d days is %.2f </h1>", amount, days, interest);

	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
