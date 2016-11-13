package clasesDAO.JPAHibernate;

import clases.Board;

public class BoardDAOHibernate extends GenericDAOJPAHibernate<Board>{
	
	public BoardDAOHibernate(){
		super(Board.class);
	}

}
