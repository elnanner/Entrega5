package clasesDAO.JPAHibernate;

import clases.Admin;
import clasesDAO.AdminDAO;


public class AdminDAOManagerHibernate  extends GenericDAOJPAHibernate<Admin> implements AdminDAO{
	
	public AdminDAOManagerHibernate(){
		super(Admin.class);
	}

}
