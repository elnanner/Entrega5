package clasesDAO.JPAHibernate;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import clases.Board;

public class BoardDAOHibernate extends GenericDAOJPAHibernate<Board>{
	
	public BoardDAOHibernate(){
		super(Board.class);
	}
	
	public Boolean existBoard(){
		return true; //hacer
	}
	
	public Board getBoardCall(String name){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q=em.createQuery("SELECT b from "+Board.class.getSimpleName() +" b where name = ?1 ");
		q.setParameter(1,name);
		Board board=(Board) (q.getResultList().get(0)); //OJO, SIEMPRE PREGUNTAR ANTES SI EXISTE..
		etx.commit();
		em.close();		
		return board;
	}
	
	//getBoardByName
	
	//getIdBoardName

}
