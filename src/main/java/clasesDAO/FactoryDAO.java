package clasesDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import clases.*;
import clasesDAO.JPAHibernate.*;


public class FactoryDAO {
		
	@Autowired 
	private static /*GlobalConfigDAOHibernate*/ GlobalConfigDAO configDAO;
	
	@Autowired 
	private static BoardDAO boardDAO;
	
	public static GlobalConfigDAOHibernate getConfig(){
		//return new UsuarioDAOjdbc();
		return new GlobalConfigDAOHibernate();
	}

	
	
	public static void test(WebApplicationContext context) {
		FactoryDAO.deleteDB();
		System.out.println("borro bd al principio");
		
		Config conf0=new Config("0");
		Config conf1=new Config("1");
		Config conf2=new Config("2");
		
		configDAO=context.getBean(/*GlobalConfigDAOHibernate.class*/GlobalConfigDAO.class);
		configDAO.persist(conf0);
		//context.getBean(GlobalConfigDAO.class).persist(conf0);
		
		//FactoryDAO.getConfig().persist(conf0);
		configDAO.persist(conf1);
		configDAO.persist(conf2);
		System.out.println("guardando las 3 configuraciones (0,1,2)");
		
		SuscriptionManager manager=SuscriptionManager.getInstance();
		context.getBean(SuscriptionManagerDAO.class).persist(manager);
		System.out.println("persistiendo SuscriptionManager");
		
		
		
		Admin admin = new Admin("admin", "admin", conf0, "admin@mail.com");
		context.getBean(UserDAO.class).persist(admin);
		context.getBean(UserDAO.class).persist(new Student("alu", "alu", conf0, "alumno@mail.com"));
		context.getBean(UserDAO.class).persist(new Administrative("adm", "adm", conf0, "adminstrative@mail.com"));
		context.getBean(UserDAO.class).persist(new Publisher("pub", "pub", conf0, "publicador@mail.com"));
		context.getBean(UserDAO.class).persist(new Professor("doc", "doc", conf0, "profesor@mail.com"));
	    
	    System.out.println("persistiendo los 5 usuarios (admin,alumno,administrativo,publicador,profesor)");
	   
	    Comment comment=new Comment("Hello word",admin);
		context.getBean(CommentDAO.class).persist(comment);
	    System.out.println("persistiendo comentario");
	    
	    Note note=new Note(false,new Date(), admin, "Nota de bienvenida con sorpresa ");
	    note.addComment(comment);
		context.getBean(NoteDAO.class).persist(note);
	    System.out.println("persistiendo nota bienvenida con el comentario y el admin asociados");
	    
	    System.out.println("generando las 10 pizarras (home,institucional, primero...quinto,info lab,eventos, perdidos");
	    Board boardNoticias=new Board("Institucional", "Pizarra de las noticias institucionales de la facultad","institucional");
		context.getBean(BoardDAO.class).persist(boardNoticias);
	    
	    Board boardSubjectsFirstYear=new Board("Materias primer a�o", "Pizarra sobre  las noticias de las materias de primer a�o","primero");
	    context.getBean(BoardDAO.class).persist(boardSubjectsFirstYear);
	    
	    Board boardSubjectsSecondYear=new Board("Materias segundo a�o", "Pizarra sobre  las noticias de las materias de segundo a�o","segundo");
	    context.getBean(BoardDAO.class).persist(boardSubjectsSecondYear);
	    
	    Board boardSubjectsThirdYear=new Board("Materias tercer a�o", "Pizarra sobre  las noticias de las materias de tercer a�o","tercero");
	    context.getBean(BoardDAO.class).persist(boardSubjectsThirdYear);
	    
	    Board boardSubjectsFourthYear=new Board("Materias cuarto a�o", "Pizarra sobre  las noticias de las materias de cuarto a�o","cuarto");
	    context.getBean(BoardDAO.class).persist(boardSubjectsFourthYear);
	    
	    Board boardSubjectsFifthYear=new Board("Materias quinto a�o", "Pizarra sobre  las noticias de las materias de quinto a�o","quinto");
	    context.getBean(BoardDAO.class).persist(boardSubjectsFifthYear);
	    
	    Board boardLaboral=new Board("Pizarra con informaci�n laboral", "Ofertas de trabajo para los alumnos","ofertas");
	    context.getBean(BoardDAO.class).persist(boardLaboral);
	    
	    Board boardEvents=new Board("Pizarra de eventos", "Pizarra sobre  las noticias de eventos que se den en la facultad o relacionados","eventos");
	    context.getBean(BoardDAO.class).persist(boardEvents);
	    
	    Board boardLostProperty=new Board("Objetos perdidos", "Pizarra con los objetos perdidos","perdidos");
	    context.getBean(BoardDAO.class).persist(boardLostProperty);
	    
	    Board board=new Board("Home", "pizarra home","home");
	    board.addNote(note);
	    board.addBoard(boardNoticias);
	    board.addBoard(boardSubjectsFirstYear);
	    board.addBoard(boardSubjectsSecondYear);
	    board.addBoard(boardSubjectsThirdYear);
	    board.addBoard(boardSubjectsFourthYear);
	    board.addBoard(boardSubjectsFifthYear);
	    board.addBoard(boardLaboral);
	    board.addBoard(boardEvents);
	    board.addBoard(boardLostProperty);
	    context.getBean(BoardDAO.class).persist(board);
	    
	    System.out.println("home es la pizarra 'root' y tiene tambien la nota con su respectivo comentario");
	    
	    //para ver si crea mailNotifier
	    manager.addMailNotifier(admin/*"mailUno@mail.com"*/, boardNoticias);
	   // manager.addMailNotifier(/*"mailDos@mail.com"*/, boardNoticias);
	    context.getBean(SuscriptionManagerDAO.class).update(manager);  //si usas persist explota, detached el mailNotif :p
	    
		System.out.println("updateando suscriptionManager con notificadores (mailUno y dos para la pizarra institucional)");
		
		System.out.println("*****************************INICIANDO TEST DE ALTA Y RECUPERACION******************");
		// recuperar los datos insertados
		System.out.println("CONSULTANDO ALTA CONFIGURACIONES");
		if(context.getBean(GlobalConfigDAO.class).getCount()==3){
			System.out.println("- - - -exito cantidad config");
		}else{
			System.out.println("- - - -error cantidad config");
		}
		
		ArrayList<Config> configs=configDAO.getAllWithoutOrder();//context.getBean(GlobalConfigDAOHibernate.class).getAllWithoutOrder(); //OJO NO PUDE PONER CONFIGCOMUN!   //FactoryDAO.getConfig().getAllWithoutOrder();
		for(Integer i=0;i<configs.size();i++){
			if(configs.get(i).getOptionSelected().equals(i.toString())){
				System.out.println("- - - -exito valor config"+i);
			}else{
				System.out.println("- - - -error valor config"+i);
			}
		}
		
		
         System.out.println("CONSULTANDO ALTA DE LAS PIZARRAS Y DATOS DE LA PIZARRA Home");

		if(context.getBean(BoardDAO.class).getCount()==10){
			System.out.println("- - - -exito cantidad boards");
		}else{
			System.out.println("- - - -error cantidad boards");
		}
		
		Board boardLevantada=context.getBean(BoardDAO.class).get(21L);
		
			if(boardLevantada.getName().equals("Home")){
				System.out.println("- - - -exito valor nombre board");
			}else{
				System.out.println("- - - -error valor nombre board");
			}
			
			if(boardLevantada.getNoteList().size()==1){
				System.out.println("- - - -exito cantidad notas");
			}else{
				System.out.println("- - - -error cantidad notas");
			}
			PersistentBag noteList=(PersistentBag) boardLevantada.getNoteList();
			PersistentBag commentList=(PersistentBag) ((Note)noteList.get(0)).getComments();
			if(commentList.size()==1){
				System.out.println("- - - -exito cantidad comment");
			}else{
				System.out.println("- - - -error cantidad comment");
			}
			if(((Comment)commentList.get(0)).getAuthor().getName().equals("admin")){
				System.out.println("- - - -exito el creador del comment es admin");
			}else{
				System.out.println("- - - -error el creador del comment no es admin");
			}
			
	     //System.out.println("borro bd al final");
		//FactoryDAO.deleteDB();
			
			
			
			
			System.out.println("*****************************INICIANDO TEST DE MODIFICACION Y BAJA******************");
	        Board boardPrimeroTest=context.getBean(BoardDAO.class).get(13L);
	        
	        System.out.println(" agregando a pizarra de primer a�o, pizarra adp, con una nota y comentario cantidad boards es: "+boardPrimeroTest.getBoardList().size());
	         
	        Board boardADP=new Board("Pizarra de ADP", "Pizarra sobre  las noticias de la materia adp","adp");
	        
	        
	        Comment commentADP=new Comment("Hola adp",admin);
	        context.getBean(CommentDAO.class).persist(commentADP);
		    System.out.println("persistiendo comentario adp");
		    
		    Note noteADP=new Note(false,new Date(), admin, "Nota de bienvenida ADP ");
		    noteADP.addComment(commentADP);
		    context.getBean(NoteDAO.class).persist(noteADP);
		    System.out.println("persistiendo nota bienvenida en la pizarra adp");
		    
		    boardADP.addNote(noteADP);
		    context.getBean(BoardDAO.class).persist(boardADP);
		    boardPrimeroTest.addBoard(boardADP);
		    
		    System.out.println("updateando board primero con board adp y su contenido");
		    context.getBean(BoardDAO.class).update(boardPrimeroTest);
		    
		    Board boardPrimeroTestLevantada=context.getBean(BoardDAO.class).get(13L);	        
	        System.out.println(" comentario cantidad boards tras updatear es: "+boardPrimeroTestLevantada.getBoardList().size());
		    
	        System.out.println("update texto comentario");
	        commentADP.setText("updated");
	        context.getBean(CommentDAO.class).update(commentADP);
	        Comment commentADPUpdated =context.getBean(CommentDAO.class).get(23L);
	        if(commentADPUpdated.getText().equals("updated")){
	        	 System.out.println("exito al updatear comentario ");
	        }else{
	        	 System.out.println("errror al updatear comentario");
	        }
	        
	        
		    System.out.println("vamos a dar de baja lógica la pizarra nueva, pero antes queremos imprimir el valor de la baja");
	        System.out.println(" baja de la pizarra adp antes del borrado logico (actualiacion) es: "+boardADP.getDown());
	        
	        boardADP.setDown(true);
	        context.getBean(BoardDAO.class).update(boardADP);
	        Board boardADPActualizada=context.getBean(BoardDAO.class).get(25L);
	        System.out.println(" baja de la pizarra adp antes del borrado logico (actualiacion) es: "+boardADPActualizada.getDown());
	        
	        
	}
	
	
	public static UserDAOHibernate getUsers() {
		return new UserDAOHibernate();
	}
	
	public static BoardDAOHibernate getBoards() {
		return new BoardDAOHibernate();
	}
	
	public static SuscriptionManagerDAOHibernate getSuscriptionManager() {
		return new SuscriptionManagerDAOHibernate();
	}
	
	public static CommentDAOHibernate getComments() {
		return new CommentDAOHibernate();
	}
	
	
	public static NoteDAOHibernate getNotes() {
		return new NoteDAOHibernate();
	}

	public static void initialize() {
		// TODO Auto-generated method stub
		Config conf0=new Config("0");
		Config conf1=new Config("1");
		Config conf2=new Config("2");
		FactoryDAO.getConfig().persist(conf0);
		FactoryDAO.getConfig().persist(conf1);
		FactoryDAO.getConfig().persist(conf2);
		
		SuscriptionManager manager=SuscriptionManager.getInstance();
		FactoryDAO.getSuscriptionManager().persist(manager);
		
		
		
		Admin admin = new Admin("admin", "admin", conf0, "admin@mail.com");
	    FactoryDAO.getUsers().persist(admin);
	    FactoryDAO.getUsers().persist(new Student("alu", "alu", conf0, "alumno@mail.com"));
	    FactoryDAO.getUsers().persist(new Administrative("adm", "adm", conf0, "adminstrative@mail.com"));
	    FactoryDAO.getUsers().persist(new Publisher("pub", "pub", conf0, "publicador@mail.com"));
	    FactoryDAO.getUsers().persist(new Professor("doc", "doc", conf0, "profesor@mail.com"));
	    
	    Comment comment=new Comment("Hello word",admin);
	    FactoryDAO.getComments().persist(comment);
	    
	    Note note=new Note(false,new Date(), admin, "Nota de bienvenida con sorpresa ");
	    note.addComment(comment);
	    FactoryDAO.getNotes().persist(note);
	    
	    
	    Board boardNoticias=new Board("Institucional", "Pizarra de las noticias institucionales de la facultad","institucional");
	    FactoryDAO.getBoards().persist(boardNoticias);
	    
	    Board boardSubjectsFirstYear=new Board("Materias primer a�o", "Pizarra sobre  las noticias de las materias de primer a�o","primero");
	    FactoryDAO.getBoards().persist(boardSubjectsFirstYear);
	    
	    Board boardSubjectsSecondYear=new Board("Materias segundo a�o", "Pizarra sobre  las noticias de las materias de segundo a�o","segundo");
	    FactoryDAO.getBoards().persist(boardSubjectsSecondYear);
	    
	    Board boardSubjectsThirdYear=new Board("Materias tercer a�o", "Pizarra sobre  las noticias de las materias de tercer a�o","tercero");
	    FactoryDAO.getBoards().persist(boardSubjectsThirdYear);
	    
	    Board boardSubjectsFourthYear=new Board("Materias cuarto a�o", "Pizarra sobre  las noticias de las materias de cuarto a�o","cuarto");
	    FactoryDAO.getBoards().persist(boardSubjectsFourthYear);
	    
	    Board boardSubjectsFifthYear=new Board("Materias quinto a�o", "Pizarra sobre  las noticias de las materias de quinto a�o","quinto");
	    FactoryDAO.getBoards().persist(boardSubjectsFifthYear);
	    
	    Board boardLaboral=new Board("Pizarra con informaci�n laboral", "Ofertas de trabajo para los alumnos","ofertas");
	    FactoryDAO.getBoards().persist(boardLaboral);
	    
	    Board boardEvents=new Board("Pizarra de eventos", "Pizarra sobre  las noticias de eventos que se den en la facultad o relacionados","eventos");
	    FactoryDAO.getBoards().persist(boardEvents);
	    
	    Board boardLostProperty=new Board("Objetos perdidos", "Pizarra con los objetos perdidos","perdidos");
	    FactoryDAO.getBoards().persist(boardLostProperty);
	    
	    Board board=new Board("Home", "pizarra home","home");
	    board.addNote(note);
	    board.addBoard(boardNoticias);
	    board.addBoard(boardSubjectsFirstYear);
	    board.addBoard(boardSubjectsSecondYear);
	    board.addBoard(boardSubjectsThirdYear);
	    board.addBoard(boardSubjectsFourthYear);
	    board.addBoard(boardSubjectsFifthYear);
	    board.addBoard(boardLaboral);
	    board.addBoard(boardEvents);
	    board.addBoard(boardLostProperty);
	    FactoryDAO.getBoards().persist(board);
	    
	    
	   /* //para ver si crea mailNotifier
	    manager.addMailNotifier("mailUno@mail.com", boardNoticias);
	    manager.addMailNotifier("mailDos@mail.com", boardNoticias);
		FactoryDAO.getSuscriptionManager().update(manager);  //si usas persist explota, disatouched el mailNotif :p
	    */
	    
		System.out.println("inicialice todo!, ponele...");
	}


   private static void deleteDB(){
	  //Configuration configuration=new Configuration();
	  //configuration.setProperty("hibernate.hbm2ddl.auto", "create");	  
	   EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
	   
	   Map<String, String> properties = new HashMap<String, String>(1);
	   properties.put("hibernate.hbm2ddl.auto", "create");
	   emf = Persistence.createEntityManagerFactory("miUP", properties);
       
		EntityManager em = emf.createEntityManager();
		
		
		
	/*	EntityTransaction etx = em.getTransaction();
		etx.begin();
	    em.createQuery("SELECT table FROM "+this.getPersistentClass().getSimpleName()  +" table where delete=0")).getResultList();
		etx.commit();*/
		em.close(); 
			
		  emf = Persistence.createEntityManagerFactory("miUP");
		   
		  
		   emf = Persistence.createEntityManagerFactory("miUP");
	       
			 em = emf.createEntityManager();
		
   }

	
	
	
	
	
	
	
}
