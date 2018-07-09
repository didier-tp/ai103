package fr.afcepf.ai103.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.ai103.web.model.Client;

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
	  Client client = new Client();
	  String pageSuite="/clientOk.jsp"; //"/clientOk.jsp" ou "/saisirClient.jsp" vers lequel faire redirection
	  String message=""; //éventuel message d'erreur (ex: age invalide)
	  client.setNom(request.getParameter("nom"));
	  client.setPrenom(request.getParameter("prenom"));
	  client.setEmail(request.getParameter("email"));
	  String sAge = request.getParameter("age");
	  try {
		  client.setAge(Integer.parseInt(sAge));
	  } catch(NumberFormatException ex) {
		  message=sAge + " = age invalide";
		  pageSuite = "/saisirClient.jsp";
	  }
	  request.setAttribute("client", client); //on stocke dans request ou session des choses
	  request.setAttribute("message", message); //qui seront accessibles depuis les vues (pages JSP)
	  RequestDispatcher rd ; 
	  rd = this.getServletContext().getRequestDispatcher(pageSuite);
	  rd.forward(request, response); //redirection interne vers page JSP , 
	  //c'est la page JSP qui continue à générer la page HTML de réponse
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
