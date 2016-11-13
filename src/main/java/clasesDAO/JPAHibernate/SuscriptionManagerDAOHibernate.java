package clasesDAO.JPAHibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import clases.SuscriptionManager;


	public class SuscriptionManagerDAOHibernate  extends GenericDAOJPAHibernate<SuscriptionManager>{

		public SuscriptionManagerDAOHibernate(){
			super(SuscriptionManager.class);
		}

		
		
	

}
