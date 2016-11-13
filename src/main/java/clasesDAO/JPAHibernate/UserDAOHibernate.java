package clasesDAO.JPAHibernate;


import clases.User;

public class UserDAOHibernate  extends GenericDAOJPAHibernate<User>{

	public UserDAOHibernate(){
		super(User.class);
	}
	
}
