package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Region;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/region")
public class RegionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;
	private EntityManager em;
	private Region region;
	private String code;
	private Integer choixRegion, noRegion, surface;
	private List<Region> regions;
	private Locale locale;
	private ResourceBundle lang; 
	private Query q;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//factory = Persistence.createEntityManagerFactory("Legion");
		factory = (EntityManagerFactory) getServletContext().getAttribute("factory");
		em = factory.createEntityManager();
		
		locale = new Locale("fr");
		 if(request.getParameter("btnFr") != null) {
			 locale = new Locale("fr");
		 }
		 if(request.getParameter("btnEn") != null) {
			 locale = new Locale("en");
		 }
		 if(request.getParameter("btnIt") != null) {
			 locale = new Locale("it");
		 }
		 if(request.getParameter("btnDe") != null) {
			 locale = new Locale("de");
		 }
	
		lang = ResourceBundle.getBundle("labels", locale);
		
		q = em.createQuery("select r from Region r ");
		regions =  (List<Region>) q.getResultList();

		if(request.getParameter("code") != null) {
			code = request.getParameter("code");
			region = em.find(Region.class, Integer.parseInt(code));
		} else {
				region = new Region();
		}
		
		if(request.getParameter("choixRegion") != null && request.getParameter("choixRegion") != "" ) {
			choixRegion = Integer.parseInt(request.getParameter("choixRegion"));
			region = em.find(Region.class, choixRegion);
		} 

		if(request.getParameter("btnAdd") != null) {
			region = new Region();
		}
		
		if(request.getParameter("btnDelete") != null) {
			
			noRegion = Integer.parseInt(request.getParameter("noRegion"));
			region = em.find(Region.class, noRegion);
			
			em.getTransaction().begin();
			em.remove(region);
			em.getTransaction().commit();
		}
		
		if(request.getParameter("btnSave") != null) {
			/**
			 * 
			 * choixRegion=&
			 * noRegion=666&
			 * nomRegion=HightWay++to+hell&
			 * surfaceRegion=5649&
			 * descriptionRegion=ijzrghuetblmkgub+qejh+gnull&
			 * wikiRegion=http%3A%2F%2F&
			 * btnAdd=Ajouter
			 * 
			 * 
			 */
			noRegion = Integer.parseInt(request.getParameter("noRegion"));
			surface = Integer.parseInt(request.getParameter("surfaceRegion"));
			
			region = em.find(Region.class, noRegion);
			if(region == null) {
				region = new Region();
			}
			
			region.setNoRegion(noRegion);
			region.setNom(request.getParameter("nomRegion"));
			region.setSurface(surface);
			region.setDescription(request.getParameter("descriptionRegion"));
			region.setUrlWiki(request.getParameter("wikiRegion"));
			
			
			em.getTransaction().begin();
			em.persist(region);
			em.getTransaction().commit();

		}
		

		request.setAttribute("region", region);
		request.setAttribute("listRegion", regions);
		request.setAttribute("lang", lang);
		//request.getRequestDispatcher("regionView.jsp").forward(request, response);
		request.getRequestDispatcher("regionViewB.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
