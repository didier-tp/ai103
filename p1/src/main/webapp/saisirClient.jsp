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
       Client client = (Client) request.getAttribute("client");
       if(client==null) client = new Client();
       %>
       <p style="color:red;"><%=message%></p>
       <form action="./ServletController" method="post">
           <input type="hidden" name="task" value="client" />
           nom: <input name="nom" value="<%=client.getNom()%>" /><br/>
           prenom: <input name="prenom" value="<%=client.getPrenom()%>" /><br/>
           email: <input name="email" value="<%=client.getEmail()%>" /><br/>
           age: <input name="age" value="<%=client.getAge()%>" /><br/>
           <input type="submit" value="enregistrer" />
       </form>
</body>
</html>