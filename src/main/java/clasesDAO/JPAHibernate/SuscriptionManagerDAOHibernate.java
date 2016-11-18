package clasesDAO.JPAHibernate;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import clases.SuscriptionManager;
import clasesDAO.SuscriptionManagerDAO;


	public class SuscriptionManagerDAOHibernate  extends GenericDAOJPAHibernate<SuscriptionManager> implements SuscriptionManagerDAO{

		public SuscriptionManagerDAOHibernate(){
			super(SuscriptionManager.class);
		}

		
		public SuscriptionManager getManager(){
			SuscriptionManager result =null;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
			EntityManager em = emf.createEntityManager();
			EntityTransaction etx = em.getTransaction();
			etx.begin();
		    result=(SuscriptionManager) (em.createQuery("SELECT table FROM "+SuscriptionManager.class.getSimpleName()  +" table")).getResultList().get(0);
		    System.out.println("tamanio manager "+(em.createQuery("SELECT table FROM "+SuscriptionManager.class.getSimpleName()  +" table")).getResultList().size());
		    etx.commit();
			em.close(); 	
			System.out.println(" cosulta manager id "+result.getId());
			return result;
		}
		
	

}
