package data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class databaseListener
 *
 */
@WebListener
public class databaseListener implements ServletContextListener {

	public EntityManagerFactory factory;
    /**
     * Default constructor. 
     */
    public databaseListener() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	factory = Persistence.createEntityManagerFactory("Legion");
        sce.getServletContext().setAttribute("factory", factory);
    }
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 

    	factory.close();
    }

	
	
}
