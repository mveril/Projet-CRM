<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier commande</title>
</head>
<body>


	<div class="view">

		<form method="post"
			action="<c:url value="/modifierOrder"><c:param name="id" value="${order.id}"/></c:url>">
			<fieldset>
				<legend> Modifier Order </legend>

				<select id="clientId" name="clientId">
					<c:forEach items="${ clients }" var="client">
						<option value="<c:out value="${ client.id }"/>"${ client.id == order.client.id ? "selected" : "" }>
						<c:out value="${ client.firstName }" /> <c:out value="${ client.lastName }" />
						</option>
					</c:forEach>
				</select>  
				<div>
					<label for="typePresta"> typePresta </label> 
					<input type="text" id="typePresta" name="typePresta" value="${order.typePresta }" /> 
				</div>
				<div>
					<label for="designation"> designation </label> 
					<input type="text" id="designation" name="designation" value="${ order.designation }" />
				</div>
				<div>
					<label for="nbDays">nbDays </label> 
					<input type="text" id="nbDays" name="nbDays" value="${ order.nbDays }" />
				</div>
				<div>
					<label for="unitPrice">unitPrice </label>
					<input type="text" id="unitPrice" name="unitPrice" value="${ order.unitPrice }" />
				</div>
				<div>
					<label for="state">state </label>
					<input type="text" id="state" name="state" value="${ order.state }" />
				</div>    

			</fieldset>

			<input type="submit" value="Valider" /> <input type="reset" value="Remettre à zero " />

		</form>

	</div>

</body>
</html>