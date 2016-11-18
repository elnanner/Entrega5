package clasesDAO.JPAHibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import clases.Board;
import clases.User;

public class UserDAOHibernate  extends GenericDAOJPAHibernate<User>{

	public UserDAOHibernate(){
		super(User.class);
	}
	
	public Boolean credentialsLogin(String userName,String pass){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q=em.createQuery("SELECT name from "+User.class.getSimpleName() +" where name = ?1 and password = ?2 ");
		q.setParameter(1,userName);//SANITIZAR!
		q.setParameter(2,pass);//SANITIZAR!
		System.out.println(" user pass "+userName+" "+pass+ " resultado "+q.getResultList().size());
		Boolean result=q.getResultList().size()>0; //probando....
		etx.commit();
		em.close();		
        return result;
	}
	

	
	public User login(String userName,String pass){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q=em.createQuery("SELECT u from "+User.class.getSimpleName() +" u where name = ?1 and password = ?2 ");
		q.setParameter(1,userName);//SANITIZAR!
		q.setParameter(2,pass);//SANITIZAR!
		User user=(User)q.getResultList().get(0); //fijarse antes que exista!
		etx.commit();
		em.close();		
        return user;
	}
	
}
