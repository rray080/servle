package p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = "Using Post Method to Read Form Data";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		HttpSession session = request.getSession();
		session.setAttribute("FNAME", request.getParameter("first_name"));
		session.setAttribute("LNAME", request.getParameter("last_name"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>First Name</b>: " + request.getParameter("first_name") + "\n" + "  <li><b>Last Name</b>: "
				+ request.getParameter("last_name") + "\n" + "</ul>\n" + "</body></html>");*/
		//out.close();
		
		request.setAttribute("FNAME", request.getParameter("first_name"));
		request.setAttribute("LNAME", request.getParameter("last_name"));
		
		RequestDispatcher rd = request.getRequestDispatcher("reqScope");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
