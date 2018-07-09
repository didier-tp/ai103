<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addInCaddy</title>
</head>
<body>
    <%    int nbElts = 0;
    String selProduit = request.getParameter("selProduit");
    if(selProduit!=null){
    	List<String> caddy = (List<String>) session.getAttribute("caddy");
    	if(caddy == null){
    		caddy = new java.util.ArrayList<String>();
    		session.setAttribute("caddy", caddy);
    	}
    	caddy.add(selProduit); 	nbElts = caddy.size();
    }
    %>
    <form>  produit:<select name="selProduit">
          <option>cahier</option>
          <option>stylo</option>
      </select>
      <input type="submit" value="addInCaddy"/>
    </form>    <hr/>
    nombre d'éléments dans le caddy : <%=nbElts%>
    <hr/>
    <a href="visuCaddy.jsp">visualiser le contenu du caddy</a>
    
</body>
</html>