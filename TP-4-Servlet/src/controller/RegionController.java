package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
	private List<Region> regions;
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
		
		q = em.createQuery("select r from Region r ");
		regions =  (List<Region>) q.getResultList();

		if(request.getParameter("code") != null) {
			code = request.getParameter("code");
			region = em.find(Region.class, Integer.parseInt(code));
		} else {
				region = new Region();
		}
		

		request.setAttribute("region", region);
		request.setAttribute("listRegion", regions);
		
		request.getRequestDispatcher("regionView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAdd") != null) {
			
			region = new Region();
		}
		
		if(request.getParameter("btnDelete") != null) {
			region = em.find(Region.class, request.getParameterValues("noRegion"));
			em.getTransaction().begin();
			em.remove(region);
			em.getTransaction().commit();
		}
		
		if(request.getParameter("btnSave") != null) {
			
			int noRegion = Integer.parseInt(request.getParameter("noRegion"));
			int surface = Integer.parseInt(request.getParameter("surfaceRegion"));
			
			region = em.find(Region.class, noRegion);
			
			region.setNoRegion(noRegion);
			region.setNom(request.getParameter("nomRegion"));
			region.setSurface(surface);
			region.setDescription(request.getParameter("descriptionRegion"));
			region.setUrlWiki(request.getParameter("wikiRegion"));
			
			
			em.getTransaction().begin();
			em.persist(region);
			em.getTransaction().commit();
			
			
		}
		
		q = em.createQuery("select r from Region r ");
		regions =  (List<Region>) q.getResultList();
		request.setAttribute("listRegion", regions);
		request.getRequestDispatcher("regionView.jsp").forward(request, response);
	}

}
