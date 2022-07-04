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
</br>
<div class="liste"></div>
<c:choose>

				  <c:when test="${ empty clients }">
				 <p>Aucun client trouvé...</p>
			</c:when>  
			<c:otherwise>
				<table>
					<tr>
						<th>CompanyName</th>
						<th>FirstName</th>
						<th>LastName</th>
						
					</tr>
					<tbody>
						<c:forEach items="${ clients }" var="client">
		
								<td><c:out value="${ client.companyName }" /></td>
								<td><c:out value="${ client.firstName }" /></td>
								<td><c:out value="${ client.lastName }" /></td>

								<%-- <td>
									<a href="<c:url value="/detailsAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">Voir</a>
									 | 
									<a href="<c:url value="/modifierAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">Modifier</a>
									 | 
									<a href="<c:url value="/supprimerAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">Supprimer</a>
								</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>