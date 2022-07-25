<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>liste des clients</title>
</head>
<body class="list">
<c:import url="/WEB-INF/menu.jsp" />

<button class="bouton"><a href="<c:url value="/ajouterClient" />">Ajouter un client</a></button>

<div class="liste"></div>
<c:choose>

				  <c:when test="${ empty clients }">
				 <p>Aucun client trouvé...</p>
			</c:when>  
			<c:otherwise>
				<table>
					<tr>
						<th>Nom de la compagnie</th>
						<th>Prénom</th>
						<th>Nom</th>
						<th colspan="3">Actions<th>
						
					</tr>
					<tbody>
						<c:forEach items="${ clients }" var="client">
							<tr>
								<td><c:out value="${ client.companyName }" /></td>
								<td><c:out value="${ client.firstName }" /></td>
								<td><c:out value="${ client.lastName }" /></td>
						    <td><a href="<c:url value="/detailsClient"><c:param name="id" value="${ client.id }" /></c:url>">  Voir <i class="fas fa-eye" title="CLIQUEZ POUR VOIR LES DETAILS D'UN CLIENT"></i> </i> </a></td>
						    <td><a href="<c:url value="/modifierClient"><c:param name="id" value="${ client.id }" /></c:url>">Modifier <i class="fas fa-edit" title="CLIQUEZ POUR MODIFIER UN CLIENT"></i></a></td>
						    <td><a href="<c:url value="/supprimerClient"><c:param name="id" value="${ client.id }" /></c:url>">Supprimer <i class="fa fa-trash" title="CLIQUEZ POUR SUPPRIMER UN CLIENT"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	
</body>	