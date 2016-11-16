package clasesDAO;

import java.util.Date;

import clases.*;
import clasesDAO.JPAHibernate.*;


public class FactoryDAO {
		
	public static GlobalConfigDAOHibernate getConfig(){
		//return new UsuarioDAOjdbc();
		return new GlobalConfigDAOHibernate();
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
		Config conf=new Config("0");
		FactoryDAO.getConfig().persist(conf);
		
		SuscriptionManager manager=SuscriptionManager.getInstance();
		FactoryDAO.getSuscriptionManager().persist(manager);
		
		
		
		Admin admin = new Admin("admin", "admin", conf, "admin@mail.com");
	    FactoryDAO.getUsers().persist(admin);
	    FactoryDAO.getUsers().persist(new Student("alu", "alu", conf, "alumno@mail.com"));
	    FactoryDAO.getUsers().persist(new Administrative("adm", "adm", conf, "adminstrative@mail.com"));
	    FactoryDAO.getUsers().persist(new Publisher("pub", "pub", conf, "publicador@mail.com"));
	    FactoryDAO.getUsers().persist(new Professor("doc", "doc", conf, "profesor@mail.com"));
	    
	    Comment comment=new Comment("Hello word",admin);
	    FactoryDAO.getComments().persist(comment);
	    
	    Note note=new Note(false,new Date(), admin, "Nota de bienvenida con sorpresa ");
	    note.addComment(comment);
	    FactoryDAO.getNotes().persist(note);
	    
	    
	    Board boardNoticias=new Board("Institucional", "Pizarra de las noticias institucionales de la facultad","institucional");
	    FactoryDAO.getBoards().persist(boardNoticias);
	    
	    Board boardSubjectsFirstYear=new Board("Materias primer año", "Pizarra sobre  las noticias de las materias de primer año","primero");
	    FactoryDAO.getBoards().persist(boardSubjectsFirstYear);
	    
	    Board boardSubjectsSecondYear=new Board("Materias segundo año", "Pizarra sobre  las noticias de las materias de segundo año","segundo");
	    FactoryDAO.getBoards().persist(boardSubjectsSecondYear);
	    
	    Board boardSubjectsThirdYear=new Board("Materias tercer año", "Pizarra sobre  las noticias de las materias de tercer año","tercero");
	    FactoryDAO.getBoards().persist(boardSubjectsThirdYear);
	    
	    Board boardSubjectsFourthYear=new Board("Materias cuarto año", "Pizarra sobre  las noticias de las materias de cuarto año","cuarto");
	    FactoryDAO.getBoards().persist(boardSubjectsFourthYear);
	    
	    Board boardSubjectsFifthYear=new Board("Materias quinto año", "Pizarra sobre  las noticias de las materias de quinto año","quinto");
	    FactoryDAO.getBoards().persist(boardSubjectsFifthYear);
	    
	    Board boardLaboral=new Board("Pizarra con información laboral", "Ofertas de trabajo para los alumnos","ofertas");
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
	
}
