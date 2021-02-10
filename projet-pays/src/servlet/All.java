package servlet;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Pays;

/**
 * Servlet implementation class All
 */
@WebServlet("/all")
public class All extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EntityManagerFactory factory;
	public EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		factory = Persistence.createEntityManagerFactory("Legion");
		em = factory.createEntityManager();
		
		try {
			Query query = em.createQuery("select p from Pays p");
			List<Pays> pays = (List<Pays>) query.getResultList();
			
			JSONArray jsonResult = new JSONArray();
			for(Pays p : pays) {
				JSONObject jsonPays = new JSONObject();
				jsonPays.put("iso2", p.getIso2());
				jsonPays.put("iso3", p.getIso3());
				jsonPays.put("name", p.getNom());
				System.out.println(p.getNom());
				
				
			}

        	JSONObject jsonResponse = new JSONObject();
        	jsonResponse.put("result", jsonResult);
        	jsonResponse.put("status", "ok");
        	jsonResponse.put("message", "");
        	
        	
        	JSONObject json = new JSONObject();
        	json.put("response", jsonResponse);
        	
        	response.setContentType("text/json");
        	response.getWriter().print(json.toString());
			
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
