package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import clasesDAO.FactoryDAO;
import clasesDAO.GlobalConfigDAO;

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
    	WebApplicationContext context = WebApplicationContextUtils
                .getWebApplicationContext(arg0.getServletContext());
    	//AutowireCapableBeanFactory ctx = context.getAutowireCapableBeanFactory();
        //ctx.autowireBean(this);
    	
    	//context.getBean(GlobalConfigDAO.class);
    	FactoryDAO.test(context);
    	
    	/*if(FactoryDAO.getUsers().getCount()==0){   		
    		FactoryDAO.initialize();
    	}*/
    }
	
}
