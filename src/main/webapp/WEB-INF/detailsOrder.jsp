<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail commandes</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />
	

	<div>Détail de la commande</div>
	
			<table>
			<thead>
				<tr>
					<th>Client</th>
					<th>Type de prestation</th>
					<th>Désignation</th>
					<th>Nombre de jours</th>
					<th>Prix unitaire</th>
					<th>Etat de la commande</th>
					<th>Prix HT</th>
					<th>Prix TTC</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ order.client.firstName }" /><c:out value="${ order.client.lastName }" /></td>
					<td><c:out value="${ order.typePresta }" /></td>
					<td><c:out value="${ order.designation }" /></td>
					<td><c:out value="${ order.nbDays }" /></td>
					<td><c:out value="${ order.unitPrice }" /></td>
					<td><c:out value="${ order.state }" /></td>
					<td><c:out value="${ order.totalExcludeTaxe }" /></td>
					<td><c:out value="${ order.totalWithTaxe }" /></td>
				</tr>
			</tbody>
		</table>
		
			<div><a href="<c:url value="/listeOrders" />">Retour à la liste des commandes</a></div>
		

</body>
</html>