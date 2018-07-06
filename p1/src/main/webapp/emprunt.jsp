<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>emprunt</title>
</head>
<body>
 <%
 double mensualite = 0.0;
 String sMontant = request.getParameter("montant");
 String sNbMois = request.getParameter("nbMois");
 String sTauxInteret = request.getParameter("tauxInteret");
 if(sMontant!=null /* && ... */ ){
	 double montant = Double.parseDouble(sMontant);
	 double nbMois = Double.parseDouble(sNbMois);
	 double tauxInteretAnnuel = Double.parseDouble(sTauxInteret);
	 double tauxInteretMensuel = tauxInteretAnnuel / 12;
	 mensualite = (montant * tauxInteretMensuel)  / (1 -  Math.pow(1+tauxInteretMensuel , -nbMois));
 }

 %>
 <form method="get" > <!-- sans action="url_a_declencher" la page se rappelle elle meme -->
    montant : <input name="montant"><br/>
    duree (nbMois) : <input name="nbMois"><br/>
    tauxInteret : <input name="tauxInteret"><br/>
    <input type="submit" value="calculer" />
 </form>
  
  mensualite =  <b><%=mensualite%></b>

</body>
</html>