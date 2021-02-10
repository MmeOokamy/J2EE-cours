/*
 * package listeners;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.EntityManagerFactory; import
 * javax.servlet.ServletContextEvent; import
 * javax.servlet.ServletContextListener; import
 * javax.servlet.annotation.WebListener;
 * 
 *//**
	 * Application Lifecycle Listener implementation class SessionListener
	 *
	 */
/*
 * @WebListener public class SessionListener implements ServletContextListener {
 * 
 *//**
	 * Default constructor.
	 */
/*
 * public SessionListener() { // TODO Auto-generated constructor stub }
 * 
 *//**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
/*
 * public void contextDestroyed(ServletContextEvent sce) {
 * System.out.println("Context Initialized");
 * 
 * // Créer un EntityManager pour toutes les servlets: EntityManagerFactory emf
 * = javax.persistence.Persistence.createEntityManagerFactory("Legion");
 * EntityManager em = emf.createEntityManager();
 * 
 * // Stocker cet EntityManager dans le contexte (pour le partager) :
 * 
 * sce.getServletContext().setAttribute("emf", emf);
 * sce.getServletContext().setAttribute("em", em); }
 * 
 *//**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 *//*
		 * public void contextInitialized(ServletContextEvent sce) {
		 * System.out.println("Context destroyed"); EntityManager em = (EntityManager)
		 * sce.getServletContext().getAttribute("em"); EntityManagerFactory emf =
		 * (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
		 * em.close(); emf.close(); }
		 * 
		 * }
		 */