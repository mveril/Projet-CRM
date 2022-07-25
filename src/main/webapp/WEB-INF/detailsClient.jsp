<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail client</title>
</head>
<body class="detail">

			<c:import url="/WEB-INF/menu.jsp" />
		
	
		<h2> Détails de ${ client.firstName } ${ client.lastName } </h2>
		
		<c:choose>
			<c:when test="${ empty client }">
			Le client recherché n'existe pas
			</c:when>
			<c:otherwise>
			<table>
			<thead>
				<tr>
					<th>Compagnie</th>
					<th>Email</th>
					<th>Téléphone</th>
					<th>Adresse</th>
					<th>Zip code</th>
					<th>Pays</th>
					<th>Ville</th>
					<th>Etat du client</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ client.companyName }"/></td>
					<td><c:out value="${ client.email }"/></td>
					<td><c:out value="${ client.phone }"/></td>
					<td><c:out value="${ client.address }"/></td>
					<td><c:out value="${ client.zipCode }"/></td>
					<td><c:out value="${ client.country }"/></td>
					<td><c:out value="${ client.city }"/></td>
					<td><c:out value="${ client.state }"/></td>
				</tr>
			</tbody>
			</table>

			</c:otherwise>
	</c:choose>		
	
	
	<div><a class="link" href="<c:url value="/listeClients" />">Retour à la liste des clients</a></div>
	
</body>
</html>