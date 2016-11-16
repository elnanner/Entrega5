package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Board;
import clasesDAO.FactoryDAO;

/**
 * Servlet implementation class Redirect
 */
@WebServlet( "/ver/*"   /*{"/Materias/*", "/Ofertas/*", "/Eventos/*","/Perdidos/*","/Otros/*"}*/)
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
		//System.out.println("hola redirect  uri "+request.get);
		System.out.println("hola redirect  uri "+request.getRequestURI());
		System.out.println("hola redirect  url "+request.getRequestURL());
		HttpSession sesion = request.getSession(true);
		String url=request.getRequestURI().split("/")[3];
		System.out.println("url  es "+url);
		//String path=boardNameAndId.split(".")[0];
		//String id=boardNameAndId.split(".")[1];
		//cambio un poquito porque el nombre al ser compuesto nos caga, uso el .Id como separador identificador y listo
		Board board=FactoryDAO.getBoards().getBoardUrl(url);
		
		//sesion.setAttribute("pizarra",FactoryDAO.getBoards().get(Long.parseLong(id) ) );		
		if(sesion.getAttribute("pizarra")!=null){//lo normal
			sesion.setAttribute("pathActual",url);
			sesion.setAttribute("pizarra",board/*board.getName()*/ );
			
			response.sendRedirect("../Home.jsp"); //agregue un .
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

