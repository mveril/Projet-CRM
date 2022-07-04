<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'une commande</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
<div class="form">
		<form method="post" action="<c:url value="/ajouterOrder"/>">	
		<fieldset>
			<legend> Créer une commande</legend>
			
			<label for="idClient"> Choississez un client : </label>
			
			<select name="idClient" id="idClient">
			<c:forEach items="${ clients }" var="client">
			<option value="${client.id}"><c:out value="${ client.firstName } ${ client.lastName }"/>
			</option>
			</c:forEach>
			</select>
			
			<label for="typePresta"> Type de Prestation</label>
			<input type="text" id="typePresta" name="typePresta" size="20" />
			
			<label for="designation"> Designation de la prestation</label>
			<input type="text" id="designation" name="designation" size="20" />
			
			<label for="nbDays"> Nombre de jours</label>
			<input type="number" id="nbDays" name="nbDays" size="20" />
			
			<label for="unitPrice"> Prix unitaire</label>
			<input type="number" id="unitPrice" name="unitPrice" size="20" />
			
			<label for="state"> Etat de le prestation</label>
			<input type="number" id="state" name="state" size="20" />

		</fieldset>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre a zero " />

		</form>
	</div>
</body>
</html>