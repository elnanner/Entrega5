package clasesDAO.JPAHibernate;

import clases.Config;
import clasesDAO.GlobalConfigDAO;

public class GlobalConfigDAOHibernate extends GenericDAOJPAHibernate<Config> implements GlobalConfigDAO{
	
	public GlobalConfigDAOHibernate(){
		super(Config.class);
	}

}
