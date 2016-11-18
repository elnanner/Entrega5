package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clases.Admin;
import clases.Config;
import clases.Professor;
import clases.Publisher;
import clases.Student;
import clases.SuscriptionManager;
import clases.User;
import clasesDAO.FactoryDAO;
import clasesPrivadas.Validator;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/jsps/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String userName=request.getParameter("usuario");
		String password=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		String tipoUser=request.getParameter("tipoUsuario");
		if(!password.equals(password2)){
			//rebotamos, claves distintas
			sesion.setAttribute("mensajeError","Las claves no son iguales"/*board.getName()*/ );
			//response.sendRedirect("./AltaUsuario.jsp");
		}
		//se validan los datos recibidos en el request
		ArrayList<String> resultValidator=Validator.validarUsuario(userName, password, email);
		if(resultValidator.get(0).equals("false")){
			sesion.setAttribute("mensajeError",resultValidator.get(1)/*board.getName()*/ );
			//response.sendRedirect("./AltaUsuario.jsp");
		}
		sesion.setAttribute("mensajeError",resultValidator.get(1)/*board.getName()*/ );
		
		//se valida que se haya ingresado eltipo de usuario
		if(tipoUser.trim().equals("") || tipoUser ==null){
			sesion.setAttribute("mensajeError",resultValidator.get(1)+"-Se debe elegir algun tipo de usuario." );
		}
		
		if(resultValidator.get(0).equals("true") && (tipoUser!=null) && (password.equals(password2)) ){
		
		SuscriptionManager.getInstance().setInstance(FactoryDAO.getSuscriptionManager().getManager());
		System.out.println("manager id "+SuscriptionManager.getInstance().getId());
        switch (tipoUser) {
            case "adm":
            	    
        		 //FactoryDAO.getUsers().persist(new Admin(userName, password,  FactoryDAO.getConfig().getAllWithoutOrder().get(0), email));
        		 sesion.setAttribute("mensajeError","" );
        		 response.sendRedirect("./AltaUsuario.jsp");
                 break;
            case "alu":  
        		 //FactoryDAO.getUsers().persist(new Student(userName, password, FactoryDAO.getConfig().getAllWithoutOrder().get(0), email)); 
        		 sesion.setAttribute("mensajeError","" );
     			 response.sendRedirect("./AltaUsuario.jsp");
                 break;
            case "pro":  
        		//FactoryDAO.getUsers().persist(new Professor(userName, password, FactoryDAO.getConfig().getAllWithoutOrder().get(0), email)); 
        		 sesion.setAttribute("mensajeError","" );
     			 response.sendRedirect("./AltaUsuario.jsp");
                 break;
            case "pub":  
        		 //FactoryDAO.getUsers().persist(new Publisher(userName, password, FactoryDAO.getConfig().getAllWithoutOrder().get(0), email)); 
        		 sesion.setAttribute("mensajeError","" );
     			 response.sendRedirect("./AltaUsuario.jsp");
                 break;
          
            default:
            	// sesion.setAttribute("mensajeError","Tipo de usuario inexistente" );
     			 response.sendRedirect("./AltaUsuario.jsp");
                 break;
        }
		}else{
			response.sendRedirect("AltaUsuario.jsp");
		}
	}

}
