package fr.afcepf.ai103.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * DANS MVC (ou MVC2) : ce servlet joue le rôle de contrôleur principal 
 * "FrontController" : c'est lui qui traite en premier les requêtes HTTP.
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
    //<input type="hidden" name="task" value="client" />
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		switch(task) {
		case "client" :
			 doSaveClient(request,response);
			 break;
		/*case "tva" : 
			 doCalculTva(request,response);
			 break;*/
		}
	}
	
	protected void doSaveClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //...
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
