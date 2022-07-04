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


	<div class="view">

		<form method="post"
			action="<c:url value="/modifierLivre"><c:param name="id" value="${order.id}"/></c:url>">
			<fieldset>
				<legend> Modifier Order </legend>

				<select id="clientOrder" name="clientOrder">
					<c:forEach items="${ clients }" var="client">
						<option value="<c:out value="${ client.id }"/>"
							${ client.id == order.client.id ? "selected" : "" }><c:out
								value="${ auteur.firstName }" />
							<c:out value="${ client.Name }" /></option>
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
				value="Remettre à zero " />

		</form>


	</div>


	<input type="submit" value="Valider" />
	<input type="reset" value="Remettre à zéro" />
	



</body>
</html>