package p;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextDemo
 */
@WebServlet("/ContextDemo")
public class ContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name1 = getServletContext().getInitParameter("name1");
		String name2 = getServletConfig().getServletContext().getInitParameter("name2");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(name1+"   "+name2);
		out.close();
		
		getServletContext().setAttribute("NAME1", name1);
		getServletContext().setAttribute("NAME2", name2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
