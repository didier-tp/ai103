<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.afcepf.ai103.web.model.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>clientOk</title>
</head>
<body>
     <%
     //Client cli = (Client) /*request.*/session.getAttribute("client");
     //et afichage avec <%= ...
     %>
     client bien enregistré : <i>${client.prenom}</i> , <b>${client.nom}</b> , 
                              <i>${client.email}</i> , <b>${client.age}</b>
     <hr/>      
     <a href="index.html">retour vers index.html</a>
</body>
</html>