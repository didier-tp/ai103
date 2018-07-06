package fr.afcepf.ai103.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTva
 */
public class ServletTva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sHt = request.getParameter("ht");
		double ht = (sHt!=null && !sHt.isEmpty())?Double.parseDouble(sHt):0.0;
		String sTaux = request.getParameter("taux");
		double taux = (sTaux!=null && !sHt.isEmpty())?Double.parseDouble(sTaux):0.0;
		
		double tva =  ht * taux / 100;
		double ttc = ht + tva;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<p>ht:" + ht + "</p>");
		out.println("<p>taux:" + taux + "</p>");
		out.println("<p>tva:" + tva + "</p>");
		out.println("<p>ttc:" + ttc + "</p>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
