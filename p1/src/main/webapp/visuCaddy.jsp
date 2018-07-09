<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
<%
List<String> objCaddy = (List<String>) session.getAttribute("caddy");
%>
<h3>contenu du caddy</h3>
<table border="1">
    <%if(objCaddy!=null) {
    	for(String sProd : objCaddy){
    		%>
    		<tr><td><%=sProd%></td></tr>
            <% 		
    	}
    } 
    %>
</table> 
<hr/>
<table border="1">
  <c:forEach items="${sessionScope.caddy}"  var="sProduct" >
    		<tr><td>${sProduct}</td></tr>
  </c:forEach>
</table> 

</body>
</html>