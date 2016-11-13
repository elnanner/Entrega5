package clasesDAO.JPAHibernate;

import clases.Config;

public class GlobalConfigDAOHibernate extends GenericDAOJPAHibernate<Config>{
	
	public GlobalConfigDAOHibernate(){
		super(Config.class);
	}

}
