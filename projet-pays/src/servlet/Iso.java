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

import org.json.JSONObject;

import model.Pays;

/**
 * Servlet implementation class Iso
 */
@WebServlet("/iso")
public class Iso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public EntityManagerFactory factory;
	public EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Iso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code").toUpperCase();
		factory = Persistence.createEntityManagerFactory("Legion");
		em = factory.createEntityManager();
		//EntityManager em = (EntityManager) getServletContext().getAttribute("em");
       
        Pays pays = em.find(Pays.class, code);
        //PrintWriter pw = response.getWriter();
		//pw.println("<html><body>");
		//pw.println("resultat de la requete => " + code + "<br />");
		//pw.println("resultat de la requete => " + pays.getIso2() + " " + pays.getIso3() + " " + pays.getNom());
		//pw.println("</body></html>");
		//pw.close();
        
        try {
        	response.setContentType("text/json");
        	JSONObject jsonResult = new JSONObject();
        	jsonResult.put("iso2", pays.getIso2());
        	jsonResult.put("iso3", pays.getIso3());
        	jsonResult.put("name", pays.getNom());
        	
        	JSONObject jsonResponse = new JSONObject();
        	jsonResponse.put("status", "ok");
        	jsonResponse.put("message", "");
        	jsonResponse.put("result", jsonResult);
        	
        	JSONObject json = new JSONObject();
        	json.put("response", jsonResponse);
        	response.getWriter().print(json.toString());
        	
        } catch(Exception ex) {
        	ex.printStackTrace();
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
