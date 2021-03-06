<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>liste des clients</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />

<button class="bouton"><a href="<c:url value="/ajouterClient" />">Ajouter un client</a></button>

<div class="liste"></div>
<c:choose>

				  <c:when test="${ empty clients }">
				 <p>Aucun client trouv?...</p>
			</c:when>  
			<c:otherwise>
				<table>
					<tr>
						<th>Nom de la compagnie</th>
						<th>Prenom</th>
						<th>Nom</th>
						<th colspan="3">Actions<th>
						
					</tr>
					<tbody>
						<c:forEach items="${ clients }" var="client">
							<tr>
								<td><c:out value="${ client.companyName }" /></td>
								<td><c:out value="${ client.firstName }" /></td>
								<td><c:out value="${ client.lastName }" /></td>

								<td><a href="<c:url value="/detailsClient"><c:param name="id" value="${ client.id }" /></c:url>">Voir</a></td>
								<td><a href="<c:url value="/modifierClient"><c:param name="id" value="${ client.id }" /></c:url>">Modifier</a></td>
								<td><a href="<c:url value="/supprimerClient"><c:param name="id" value="${ client.id }" /></c:url>">Supprimer</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	
</body>	