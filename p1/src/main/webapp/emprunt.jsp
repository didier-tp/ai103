<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>emprunt</title>
</head>
<body>
 <% //valeurs par défaut:
 double montant = 2000;
 double nbMois = 24;
 double tauxInteretAnnuel = 1.1;
 double mensualite = 0.0;
 
 Date d =new Date();
 
 String sMontant = request.getParameter("montant");
 String sNbMois = request.getParameter("nbMois");
 String sTauxInteret = request.getParameter("tauxInteret");
 if(sMontant!=null /* && ... */ ){
	 montant = Double.parseDouble(sMontant);
	 nbMois = Double.parseDouble(sNbMois);
	 tauxInteretAnnuel = Double.parseDouble(sTauxInteret); //en pct
	 double tauxInteretMensuel = (tauxInteretAnnuel / 100) / 12;
	 mensualite = (montant * tauxInteretMensuel)  / (1 -  Math.pow(1+tauxInteretMensuel , -nbMois));
 }
 %>
 <form method="get" > <!-- sans action="url_a_declencher" la page se rappelle elle meme -->
    montant : <input name="montant"  value="<%=montant%>"><br/>
    duree (nbMois) : <input name="nbMois" value="<%=nbMois%>"><br/>
    tauxInteret : <input name="tauxInteret" value="<%=tauxInteretAnnuel%>"><br/>
    <input type="submit" value="calculer" />
 </form>
  mensualite =  <b><%=mensualite%></b>
  <hr/>
  <%=d %>
</body>
</html>