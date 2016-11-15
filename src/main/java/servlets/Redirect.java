package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clasesDAO.FactoryDAO;

/**
 * Servlet implementation class Redirect
 */
@WebServlet({"/Materias/*", "/Ofertas/*", "/Eventos/*","/Perdidos/*","/Otros/*"})
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String path=request.getRequestURI().split("/")[2];
		sesion.setAttribute("pathActual",path);
		sesion.setAttribute("pizarra",FactoryDAO.getBoards().getBoardCall(path) );
		if(sesion.getAttribute("pizarra")!=null){//lo normal
			response.sendRedirect("./Home.jsp");
		}else{
			sesion.setAttribute("error","Lo sentimos, ocurrio un error fatal al inicializar la pagina =( avise del fallo al adiministrador del sistema, por favor" );
			response.sendRedirect("./jsps/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

