package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Departement;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/dept")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EntityManagerFactory factory;
	public EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		factory = Persistence.createEntityManagerFactory("Legion");
		em = factory.createEntityManager();
		
		Departement dept = em.find(Departement.class, code);
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("resultat de la requete => " + code + "<br />");
		pw.println("resultat de la requete => " + dept.getNom() );
		pw.println("</body></html>");
		pw.close();
		
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept-view.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		factory = Persistence.createEntityManagerFactory("Legion");
		em = factory.createEntityManager();
		
		Departement dept = em.find(Departement.class, code);
	
		//Envoie en requete l'objet departement et l'envoie vers la vue dept-view.jsp
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("dept-view.jsp").forward(request, response);
	}

}
