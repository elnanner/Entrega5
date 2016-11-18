package clasesDAO.JPAHibernate;

import clases.Note;
import clasesDAO.NoteDAO;


public class NoteDAOHibernate  extends GenericDAOJPAHibernate<Note> implements NoteDAO{

		public NoteDAOHibernate(){
			super(Note.class);
		}

}
