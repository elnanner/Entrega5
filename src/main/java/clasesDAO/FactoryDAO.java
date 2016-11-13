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
	    
	    Note note=new Note(false, new Date(), admin, "Nota de bienvenida con sorpresa ");
	    note.addComment(comment);
	    FactoryDAO.getNotes().persist(note);
	    
	    
	    Board boardNoticias=new Board("Institucional", "Pizarra de las noticias institucionales de la facultad");
	    FactoryDAO.getBoards().persist(boardNoticias);
	    
	    Board board=new Board("Home", "pizarra home");
	    board.addNote(note);
	    board.addBoard(boardNoticias);
	    FactoryDAO.getBoards().persist(board);
	    
	    
	    
		System.out.println("inicialice todo!, ponele...");
	}
	
}
