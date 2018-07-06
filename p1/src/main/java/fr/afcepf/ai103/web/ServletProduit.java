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
		double prixMaxi = (sPrixMaxi!=null && !sPrixMaxi.isEmpty())?Double.parseDouble(sPrixMaxi):0.0;
		
		
		//response.setContentType("text/html");
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		Produit prod1 = new Produit(1L,"prod1",1.0);
		Produit prod2 = new Produit(2L,"prod2",2.0);
		List<Produit> listeProd = new ArrayList<Produit>();
		listeProd.add(prod1);  listeProd.add(prod2);
		/*
		out.println("<html><body>");
		out.println("<p>...</p>");
		out.println("</body></html>");
		*/
		ObjectMapper mapper = new ObjectMapper();
		String listeProdAsJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listeProd);
		out.println(listeProdAsJsonString);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
