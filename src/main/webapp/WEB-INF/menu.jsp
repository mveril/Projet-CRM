<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
 
<nav>
    <table class="menu">
    <thead>
    <tr>
      	<td><a href="<c:url value="/" />">Accueil</a></td>
      	
      	<td><a href="<c:url value="/listeClients" />">Liste des clients</a></td>
      	
      	<td><a href="<c:url value="/listeCommandes" />">Liste des commandes</a></td>
    </tr>
    </thead>
    </table>
</nav>