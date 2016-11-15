package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.User;

/**
 * Servlet Filter implementation class publicadorAdminProfesorPermisos
 */
@WebFilter({"/redirectFormAltaPublicacion","/agregarPublicacion","/jsps/FormularioAgregarPublicacion.jsp","/jsps/AltaPublicacion.jsp"})
public class publicadorAdminProfesorPermisos implements Filter {

    /**
     * Default constructor. 
     */
    public publicadorAdminProfesorPermisos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//HttpSession sesion = req.getSession(true);
		HttpSession sesion = req.getSession(true);
		User user=(User)sesion.getAttribute("user");
		//System.out.println(user.getClass());
		if(user==null){
			System.out.println("nulllllllll");
			//si no tiene permisos lo fletamos...
			sesion.setAttribute("user", null);
			sesion.setAttribute("error", null);
			res.sendRedirect("./Login.jsp");
			return; //MUY RARO pero funca....
		}
		//User user=(User)sesion.getAttribute("user");
		if(user.getType().equals("adm") || user.getType().equals("pub") || user.getType().equals("doc")){
			//revisar permisos del pub y del doc....sobre la pizarra
			System.out.println(user.getType());
			System.out.println("todo bien permisos en filtro doc pub adm");
			chain.doFilter(request, response);
		}else{
			//si no tiene permisos lo fletamos...
			sesion.setAttribute("user", null);
			sesion.setAttribute("error", null);
			res.sendRedirect("./Login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}