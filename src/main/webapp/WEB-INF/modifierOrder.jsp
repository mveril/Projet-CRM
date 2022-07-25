<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier commande</title>
</head>
<body class="list">
<c:import url="/WEB-INF/menu.jsp" />

	<div class="view">

		<form method="post" action="<c:url value="/modifierOrder"><c:param name="id" value="${order.id}"/></c:url>">	
		<fieldset>
			<legend> Modifier une commande</legend>
			
				<c:import url="/WEB-INF/OrderFields.jsp" />
				
				
		</fieldset>

			<input type="submit" value="Valider" /> 
			<input type="reset" value="Remettre a zero " />

		</form>

	</div>

</body>
</html>