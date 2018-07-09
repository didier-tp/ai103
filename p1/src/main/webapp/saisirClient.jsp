<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>saisirClient</title>
</head>
<body>
       <form action="./ServletController" method="post">
           <input type="hidden" name="task" value="client" />
           nom: <input name="nom" /><br/>
           prenom: <input name="prenom" /><br/>
           email: <input name="email" /><br/>
           age: <input name="age" /><br/>
           <input type="submit" value="enregistrer" />
       </form>
</body>
</html>