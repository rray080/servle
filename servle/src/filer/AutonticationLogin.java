package filer;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AutonticationLogin
 */
@WebFilter(urlPatterns="/Login")
public class AutonticationLogin implements Filter {

  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Enumeration<String> params = req.getParameterNames();
		String n = null;
		User user = new User();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
			if(value==null || value.trim().equals("")){
				n=name;
				break;
			}
			if(name.equalsIgnoreCase("userName"))
				user.setName(value);
			else if(name.equalsIgnoreCase("password"))
				user.setPass(value);
		}
		if(n!=null){
			req.getSession().setAttribute("ERROR", n+" can't blank");
			res.sendRedirect("login.jsp");
		}
		else{
			req.setAttribute("PARAM", user);
			chain.doFilter(request, response);
		}
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
