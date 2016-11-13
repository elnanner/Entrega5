package clasesDAO.JPAHibernate;

import clases.Note;


public class NoteDAOHibernate  extends GenericDAOJPAHibernate<Note>{

		public NoteDAOHibernate(){
			super(Note.class);
		}

}
