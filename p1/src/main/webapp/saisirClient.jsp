<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.afcepf.ai103.web.model.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saisirClient</title>
</head>
<body>
       <%
       String message = (String) request.getAttribute("message");
       if(message==null) message="";
       %>
       <p style="color:red;"><%=message%></p>
       <form action="./ServletController" method="post">
           <input type="hidden" name="task" value="client" />
           nom: <input name="nom" value="${client.nom}" /><br/>
           prenom: <input name="prenom" value="${client.prenom}" /><br/>
           email: <input name="email" value="${client.email}" /><br/>
           age: <input name="age" value="${client.age}" /><br/>
           <input type="submit" value="enregistrer" />
       </form>
</body>
</html>