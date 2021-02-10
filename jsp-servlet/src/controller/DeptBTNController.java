package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Departement;
import model.Region;

/**
 * Servlet implementation class DeptBTNController
 */
@WebServlet("/deptbtn")
public class DeptBTNController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;
	private EntityManager em;
	private Departement dept;
	private Region region;
	public String code;   

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptBTNController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		factory = (EntityManagerFactory) getServletContext().getAttribute("factory");
		em = factory.createEntityManager();
		
		if(request.getParameter("btnAdd") != null) {
			System.out.println("choucroute");
			dept = new Departement();
		}
		
		if(request.getParameter("btnDelete") != null) {
			dept = em.find(Departement.class, request.getParameter("noDept"));
			em.getTransaction().begin();
			em.remove(dept);
			em.getTransaction().commit();
		}
		
		if(request.getParameter("btnSave") != null) {
			
			int noRegion = Integer.parseInt(request.getParameter("noRegion"));
			region = em.find(Region.class, noRegion);
			
			dept.setNoDept(request.getParameter("noDept"));
			dept.setNoRegion(noRegion);
			dept.setRegion(region);
			dept.setNom(request.getParameter("nom"));
			dept.setNomStd(request.getParameter("nomStd"));
			dept.setSurface(Integer.parseInt(request.getParameter("surface")));
			dept.setNbHabitants(Integer.parseInt(request.getParameter("nbHabitants")));
			dept.setUrlWiki(request.getParameter("url_wiki"));
			
			em.getTransaction().begin();
			em.persist(dept);
			em.getTransaction().commit();
			
			
		}
		
		if(request.getParameter("code") != null) {
			code = request.getParameter("code");
			dept = em.find(Departement.class, code);
			if(dept == null) {
				dept = new Departement();
			}
		}

		
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept-view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		factory = (EntityManagerFactory) getServletContext().getAttribute("factory");
		em = factory.createEntityManager();
		
		
		if(request.getParameter("code") != null) {
			code = request.getParameter("code");
			dept = em.find(Departement.class, code);
		}

		
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept-view.jsp").forward(request, response);
	}
	

}
