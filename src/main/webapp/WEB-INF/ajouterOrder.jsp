<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="form">
		<form method="post" action="<c:url value="/ajouterOrder"/>">
		
		<fieldset>
				<legend>Ajouter Order</legend>
				
				<label for="idAuteurLivre">Choississez l'auteur :</label>

				<select name="idAuteurLivre" id="idAuteurLivre">
				    <c:forEach items="${ auteurs }" var="auteur">
				    <option value="${auteur.id}"><c:out value="${auteur.prenom } ${auteur.nom }"/></option>
				    </c:forEach>
				</select>

				<label for="titreLivre">Titre</label>
				<input type="text" id="titreLivre" name="titreLivre" size="20" />
				<br/>

				<label for="nbPagesLivre">Nombre de pages</label>
				<input type="number" id="nbPagesLivre" name="nbPagesLivre" size="10" />
				<br/>

				<label for="categorieLivre">Catégorie</label>
				<input type="text" id="categorieLivre" name="categorieLivre" size="60" />
				<br/>

			</fieldset>	
		
			<fieldset>
				<legend> Ajouter Order </legend>

				<select name="clientOrder" id="clientOrder">
				<c:forEach items="${ clients }" var="client">
				<option value="<c:out value="${ client.id }"/>"	${ client.id == order.client.id ? "selected" : "" }>
				<c:out
								value="${ client.firstName }" />
							<c:out value="${ client.lastName }" /></option>
					</c:forEach>
					
				</select> <br /> <label for="typePresta"> typePresta </label> <input
					type="text" id="typePresta" name="typePresta"
					value="${order.typePresta }" /> <br /> <label for="designation">
					designation </label> <input type="text" id="designation"
					name="nbPagesLivre" value="${ order.designation }" /> <br /> <label
					for="nbDays">nbDays </label> <input type="text" id="nbDays"
					name="nbDays" value="${ order.nbDays }" /> <br /> <label
					for="unitPrice">unitPrice </label> <input type="text"
					id="unitPrice" name="unitPrice" value="${ order.unitPrice }" /> <br />

				<label for="state">state </label> <input type="text" id="state"
					name="state" value="${ order.state }" /> <br />

			</fieldset>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre � zero " />
				
				






		</form>


	</div>
	
	






</body>
</html>