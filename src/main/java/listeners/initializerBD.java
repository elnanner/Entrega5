package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import clasesDAO.FactoryDAO;

/**
 * Application Lifecycle Listener implementation class initializerBD
 *
 */
@WebListener
public class initializerBD implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public initializerBD() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	if(FactoryDAO.getUsers().getCount()==0){
    		FactoryDAO.initialize();
    	}
    }
	
}
