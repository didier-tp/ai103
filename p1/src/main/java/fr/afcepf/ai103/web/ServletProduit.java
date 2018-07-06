package fr.afcepf.ai103.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.ai103.tpJdbc.IProductDao;
import fr.afcepf.ai103.tpJdbc.ProductDaoJdbc;
import fr.afcepf.ai103.tpJdbc.Produit;

/**
 * Servlet implementation class ServletProduit
 */
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPrixMaxi = request.getParameter("prixMaxi");
		double prixMaxi = (sPrixMaxi!=null && !sPrixMaxi.isEmpty())?Double.parseDouble(sPrixMaxi):99999999.0;
		String format = request.getParameter("format");
		PrintWriter out = response.getWriter();

		IProductDao productDao = new ProductDaoJdbc();
		List<Produit>  listeProduits = productDao.rechercherProduits();
		
		List<Produit> listeProdPasCher = new ArrayList<Produit>();
		for(Produit prod  : listeProduits)
			if(prod.getPrix() <=  prixMaxi )
				listeProdPasCher.add(prod);
		
		if(format==null || format.equals("html")) {
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("<table border='1'>");
			out.println("<tr><th>numero</th><th>label</th><th>prix</th></tr>");
			for(Produit p : listeProdPasCher) {
				out.println("<tr><td>"+p.getNumero()+"</td><td>"+p.getLabel()
				           +"</td><td>"+p.getPrix()+"</td></tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		}
		else if(format!=null && format.equals("json")) {
		
		ObjectMapper mapper = new ObjectMapper();
		//com.fasterxml.jackson.databind.ObjectMapper est une classe prédéfinie de jackson-databind qui sert à générer du json
		String listeProdAsJsonString = mapper.writeValueAsString(listeProdPasCher);
		out.println(listeProdAsJsonString);
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
