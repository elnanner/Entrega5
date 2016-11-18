package clasesDAO.JPAHibernate;

import clases.Comment;
import clasesDAO.CommentDAO;

	public class CommentDAOHibernate  extends GenericDAOJPAHibernate<Comment> implements CommentDAO{

		public CommentDAOHibernate(){
			super(Comment.class);
		}

}
