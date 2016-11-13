package clasesDAO.JPAHibernate;

import clases.Comment;



	
	public class CommentDAOHibernate  extends GenericDAOJPAHibernate<Comment>{

		public CommentDAOHibernate(){
			super(Comment.class);
		}

}
