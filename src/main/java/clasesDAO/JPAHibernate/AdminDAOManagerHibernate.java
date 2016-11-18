package clasesDAO.JPAHibernate;

import clases.Admin;


public class AdminDAOManagerHibernate  extends GenericDAOJPAHibernate<Admin>{
	
	public AdminDAOManagerHibernate(){
		super(Admin.class);
	}

}
