package p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReqScope
 */
@WebServlet("/reqScope")
public class ReqScope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = (String)request.getAttribute("FNAME");
		String lname = (String)request.getAttribute("LNAME");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("This is second page<br><br><b>Request Data</b><br>First Name "+fname+"<br>Last Name "+ lname);
		
		HttpSession session = request.getSession();
		fname = (String)session.getAttribute("FNAME");
		lname = (String)session.getAttribute("LNAME");
		out.println("<br><br><b>Seesion Data</b><br>First Name "+fname+"<br>Last Name "+ lname);
		
		ServletContext context = getServletContext();
		fname = (String)context.getAttribute("NAME1");
		lname = (String)context.getAttribute("NAME2");
		out.println("<br><br><b>Context Data</b><br>First Name "+fname+"<br>Last Name "+ lname);
		out.print("<a href='sessionDemo'>Session Demo</a>");
		out.close();
		
		Cookie cookie = new Cookie("FNAME", fname);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
