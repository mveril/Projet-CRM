<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Orders</title>

</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
</br>
<button><a href="<c:url value="/ajouterOrder" />">Ajouter une commande</a></button>

	<div class="view">
	
		<c:choose>
			<c:when test="${ empty orders }">
				<p>Aucune Commande trouv�e...</p>
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Type de prestation</th>
							<th>Designation</th>
							<th colspan="3">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ orders }" var="order">
							<tr>
								<td><c:out value="${ order.typePresta }" /></td>
								<td><c:out value="${ order.designation }" /></td>
								
							<td><a href="<c:url value="/detailsOrder"><c:param name="id" value="${ order.id }" /></c:url>">Voir</a></td>
							<td><a href="<c:url value="/modifierOrder"><c:param name="id" value="${ order.id }" /></c:url>">Modifier</a></td>
							<td><a href="<c:url value="/supprimerOrder"><c:param name="id" value="${ order.id }" /></c:url>">Supprimer</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>